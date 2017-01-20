package com.example.g7_1105ss.weatherworld;

import com.google.gson.annotations.SerializedName;

/**
{
    "coord": {
        "lon": -4.42,
        "lat": 36.72
    },
    "weather": [
        {
            "id": 803,
            "main": "Clouds",
            "description": "nubes rotas",
            "icon": "04d"
        }
    ],
    "base": "stations",
    "main": {
        "temp": 9.83,
        "pressure": 1009.65,
        "humidity": 100,
        "temp_min": 9.83,
        "temp_max": 9.83,
        "sea_level": 1026.24,
        "grnd_level": 1009.65
    },
    "wind": {
        "speed": 3.06,
        "deg": 324.501
    },
    "clouds": {
        "all": 56
    },
    "dt": 1484908698,
    "sys": {
        "message": 0.005,
        "country": "ES",
        "sunrise": 1484897227,
        "sunset": 1484933460
    },
    "id": 2514256,
    "name": "Malaga",
    "cod": 200
}
 */

public class WeatherResponse {
    @SerializedName("name") private String name;
    @SerializedName("main") private Main main;
    @SerializedName("coord") private Coord coord;
    @SerializedName("weather") private Weather wheater;


    private class Main {
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

    private class Weather {
        @SerializedName("main") String main;
        @SerializedName("description") String description;
        @SerializedName("icon") String icon;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    private class Coord {
        @SerializedName("lon") private float longitude;
        @SerializedName("lat") private float latitude;

        public float getLongitude() {
            return longitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public float getLatitude() {
            return latitude;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather getWheater() {
        return wheater;
    }

    public void setWheater(Weather wheater) {
        this.wheater = wheater;
    }
}
