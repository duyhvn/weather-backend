package com.oddle.app.weather.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SysDTO {
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
}
