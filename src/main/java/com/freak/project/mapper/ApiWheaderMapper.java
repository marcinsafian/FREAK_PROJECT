package com.freak.project.mapper;


import com.freak.project.domain.Stations;
import com.freak.project.domain.StationsDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApiWheaderMapper {
    public List<Stations> mapToStations (final List<StationsDTO> stationsDTO){
        return stationsDTO.stream()
                .map(stations ->
                        new Stations(stations.getId_stacji(),
                                stations.getStacja(),
                                stations.getTemperatura()))
                .collect(Collectors.toList());
    }
    public List<StationsDTO> mapToStationsDto (final List<Stations> stations){
        return stations.stream()
                .map(stations1 -> new StationsDTO( stations1.getId_stacji(),
                        stations1.getStacja(),
                        stations1.getTemperatura()))
                .collect(Collectors.toList());
    }
}
