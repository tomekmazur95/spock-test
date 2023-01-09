package pl.com.tomek.spock.demo.wardrobe;

import java.util.List;

public class WardrobeService {

    private final WeatherService weatherService;

    public WardrobeService(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    List<String> getClothes() {

        Weather currentWeather = weatherService.getCurrentWeather();

        if (currentWeather == Weather.RAINY) {
            return List.of("plaszcz przeciwdeszczowy", "parasol", "czapka");
        }
        if(currentWeather == Weather.SUNNY){
            return List.of("kaszkietówka", "sandaly");
        }
        if(currentWeather == Weather.SNOWY){
            return List.of("kalesony", "buty zimowe", "czapka zimowa");
        }

        return List.of();
    }

}
