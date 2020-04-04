package com.freak.project.mapper;


import com.freak.project.domain.Stations;
import com.freak.project.domain.StationsDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApiWheaderMapper {
    public List<Stations> mapToStations ( final List<StationsDTO> stationsDTO){
        return stationsDTO.stream()
                .map(stations ->
                        new Stations(stations.getId_station(),stations.getStation(),stations.getDate_measure(),
                                stations.getHour_measure(),stations.getTemperature(),
                                stations.getWind_speed(),stations.getWind_direction(),
                                stations.getRelative_humidity(),stations.getTotal_rainfall(),
                                stations.getPressure()))
                .collect(Collectors.toList());
    }
    public List<StationsDTO> mapToStationsDto ( final List<StationsDTO> stations){
        return stations.stream()
                .map(stations1 -> new StationsDTO(stations1.getId_station(),stations1.getStation(),stations1.getDate_measure(),
                        stations1.getHour_measure(),stations1.getTemperature(),
                        stations1.getWind_speed(),stations1.getWind_direction(),
                        stations1.getRelative_humidity(),stations1.getTotal_rainfall(),
                        stations1.getPressure()))
                .collect(Collectors.toList());
    }

    public Stations mapId (final StationsDTO stationsDTO){
        return new Stations(stationsDTO.getId_station(),stationsDTO.getStation(),stationsDTO.getDate_measure(),
                stationsDTO.getHour_measure(),stationsDTO.getTemperature(),
                stationsDTO.getWind_speed(),stationsDTO.getWind_direction(),
                stationsDTO.getRelative_humidity(),stationsDTO.getTotal_rainfall(),
                stationsDTO.getPressure());
    }
}
