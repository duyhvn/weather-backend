package com.oddle.app.weather.dto;

import lombok.*;

/**
 * This class is presentation about the current weather description
 * such as clouds, mist, sky, etc.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WeatherDescDTO {
    private int id;
    private String main;
    private String description;
    private String icon;
}
