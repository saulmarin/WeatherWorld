package com.example.g7_1105ss.weatherworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.g7_1105ss.weatherworld.managers.WeatherAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherAPI api = new WeatherAPI();
        api.getCurrentConditions(this, "Malaga", "es");
    }
}
