package org.transformers.aop.demo.proxy;

import org.transformers.aop.demo.interceptor.Interceptor;
import org.transformers.aop.demo.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 把服务和拦截器的方法织入约定的流程中
 */
public class ProxyBean implements InvocationHandler {
    private Object target;
    private Interceptor interceptor;

    /**
     * 绑定代理对象
     *
     * @param target      被代理对象
     * @param interceptor 拦截器
     * @return 代理对象
     */
    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        // 保存被代理对象
        proxyBean.target = target;
        // 保存拦截器
        proxyBean.interceptor = interceptor;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                proxyBean);
        // 返回代理对象
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 异常标识
        boolean execeptionFlag = false;
        // 把target写成了proxy，陷入循环递归错误
        // Invocation invocation = new Invocation(args, method, proxy);
        Invocation invocation = new Invocation(args, method, target);
        Object retObj = null;
        try {
            if (this.interceptor.before() && this.interceptor.useAround()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }
        } catch (Exception e) {
            execeptionFlag = true;
        }
        this.interceptor.after();
        if (execeptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
