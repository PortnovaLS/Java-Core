package Lesson7.Myproject.Entity;

public class Weather {
    private String localDate;
    private String weatherText;
    private double temperature;

    public Weather(String localDate, String weatherText, double temperature) {
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "localDate='" + localDate + '\'' +
                ", weatherText='" + weatherText + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
