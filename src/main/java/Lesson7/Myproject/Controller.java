package Lesson7.Myproject;

import Lesson7.Myproject.Entity.Weather;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Controller {
    WeatherModel weatherModel = new AccuWeatherModel();

    // 1 - узнать текущую погоду    2 - узнать прогноз на 5 дней
    public void getWeather(String command, String selectedCity) throws IOException, SQLException {
        switch (Functionality.fromValue(command)) {
            case GET_CURRENT_WEATHER:
                weatherModel.getWeather(Period.NOW, selectedCity);
                break;
            case GET_WEATHER_IN_NEXT_FIVE_DAYS:
                weatherModel.getWeather(Period.FIVE_DAYS,selectedCity);
                break;
            case GET_SAVED_WEATHER_DATA:
                weatherModel.getSavedWeatherData();

                break;
                //your code here
//                throw new IOException("Метод не реализован!");
        }
    }
}
