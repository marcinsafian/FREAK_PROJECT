package com.freak.project.client;

import com.freak.project.config.UrlConfig;
import com.freak.project.domain.StationsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class ApiWheaderClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiWheaderClient.class);


    //wstrzykuje beana RestTemplate z CoreConfiguration aby umozliwic wyslanie zapytania HTTP AccuClient
//    @Autowired
//    private CoreConfiguration coreConfiguration;
//    @Value("${imgw.api.endpoint.prod}")
//    private String apiEndpoint;
//    @Value("${accuWeather.app.key}")
//    private String accuAppKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlConfig urlConfig;


    private URI urlBuild(){
        //URI klasa z kilkoma metodami do operowania na adresie https://docs.oracle.com/javase/7/docs/api/java/net/URI.html
        return UriComponentsBuilder.fromHttpUrl(urlConfig.getApiEndpoint()).build().encode().toUri();
    }

    public List<StationsDTO> getStationsURL() {

        //restTemplate udostepnia .getForObject
        try{
            StationsDTO[] stationsResponse = restTemplate.getForObject(urlBuild(), StationsDTO[].class);
            return Arrays.asList(ofNullable(stationsResponse).orElse(new StationsDTO[0]));
        }catch (RestClientException e){
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }
}
