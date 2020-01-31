package com.freak.project.client;

import com.freak.project.config.CoreConfiguration;
import com.freak.project.domain.AccuCountryListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
public class AccuClient {
    //wstrzykuje beana RestTemplate z CoreConfiguration aby umozliwic wyslanie zapytania HTTP AccuClient
//    @Autowired
//    private CoreConfiguration coreConfiguration;
    @Value("${accuWeather.api.endpoint.prod}")
    private String apiEndpoint;
    @Value("${accuWeather.app.key}")
    private String accuAppKey;

    @Autowired
    private RestTemplate restTemplate;
    public List<AccuCountryListDTO> getCountryList() {
        //URI klasa z kilkoma metodami do operowania na adresie https://docs.oracle.com/javase/7/docs/api/java/net/URI.html

        URI url = UriComponentsBuilder.fromHttpUrl(apiEndpoint+"locations/v1/countries/europe")
                .queryParam("apikey=",accuAppKey+"&language=pl")
                .queryParam("fields","ID,LocalizedName").build().encode().toUri();
        AccuCountryListDTO[] responseAccuCountryListDTO = restTemplate.getForObject(url, AccuCountryListDTO[].class);

        if (responseAccuCountryListDTO != null) {
            return Arrays.asList(responseAccuCountryListDTO);
        }
        return new ArrayList<>();
    }
}
