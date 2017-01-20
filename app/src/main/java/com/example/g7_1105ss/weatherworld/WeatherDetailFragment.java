package com.example.g7_1105ss.weatherworld;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.g7_1105ss.weatherworld.managers.WeatherAPI;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherDetailFragment extends Fragment {

    TextView cityNameText;
    TextView temperatureText;
    ImageView weatherIcon;

    public WeatherDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_detail, container, false);
        //ButterKnife.bind(this, view);
        cityNameText = (TextView) view.findViewById(R.id.fragment_weather_details_city_name);
        temperatureText = (TextView) view.findViewById(R.id.fragment_weather_details_temp);
        weatherIcon = (ImageView) view.findViewById(R.id.fragment_weather_details_icon);

        return view;
    }

    public void showWeather(String city, String language) {
        WeatherAPI api = new WeatherAPI();

        api.getCurrentConditions(getContext(), city, language);

        api.setOnWeatherDownloadFinished(new WeatherAPI.WeatherDownloadFinished() {
            @Override
            public void newWeatherData(String cityName, float temperature) {
                cityNameText.setText(cityName);
                temperatureText.setText(temperature + " ºC");
            }
        });


    }
}
