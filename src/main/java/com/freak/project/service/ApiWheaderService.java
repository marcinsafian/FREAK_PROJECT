package com.freak.project.service;


import com.freak.project.client.ApiWheaderClient;
import com.freak.project.domain.StationDtoList;
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

//    public Optional<StationDtoList> fetchById(Long id_stacji){return apiWheaderClient.getIdStationsURL()
//            .stream()
//            .filter(c ->c.getIdList().equals(id_stacji))
//            .findFirst();}

    public StationDtoList fetchById(Long id_stacji){
        return (StationDtoList)apiWheaderClient.getIdStationsURL()
                .stream()
                .filter(c -> c.getIdList().equals(id_stacji))
                .collect(Collectors.toList());
    }
}
