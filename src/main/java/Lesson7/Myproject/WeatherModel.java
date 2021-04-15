package Lesson7.Myproject;

import java.io.IOException;
import java.sql.SQLException;

public interface WeatherModel {
    void getWeather(Period period, String selectedCity) throws IOException, SQLException;

    void getSavedWeatherData() throws SQLException;


}
