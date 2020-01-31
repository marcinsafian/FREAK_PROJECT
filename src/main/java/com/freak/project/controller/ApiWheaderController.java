package com.freak.project.controller;

import com.freak.project.client.ApiWheaderClient;
import com.freak.project.domain.StationParametersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/id/12500")//12500 numer stacji - zmienic pozniej
public class ApiWheaderController {

    @Autowired
    private ApiWheaderClient apiWheaderClient;

    @RequestMapping(method = RequestMethod.GET, value = "getStationItems")
    public void getStationItems() {

        List<StationParametersDTO> stationParametersDTOS = apiWheaderClient.getStationsURL();

        stationParametersDTOS.forEach(stationParametersDTO -> System.out.println(stationParametersDTO.getId_stacji()
                + " " + stationParametersDTO.getTemperatura()+ " "+
                stationParametersDTO.getCisnienie()+" "+stationParametersDTO.getData_pomiaru()+" "+
                stationParametersDTO.getGodzina_pomiaru()+" "+stationParametersDTO.getKierunek_wiatru()+" "+
                stationParametersDTO.getPredkosc_wiatru()+" "+stationParametersDTO.getStacja()+" "+
                stationParametersDTO.getSuma_opadu()+" "+stationParametersDTO.getWilgotnosc_wzgledna()));

    }
}
