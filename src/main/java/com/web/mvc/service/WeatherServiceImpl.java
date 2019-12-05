package com.web.mvc.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.web.mvc.beans.Weather;
import com.web.mvc.repository.WeatherDAO;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherDAO weatherDAO;

    @Override
    public Weather find(String cityName) throws Exception {
        String json = weatherDAO.find(cityName);
        JsonObject jo = new JsonParser().parse(json).getAsJsonObject();
        JsonObject main = jo.getAsJsonObject("main");
        String icon = jo.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();
        double temp = main.get("temp").getAsDouble();
        double pressure = main.get("pressure").getAsDouble();
        double humidity = main.get("humidity").getAsDouble();
        double temp_min = main.get("temp_min").getAsDouble();
        double temp_max = main.get("temp_max").getAsDouble();
        return new Weather(temp, pressure, humidity, temp_min, temp_max, icon);
    }

}
