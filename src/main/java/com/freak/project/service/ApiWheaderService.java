package com.freak.project.service;

import com.freak.project.client.ApiWheaderClient;
import com.freak.project.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiWheaderService {
    @Autowired
    private ApiWheaderClient apiWheaderClient;

    public List<StationsDTO> fetchAllStations(){return apiWheaderClient.getStationsURL();}


    public List<StationByIdDto> fetchById(String id_station){
        return apiWheaderClient.getIdStationsURL()
                .stream()
                .filter(c -> c.getId_station().equals(id_station))
                .collect(Collectors.toList());
    }
    public List<StationByNameDto> fetchByName(String station){
        return apiWheaderClient.getNameStationsURL()
                .stream()
                .filter(c -> c.getStation().equals(station))
                .collect(Collectors.toList());
    }
}
