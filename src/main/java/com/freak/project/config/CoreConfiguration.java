package com.freak.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {
    @Bean //klasa Springa umożliwiajaca realizaje zadan HTTP -GET,POST
        // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
