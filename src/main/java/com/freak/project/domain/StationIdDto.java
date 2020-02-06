package com.freak.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationIdDto {

    @JsonProperty("id_stacji")
    private String id_stacji;

    @JsonProperty("stacja")
    private String stacja;

    @JsonProperty("data_pomiaru")
    private String data_pomiaru;

    @JsonProperty("godzina_pomiaru")
    private String godzina_pomiaru;

    @JsonProperty("temperatura")
    private String temperatura;

    @JsonProperty("predkosc_wiatru")
    private String predkosc_wiatru;

    @JsonProperty("kierunek_wiatru")
    private String kierunek_wiatru;

    @JsonProperty("wilgotnosc_wzgledna")
    private String wilgotnosc_wzgledna;

    @JsonProperty("suma_opadu")
    private String suma_opadu;

    @JsonProperty("cisnienie")
    private String cisnienie;
}
