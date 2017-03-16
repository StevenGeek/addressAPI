package com.service.address.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@ConfigurationProperties(prefix = "baidu")
@PropertySource("classpath:config/baidu.properties")
public class BaiDuProperties {
    private String address2location;

    private String ak;

    public String getAddress2location() {
        return address2location;
    }

    public void setAddress2location(String address2location) {
        this.address2location = address2location;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
