package com.service.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.service.address.properties.BaiDuProperties;

@SpringBootApplication
@EnableConfigurationProperties(BaiDuProperties.class)
@ComponentScan("com.service")
public class AddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }

}
