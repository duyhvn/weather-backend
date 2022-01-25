import com.oddle.app.weather.dto.*;
import com.oddle.app.weather.mapper.WeatherMapper;
import com.oddle.app.weather.repository.RestOpenWeatherMapRepository;
import com.oddle.app.weather.service.RestOpenWeatherMapRepositoryImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestOpenWeatherMapRepository.class)
public class RestOpenWeatherMapRepositoryImpTest {
    @InjectMocks
    private RestOpenWeatherMapRepositoryImp openWeatherMapRepositoryImp;

    @Mock
    private WeatherMapper weatherMapper;

    @Mock
    private RestTemplate restTemplate;

    private static final String CITY = "city";
    private static final double LATITUDE = 100.0;
    private static final double LONGITUDE = 100.0;
    private static final int ID = 1;
    private static final String MAIN = "main";
    private static final String DESCRIPTION = "description";
    private static final String ICON = "icon";
    private static final double FEELS_LIKE = 100;
    private static final float TEMP = 100;
    private static final float TEMP_MAX = 100;
    private static final float TEMP_MIN = 100;
    private static final int HUMIDITY = 100;
    private static final int PRESSURE = 100;
    private static final double SPEED = 100;
    private static final int DEG = 45;
    private static final int ALL = 100;
    private static final int TYPE = 10;
    private static final String COUNTRY = "Hue";
    private static final int SUNRISE = 20;
    private static final int SUNSET = 30;
    private static final long TIMEZONE = 201302;
    private static final long DATE = 21021;



    @Test
    public void givenCityName_whenSearchWeatherToday_thenSuccess(){
        CurrentWeatherDTO currentWeatherDTO=buildMockCurrentWeatherDto();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<CurrentWeatherDTO> weather = new HttpEntity<>(currentWeatherDTO);
        CurrentWeatherModel currentWeatherModel=weatherMapper.mapToCurrentWeatherModel(weather.getBody());
        Mockito.when(restTemplate.exchange(anyString(),
                HttpMethod.GET, entity, CurrentWeatherDTO.class)).thenReturn((ResponseEntity<CurrentWeatherDTO>) weather);

        Mockito.when(weatherMapper.mapToCurrentWeatherModel(weather.getBody())).thenReturn(currentWeatherModel);

        CurrentWeatherModel actual=openWeatherMapRepositoryImp.searchWeatherToday(CITY);

        Mockito.verify(openWeatherMapRepositoryImp).searchWeatherToday(CITY);
    }



    private CurrentWeatherDTO buildMockCurrentWeatherDto() {
        return CurrentWeatherDTO.builder()
                .geo(buildMockGeoDTO())
                .weather(buildListWeatherDescDTO())
                .weatherMain(buildMockWeatherMainDTO())
                .wind(buildMockWindDTO())
                .clouds(buildMockCloudDTO())
                .sys(buildMockSysDTO())
                .timezone(TIMEZONE)
                .date(DATE)
                .cityName(CITY)
                .build();
    }

    private GeoDTO buildMockGeoDTO() {
        return GeoDTO.builder()
                .latitude(LATITUDE)
                .longitude(LONGITUDE)
                .build();
    }

    private List<WeatherDescDTO> buildListWeatherDescDTO() {
        List<WeatherDescDTO> list = new ArrayList<>();
        list.add(WeatherDescDTO.builder()
                .icon(ICON)
                .main(MAIN)
                .description(DESCRIPTION)
                .build());
        return list;
    }

    private WeatherMainDTO buildMockWeatherMainDTO() {
        return WeatherMainDTO.builder()
                .humidity(HUMIDITY)
                .temp(TEMP)
                .feelsLike(FEELS_LIKE)
                .tempMin(TEMP_MIN)
                .tempMax(TEMP_MAX)
                .pressure(PRESSURE)
                .build();
    }

    private CloudDTO buildMockCloudDTO() {
        return CloudDTO.builder()
                .all(ALL)
                .build();
    }

    private WindDTO buildMockWindDTO() {
        return WindDTO.builder()
                .deg(DEG)
                .speed(SPEED)
                .build();
    }

    private SysDTO buildMockSysDTO() {
        return SysDTO.builder()
                .id(ID)
                .country(COUNTRY)
                .sunrise(SUNRISE)
                .sunset(SUNSET)
                .type(TYPE)
                .build();
    }


}
