package com.example.g7_1105ss.weatherworld.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.g7_1105ss.weatherworld.R;
import com.example.g7_1105ss.weatherworld.WeatherResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class WeatherAPI{

    public static final String BASE_URL =  "http://api.openweathermap.org/data/2.5/";
    public static final String METHOD_CURRENT_WHEATER = "weather";

    public interface WeatherDownloadFinished{
        public void newWeatherData(String cityName, float temperature);
    }

    private WeatherDownloadFinished listener;

    public void setOnWeatherDownloadFinished (WeatherDownloadFinished listener) {
        this.listener = listener;
    }

    public void getCurrentConditions(Context context, String city, String language){

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + METHOD_CURRENT_WHEATER + "?q=" + city + "&lang=" + language + "&units=metric" + "&appid=" + context.getString(R.string.api_token);

        Log.d("URL", url);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // all ok
                Log.d("RESPONSE", response);
                parseJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // we have a problem
                Log.e("HORROR", "Error de la muerte");
            }
        });

        queue.add(request);

    }

    private void parseJSON(String response) {
        Reader reader = new StringReader(response);
        Gson gson = new GsonBuilder().create();

        WeatherResponse weatherResponse = gson.fromJson(reader, WeatherResponse.class);
        Log.d("response", weatherResponse.toString());

        if (listener != null){
            listener.newWeatherData(weatherResponse.getName(), weatherResponse.getMain().getTemperature());
        }
    }
}
