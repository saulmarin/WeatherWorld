package com.example.g7_1105ss.weatherworld;

import com.google.gson.annotations.SerializedName;

/**
 * Created by g7-1105ss on 20/01/2017.
 */

public class WeatherResponse {

    @SerializedName("main") private Main main;
    class Main {
        @SerializedName("temp") private float temperature;
        @SerializedName("humidity") private int humidity;

        public float getTemperature() {
            return temperature;
        }

        public void setTemperature(float temperature) {
            this.temperature = temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
