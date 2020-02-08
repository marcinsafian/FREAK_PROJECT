package com.freak.project.controller;

import com.freak.project.domain.StationByIdDto;
import com.freak.project.domain.StationByNameDto;
import com.freak.project.domain.StationsDTO;
import com.freak.project.exception.StationNotFoundException;
import com.freak.project.facade.ApiWheaderFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stations")
public class ApiWheaderController {

    @Autowired
    private ApiWheaderFacade apiWheaderFacade;

    @GetMapping()
    public List<StationsDTO> getStationItems() {
        return apiWheaderFacade.fetchAllStations();
    }

    @GetMapping("/{id_stacji}")
    public List<StationByIdDto> getStationId(@PathVariable String id_stacji)throws StationNotFoundException {return apiWheaderFacade.getStationId(id_stacji);}

    @GetMapping("/name/{stacja}")
    public List<StationByNameDto> getStationName(@PathVariable String stacja) throws StationNotFoundException{return apiWheaderFacade.getStationName(stacja);}

}
