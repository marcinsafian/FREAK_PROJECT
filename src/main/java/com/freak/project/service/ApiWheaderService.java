package com.freak.project.service;


import com.freak.project.client.ApiWheaderClient;
import com.freak.project.domain.StationsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiWheaderService {
    @Autowired
    private ApiWheaderClient apiWheaderClient;

    public List<StationsDTO> fetchAllStations(){return apiWheaderClient.getStationsURL();}
}
