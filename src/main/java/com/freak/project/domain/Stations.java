package com.freak.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Stations {

    private String id_station;
    private String station;
    private String date_measure;
    private String hour_measure;
    private String temperature;
    private String wind_speed;
    private String wind_direction;
    private String relative_humidity;
    private String total_rainfall;
    private String pressure;
    private String preferStation;

    public Stations(String id_station, String station, String date_measure, String hour_measure, String temperature, String wind_speed, String wind_direction, String relative_humidity, String total_rainfall, String pressure) {
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
