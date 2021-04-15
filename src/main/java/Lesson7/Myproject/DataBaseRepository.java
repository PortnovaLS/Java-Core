package Lesson7.Myproject;

import Lesson7.Myproject.Entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseRepository {
    private static final String DB_NAME = "geekbrains.db";
    String insertWeather = "insert into weather (localDate, weather_text, temperature) values (?,?,?)";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public boolean saveWeatherData(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db")) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getLocalDate());
            saveWeather.setString(2, weather.getWeatherText());
            saveWeather.setDouble(3, weather.getTemperature());
            return saveWeather.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public List<Weather> getSavedWeatherData() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather");
            List<Weather> weatherList = new ArrayList<>();
            while (resultSet.next()) {
                resultSet.getString("localDate");
                resultSet.getString("weather_text");
                resultSet.getDouble("temperature");
                Weather weather = new Weather(resultSet.getString("localDate"), resultSet.getString("weather_text"),
                        resultSet.getDouble("temperature"));
                weatherList.add(weather);
            }
            connection.close();
            return weatherList;

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }
        throw new SQLException("Считывание данных с базы данных не выполнено!");
    }
}
