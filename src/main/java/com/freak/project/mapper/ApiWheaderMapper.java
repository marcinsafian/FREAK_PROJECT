package com.freak.project.mapper;


import com.freak.project.domain.Stations;
import com.freak.project.domain.StationsDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApiWheaderMapper {
    public List<Stations> mapToStations (@NotNull final List<StationsDTO> stationsDTO){
        return stationsDTO.stream()
                .map(stations ->
                        new Stations(stations.getId_stacji(),stations.getStacja(),stations.getData_pomiaru(),
                                stations.getGodzina_pomiaru(),stations.getTemperatura(),
                                stations.getPredkosc_wiatru(),stations.getKierunek_wiatru(),
                                stations.getWilgotnosc_wzgledna(),stations.getSuma_opadu(),
                                stations.getCisnienie()))
                .collect(Collectors.toList());
    }
    public List<StationsDTO> mapToStationsDto (@org.jetbrains.annotations.NotNull final List<Stations> stations){
        return stations.stream()
                .map(stations1 -> new StationsDTO(stations1.getId_stacji(),
                        stations1.getStacja(),
                        stations1.getTemperatura()))
                .collect(Collectors.toList());
    }
}
