package com.oddle.app.weather.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrentWeatherModel {
    private CityModel city;
    private WeatherModel weather;
}
