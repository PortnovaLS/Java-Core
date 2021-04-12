package Lesson7.Myproject;

import java.io.IOException;

public interface WeatherModel {
    void getWeather(Period period, String selectedCity) throws IOException;
}
