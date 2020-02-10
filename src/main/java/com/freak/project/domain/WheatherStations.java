package com.freak.project.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@DynamicUpdate
@Table(name = "weatherStations")
public class WheatherStations {
    @Id
    @Column(name = "id_stacji")
    private String id_stacji;

    @Column(name = "stacja")
    private String stacja;

    @Column(name = "data_pomiaru")
    private String data_pomiaru;

    @Column(name = "godzina_pomiaru")
    private String godzina_pomiaru;

    @Column(name = "temperatura")
    private String temperatura;

    @Column(name = "predkosc_wiatru")
    private String predkosc_wiatru;

    @Column(name = "kierunek_wiatru")
    private String kierunek_wiatru;

    @Column(name = "wilgotnosc_wzgledna")
    private String wilgotnosc_wzgledna;

    @Column(name = "suma_opadu")
    private String suma_opadu;

    @Column(name = "cisnienie")
    private String cisnienie;
}
