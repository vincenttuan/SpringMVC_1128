package com.web.mvc.service;

import com.web.mvc.beans.Weather;

public interface WeatherService {
    Weather find(String cityName) throws Exception;
}
