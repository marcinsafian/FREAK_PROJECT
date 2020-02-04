package com.freak.project.facade;


import com.freak.project.domain.Stations;
import com.freak.project.mapper.ApiWheaderMapper;
import com.freak.project.service.ApiWheaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiWheaderFacade {
    @Autowired
    private ApiWheaderService apiWheaderService;

    @Autowired
    private ApiWheaderMapper apiWheaderMapper;

    public List<Stations> fetchAllStations(){
        List<Stations>stations = apiWheaderMapper.mapToStations(apiWheaderService.fetchAllStations());
        return stations;
    }
}
