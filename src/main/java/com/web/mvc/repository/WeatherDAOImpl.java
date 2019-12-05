package com.web.mvc.repository;

import java.net.URL;
import java.util.Scanner;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherDAOImpl implements WeatherDAO {
    public String find(String cityName) throws Exception {
        String urlString = "https://openweathermap.org/data/2.5/weather?q=%s,tw&appid=b6907d289e10d714a6e88b30761fae22";
        urlString = String.format(urlString, cityName);
        String json = new Scanner(new URL(urlString).openStream()).useDelimiter("\\Z").next();
        return json;
    }
}
