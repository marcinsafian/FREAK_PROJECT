package com.freak.project.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class UrlConfig {
    @Value("https://danepubliczne.imgw.pl/api/data/synop")
   private String apiEndpoint;


}
