package com.freak.project.controller;

import com.freak.project.domain.Stations;
import com.freak.project.facade.ApiWheaderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/stations")//12500 numer stacji - zmienic pozniej
public class ApiWheaderController {

//    @Autowired
//    private ApiWheaderClient apiWheaderClient;
    @Autowired
    private ApiWheaderFacade apiWheaderFacade;

    @RequestMapping(method = RequestMethod.GET, value = "getStations")
    public List<Stations> getStationItems() {
        return apiWheaderFacade.fetchAllStations();
    }
}
