package com.freak.project.service;

import com.freak.project.client.ApiWheaderClient;
import com.freak.project.domain.StationByIdDto;
import com.freak.project.domain.StationByNameDto;
import com.freak.project.domain.StationsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiWheaderService {
    @Autowired
    private ApiWheaderClient apiWheaderClient;

    public List<StationsDTO> fetchAllStations(){return apiWheaderClient.getStationsURL();}


    public List<StationByIdDto> fetchById(String id_stacji){
        return apiWheaderClient.getIdStationsURL()
                .stream()
                .filter(c -> c.getId_stacji().equals(id_stacji))
                .collect(Collectors.toList());
    }
    public List<StationByNameDto> fetchByName(String stacja){
        return apiWheaderClient.getNameStationsURL()
                .stream()
                .filter(c -> c.getStacja().equals(stacja))
                .collect(Collectors.toList());
    }
}
