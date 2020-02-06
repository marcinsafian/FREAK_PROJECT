package com.freak.project.facade;


import com.freak.project.domain.StationDtoList;
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
    public Optional<StationDtoList> getstationId(Long id_stacji){
        Optional<StationDtoList> station = Optional.ofNullable(apiWheaderService.fetchById(id_stacji));
    return station;}
}
