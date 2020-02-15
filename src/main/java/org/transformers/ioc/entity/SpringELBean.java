package org.transformers.ioc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringELBean {

    /**
     * SpringELBean
     * {
     *     initTime=1581778892620,
     *     str='使用Spring EL赋值字符串',
     *     d=9200.0,
     *     pi=3.14,
     *     otherBeanProp='Smith',
     *     otherBeanPropUp='NOTE',
     *     run=3,
     *     idFlag=false,
     *     strFlag=true,
     *     strApp='hello Smith, welcome.',
     *     result='lt'
     * }
     */

    @Value("#{T(System).currentTimeMillis()}")
    private Long initTime;

    @Value("#{'使用Spring EL赋值字符串'}")
    private String str;

    @Value("#{9.2E3}")
    private Double d;

    @Value("#{3.14}")
    private float pi;

    @Value("#{user.userName}")
    private String otherBeanProp;

    @Value("#{user.note?.toUpperCase()}")
    private String otherBeanPropUp;

    @Value("#{1+2}")
    private int run;

    @Value("#{user.id == 2L}")
    private boolean idFlag;

    @Value("#{user.userName eq 'Smith'}")
    private boolean strFlag;

    @Value("#{'hello ' + user.userName + ', welcome.'}")
    private String strApp;

    @Value("#{user.id > 2 ? 'gt' : 'lt'}")
    private String result;

    @Override
    public String toString() {
        return "SpringELBean{" +
                "initTime=" + initTime +
                ", str='" + str + '\'' +
                ", d=" + d +
                ", pi=" + pi +
                ", otherBeanProp='" + otherBeanProp + '\'' +
                ", otherBeanPropUp='" + otherBeanPropUp + '\'' +
                ", run=" + run +
                ", idFlag=" + idFlag +
                ", strFlag=" + strFlag +
                ", strApp='" + strApp + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
