package com.freak.project.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@DynamicUpdate

@Table(name = "weatherStations")
public class WheatherStations {
    @Id
    @Column(name = "id_stacji")
    private String id_station;

    @Column(name = "stacja")
    private String station;

    @Column(name = "data_pomiaru")
    private String date_measure;

    @Column(name = "godzina_pomiaru")
    private String hour_measure;

    @Column(name = "temperatura")
    private String temperature;

    @Column(name = "predkosc_wiatru")
    private String wind_speed;

    @Column(name = "kierunek_wiatru")
    private String wind_direction;

    @Column(name = "wilgotnosc_wzgledna")
    private String relative_humidity;

    @Column(name = "suma_opadu")
    private String total_rainfall;

    @Column(name = "cisnienie")
    private String pressure;


}
