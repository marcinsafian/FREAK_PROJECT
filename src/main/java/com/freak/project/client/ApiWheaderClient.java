package com.freak.project.client;

import com.freak.project.domain.StationParametersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ApiWheaderClient {
    //wstrzykuje beana RestTemplate z CoreConfiguration aby umozliwic wyslanie zapytania HTTP AccuClient
//    @Autowired
//    private CoreConfiguration coreConfiguration;
    @Value("${imgw.api.endpoint.prod}")
    private String apiEndpoint;
    @Value("${accuWeather.app.key}")
    private String accuAppKey;

    @Autowired
    private RestTemplate restTemplate;
    public List<StationParametersDTO> getStationsURL() {
        //URI klasa z kilkoma metodami do operowania na adresie https://docs.oracle.com/javase/7/docs/api/java/net/URI.html
        //restTemplate udostepnia .getForObject
        URI url = UriComponentsBuilder.fromHttpUrl(apiEndpoint).build().encode().toUri();
        StationParametersDTO[] responseParametersListDTO = restTemplate.getForObject(url, StationParametersDTO[].class);

        if (responseParametersListDTO != null) {
            return Arrays.asList(responseParametersListDTO);
        }
        return new ArrayList<>();
    }
}
