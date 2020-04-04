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
@JsonIgnoreProperties(ignoreUnknown = true)
public class StationsDTO {

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

    public StationsDTO(String id_station, String station, String date_measure, String hour_measure, String temperature, String wind_speed, String wind_direction, String relative_humidity, String total_rainfall, String pressure) {
        this.id_station = id_station;
        this.station = station;
        this.date_measure = date_measure;
        this.hour_measure = hour_measure;
        this.temperature = temperature;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.relative_humidity = relative_humidity;
        this.total_rainfall = total_rainfall;
        this.pressure = pressure;
    }
}
