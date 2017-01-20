package com.example.g7_1105ss.weatherworld.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.g7_1105ss.weatherworld.R;

public class WeatherAPI {

    public static final String BASE_URL =  "http://api.openweathermap.org/data/2.5/";
    public static final String METHOD_CURRENT_WHEATER = "weather";

    public void getCurrentConditions(Context context, String city, String language){

        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL + METHOD_CURRENT_WHEATER + "?q=" + city + "&lang=" + language + "&units=metric" + "&appid=" + context.getString(R.string.api_token);

        Log.d("URL", url);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // all ok
                Log.d("RESPONSE", response);
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
}
