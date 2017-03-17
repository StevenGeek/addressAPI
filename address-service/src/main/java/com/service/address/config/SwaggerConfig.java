package com.service.address.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringBootPlugin() {
        ApiInfo apiInfo = new ApiInfo("sample of spirngboot", "sample of spirngboot", null, null, "", null, null);
        Docket = docket = new Docket(DocumentationType.)
    }
}
