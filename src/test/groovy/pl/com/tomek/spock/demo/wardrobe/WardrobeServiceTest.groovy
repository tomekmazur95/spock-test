package pl.com.tomek.spock.demo.wardrobe

import spock.lang.Specification

class WardrobeServiceTest extends Specification {

    WeatherService weatherServiceMock = Mock()

    WardrobeService wardrobeService = new WardrobeService(weatherServiceMock)

    def "test jesli RAINY to zwraca plaszcz przeciwdeszczowy parasol i czapke"() {
        given:
        weatherServiceMock.getCurrentWeather() >> Weather.RAINY

        when:
        def result = wardrobeService.getClothes()
        then:
        result == ["plaszcz przeciwdeszczowy", "parasol", "czapka"]
        with(result) {
            it[0] == "plaszcz przeciwdeszczowy"
            it[1] == "parasol"
            it[2] == "czapka"

        }
    }

    def "test jesli SUNNY to zwraca kaszkiet i sandaly"() {

        when:
        def result = wardrobeService.getClothes()
        then:
        1 * weatherServiceMock.getCurrentWeather() >> Weather.SUNNY
        result == ["kaszkietówka", "sandaly"]

    }

    def "test jesli RAINY to rzuca wyjatek"() {
        given:
        weatherServiceMock.getCurrentWeather() >> { throw new RuntimeException("ubierz szalik baranie") }

        when:
        def result = wardrobeService.getClothes()
        then:
        def exception = thrown(RuntimeException)
        exception.message == "ubierz szalik baranie"

    }


}
