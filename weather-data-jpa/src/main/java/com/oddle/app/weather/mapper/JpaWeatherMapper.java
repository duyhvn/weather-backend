package com.oddle.app.weather.mapper;

import com.oddle.app.weather.entity.CityEntity;
import com.oddle.app.weather.entity.WeatherEntity;
import com.oddle.app.weather.dto.CityModel;
import com.oddle.app.weather.dto.WeatherModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JpaWeatherMapper {

    WeatherEntity mapToWeatherEntity(WeatherModel source);

    CityEntity mapToCityEntity(CityModel source);

    WeatherModel mapToWeatherModel(WeatherEntity source);

    void updateWeatherEntity(@MappingTarget WeatherEntity toUpdate, WeatherModel source);
}
