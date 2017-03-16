package com.service.address;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.service.address.filter.MyFilter;
import com.service.address.properties.BaiDuProperties;

@SpringBootApplication
@EnableConfigurationProperties(BaiDuProperties.class)
@ComponentScan("com.service")
@Configuration
public class AddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("MyFilter", "MyFilter");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean(name = "MyFilter")
    public Filter someFilter() {
        return new MyFilter();
    }

}
