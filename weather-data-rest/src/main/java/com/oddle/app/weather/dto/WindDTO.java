package com.oddle.app.weather.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WindDTO {
    private double speed;
    private int deg;
}
