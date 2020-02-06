package com.freak.project.controller;

import com.freak.project.domain.StationDtoList;
import com.freak.project.domain.StationsDTO;
import com.freak.project.facade.ApiWheaderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stations")//12500 numer stacji - zmienic pozniej
public class ApiWheaderController {

//    @Autowired
//    private ApiWheaderClient apiWheaderClient;
    @Autowired
    private ApiWheaderFacade apiWheaderFacade;

    @GetMapping()
    public List<StationsDTO> getStationItems() {
        return apiWheaderFacade.fetchAllStations();
    }

    @GetMapping("/{id_stacji}")
    public Optional<StationDtoList> getStationId(@PathVariable Long id_stacji){return apiWheaderFacade.getstationId(id_stacji);}

}
