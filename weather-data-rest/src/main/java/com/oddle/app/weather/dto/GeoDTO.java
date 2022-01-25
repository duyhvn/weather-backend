package com.oddle.app.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GeoDTO {
    @JsonProperty("lon")
    private double longitude;
    @JsonProperty("lat")
    private double latitude;
}
