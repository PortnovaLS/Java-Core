package Lesson7.Myproject;

import Lesson7.Myproject.Entity.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuWeatherModel implements WeatherModel {
    private static final String PROTOKOL = "http";
    private static final String API_KEY = "7Ly2fH0WnO6ffbYGg0cxbEP4Ap9TbbvA";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String API_V1 = "v1";
    private static final String DAILY_ENDPOINT = "daily";
    private static final String NUMBER_DAYS = "5day";
    private static final String LOCATIONS_ENDPOINT = "locations";
    private static final String CITIES_ENDPOINT = "cities";
    private static final String AUTOCOMPLETE_ENDPOINT = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(Period period, String selectedCity) throws IOException, SQLException {
        String cityKey = detectCityKey(selectedCity);
        if (period == Period.NOW) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_V1)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();
            JsonNode localObservationDateTime = objectMapper
                    .readTree(responseString)
                    .get(0)
                    .at("/LocalObservationDateTime");
            JsonNode weatherText = objectMapper
                    .readTree(responseString)
                    .get(0)
                    .at("/WeatherText");
            JsonNode temperatureMetricValue = objectMapper
                    .readTree(responseString)
                    .get(0)
                    .at("/Temperature/Metric/Value");
            DataBaseRepository dataBaseRepository = new DataBaseRepository();
            Weather weather = new Weather(localObservationDateTime.asText(), weatherText.asText(), temperatureMetricValue.asDouble());
            dataBaseRepository.saveWeatherData(weather);
            System.out.println("Время " + localObservationDateTime.asText() + "Погода " + weatherText.asText() +
                    "Температура " + temperatureMetricValue.asText());

        }
        //TODO: Домашнее задание со звездочкой
        if (period == Period.FIVE_DAYS) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_V1)
                    .addPathSegment(DAILY_ENDPOINT)
                    .addPathSegment(NUMBER_DAYS)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();

            System.out.println(responseString);

        }
    }

    @Override
    public void getSavedWeatherData() throws SQLException {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        List<Weather> list = dataBaseRepository.getSavedWeatherData();
        System.out.println(list);
    }

    public String detectCityKey(String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_ENDPOINT)
                .addPathSegment(API_V1)
                .addPathSegment(CITIES_ENDPOINT)
                .addPathSegment(AUTOCOMPLETE_ENDPOINT)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();

        return cityKey;
        //TODO: Тут нужно вывести полученные данные в читабельном виде
    }
}
