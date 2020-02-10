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
//@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationsDTO {

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

    public StationsDTO(String id_stacji, String stacja, String data_pomiaru, String godzina_pomiaru, String temperatura,
                       String predkosc_wiatru, String kierunek_wiatru, String wilgotnosc_wzgledna, String suma_opadu, String cisnienie) {
        this.id_stacji = id_stacji;
        this.stacja = stacja;
        this.data_pomiaru = data_pomiaru;
        this.godzina_pomiaru = godzina_pomiaru;
        this.temperatura = temperatura;
        this.predkosc_wiatru = predkosc_wiatru;
        this.kierunek_wiatru = kierunek_wiatru;
        this.wilgotnosc_wzgledna = wilgotnosc_wzgledna;
        this.suma_opadu = suma_opadu;
        this.cisnienie = cisnienie;
    }
}
