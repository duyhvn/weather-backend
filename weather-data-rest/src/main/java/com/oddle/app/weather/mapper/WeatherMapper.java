package com.oddle.app.weather.mapper;

import com.oddle.app.weather.dto.CityModel;
import com.oddle.app.weather.dto.CurrentWeatherDTO;
import com.oddle.app.weather.dto.CurrentWeatherModel;
import com.oddle.app.weather.dto.GeoDTO;
import com.oddle.app.weather.dto.WeatherMainDTO;
import com.oddle.app.weather.dto.WeatherModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Mapper(componentModel = "spring", imports = {Instant.class, LocalDateTime.class, TimeZone.class})
public interface WeatherMapper {

    @Mapping(target = "city", expression = "java(mapToCityModel(source, source.getGeo()))")
    @Mapping(target = "weather", expression = "java(mapToWeatherModel(source, source.getWeatherMain()))")
    CurrentWeatherModel mapToCurrentWeatherModel(CurrentWeatherDTO source);

    @Mapping(source = "geo.longitude", target = "longitude")
    @Mapping(source = "geo.latitude", target = "latitude")
    @Mapping(source = "currentWeather.cityName", target = "name")
    @Mapping(source = "currentWeather.sys.country", target = "countryCode")
    CityModel mapToCityModel(CurrentWeatherDTO currentWeather, GeoDTO geo);

    @Mapping(target = "date", expression = "java(LocalDateTime.ofInstant(Instant.ofEpochSecond(current.getDate()),TimeZone.getDefault().toZoneId()))")
    WeatherModel mapToWeatherModel(CurrentWeatherDTO current, WeatherMainDTO weather);
}
