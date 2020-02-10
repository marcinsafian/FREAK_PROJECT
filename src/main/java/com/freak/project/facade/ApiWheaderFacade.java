package com.freak.project.facade;

import com.freak.project.domain.StationByIdDto;
import com.freak.project.domain.StationByNameDto;
import com.freak.project.domain.Stations;
import com.freak.project.domain.StationsDTO;
import com.freak.project.exception.StationNotFoundException;
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

    public List<StationsDTO> fetchAllStations(){
        List<StationsDTO>stations = apiWheaderMapper.mapToStationsDto(apiWheaderService.fetchAllStations());
        return stations;
    }
    public List<StationByIdDto> getStationId(String id_stacji) throws StationNotFoundException{
        List<StationByIdDto> station = apiWheaderService.fetchById(id_stacji);
    return station;}

    public List<StationByNameDto> getStationName(String stacja) throws StationNotFoundException {
        List<StationByNameDto> station = apiWheaderService.fetchByName(stacja);
        return station;}
}
