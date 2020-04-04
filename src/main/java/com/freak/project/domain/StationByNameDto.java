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
public class StationByNameDto {

        @JsonProperty("id_stacji")
        private String id_station;

        @JsonProperty("stacja")
        private String station;

        @JsonProperty("data_pomiaru")
        private String date_measure;

        @JsonProperty("godzina_pomiaru")
        private String hour_measure;

        @JsonProperty("temperatura")
        private String temperature;

        @JsonProperty("predkosc_wiatru")
        private String wind_speed;

        @JsonProperty("kierunek_wiatru")
        private String wind_direction;

        @JsonProperty("wilgotnosc_wzgledna")
        private String relative_humidity;

        @JsonProperty("suma_opadu")
        private String total_rainfall;

        @JsonProperty("cisnienie")
        private String pressure;
}
