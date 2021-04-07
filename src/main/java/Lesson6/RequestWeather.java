package Lesson6;

import okhttp3.*;

import java.io.IOException;

public class RequestWeather {
//    private static final String API_KEY = "9694e17b-f0be-422b-90be-96878283bfb8";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.weather.yandex.ru/v2/forecast?lat=59.939095&lon=30.315868")
                .addHeader("X-Yandex-API-Key","9694e17b-f0be-422b-90be-96878283bfb8")
                .build();

        Response response = client.newCall(request).execute();

        String body = response.body().string();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.protocol());
        System.out.println(body);

















    }


}
