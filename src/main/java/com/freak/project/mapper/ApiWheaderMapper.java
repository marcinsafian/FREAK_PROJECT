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
                        new Stations(stations.getId_stacji(),stations.getStacja(),stations.getData_pomiaru(),
                                stations.getGodzina_pomiaru(),stations.getTemperatura(),
                                stations.getPredkosc_wiatru(),stations.getKierunek_wiatru(),
                                stations.getWilgotnosc_wzgledna(),stations.getSuma_opadu(),
                                stations.getCisnienie()))
                .collect(Collectors.toList());
    }
    public List<StationsDTO> mapToStationsDto ( final List<StationsDTO> stations){
        return stations.stream()
                .map(stations1 -> new StationsDTO(stations1.getId_stacji(),stations1.getStacja(),stations1.getData_pomiaru(),
                        stations1.getGodzina_pomiaru(),stations1.getTemperatura(),
                        stations1.getPredkosc_wiatru(),stations1.getKierunek_wiatru(),
                        stations1.getWilgotnosc_wzgledna(),stations1.getSuma_opadu(),
                        stations1.getCisnienie()))
                .collect(Collectors.toList());
    }
//    public StationByIdDto mapStationsIdDto (final String id_stacji){
//        return stations.stream()
//                .map(stations1 -> new StationsDTO(stations1.getId_stacji(),stations1.getStacja(),stations1.getData_pomiaru(),
//                        stations1.getGodzina_pomiaru(),stations1.getTemperatura(),
//                        stations1.getPredkosc_wiatru(),stations1.getKierunek_wiatru(),
//                        stations1.getWilgotnosc_wzgledna(),stations1.getSuma_opadu(),
//                        stations1.getCisnienie()))
//                .collect(Collectors.toList());
//    }
    public StationsDTO mapIdDto (final Stations stations){
        return new StationsDTO(stations.getId_stacji(),stations.getStacja(),stations.getData_pomiaru(),
                stations.getGodzina_pomiaru(),stations.getTemperatura(),
                stations.getPredkosc_wiatru(),stations.getKierunek_wiatru(),
                stations.getWilgotnosc_wzgledna(),stations.getSuma_opadu(),
                stations.getCisnienie());
    }
    public Stations mapId (final StationsDTO stationsDTO){
        return new Stations(stationsDTO.getId_stacji(),stationsDTO.getStacja(),stationsDTO.getData_pomiaru(),
                stationsDTO.getGodzina_pomiaru(),stationsDTO.getTemperatura(),
                stationsDTO.getPredkosc_wiatru(),stationsDTO.getKierunek_wiatru(),
                stationsDTO.getWilgotnosc_wzgledna(),stationsDTO.getSuma_opadu(),
                stationsDTO.getCisnienie());
    }
}
