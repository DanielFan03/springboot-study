package org.transformers.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// 此种方式会调用属性对应的setter方法
@ConfigurationProperties("database")
public class DataBasePropertiesConfigurationProperties {
    private String driverName;

    private String url;

    private String username;

    private String password;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        System.out.println("DataBasePropertiesConfigurationProperties.setDriverName " + driverName);
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        System.out.println("DataBasePropertiesConfigurationProperties.setUrl " + url);
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("DataBasePropertiesConfigurationProperties.setUsername " + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("DataBasePropertiesConfigurationProperties.setPassword " + password);
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
