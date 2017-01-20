package com.example.g7_1105ss.weatherworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.g7_1105ss.weatherworld.managers.WeatherAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherDetailFragment fragment = (WeatherDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_weather_details);
        fragment.showWeather("Malaga", "es");

    }
}
