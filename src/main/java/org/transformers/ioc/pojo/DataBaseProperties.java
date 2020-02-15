package org.transformers.ioc.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataBaseProperties {

    // 属性上使用@Value注解，不会调用setter方法，即对应的setter方法不会被调用
    @Value("${database.url}")
    private String url;

    @Value("${database.driverName}")
    private String driverName;


    private String username;

    private String password;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        System.out.println("DataBaseProperties.setDriverName " + driverName);
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        System.out.println("DataBaseProperties.setUrl " + url);
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    // 在setter方法上使用@Value注解，会调用setter方法
    @Value("${database.username}")
    public void setUsername(String username) {
        System.out.println("DataBaseProperties.setUsername " + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Value("${database.password}")
    public void setPassword(String password) {
        System.out.println("DataBaseProperties.setPassword " + password);
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataBaseProperties{" +
                "driverName='" + driverName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
