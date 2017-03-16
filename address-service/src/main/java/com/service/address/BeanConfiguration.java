package com.service.address;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.address.filter.MyFilter;

@Configuration
public class BeanConfiguration {
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
