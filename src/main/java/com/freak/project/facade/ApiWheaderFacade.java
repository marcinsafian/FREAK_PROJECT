package com.freak.project.facade;

import com.freak.project.domain.StationByIdDto;
import com.freak.project.domain.StationByNameDto;
import com.freak.project.domain.StationsDTO;
import com.freak.project.mapper.ApiWheaderMapper;
import com.freak.project.service.ApiWheaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ApiWheaderFacade {
    @Autowired
    private ApiWheaderService apiWheaderService;

    @Autowired
    private ApiWheaderMapper apiWheaderMapper;

    public List<StationsDTO> fetchAllStations(){
        List<StationsDTO>stations = apiWheaderMapper.mapToStationsDto(apiWheaderService.fetchAllStations());
        return stations;
    }
    public Optional<List<StationByIdDto>> getStationId(String id_stacji){
        Optional<List<StationByIdDto>> station = Optional.ofNullable(apiWheaderService.fetchById(id_stacji));
    return station;}

    public Optional<List<StationByNameDto>> getStationName(String stacja){
        Optional<List<StationByNameDto>> station = Optional.ofNullable(apiWheaderService.fetchByName(stacja));
        return station;}
}
