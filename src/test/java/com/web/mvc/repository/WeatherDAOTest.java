package com.web.mvc.repository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherDAOTest {
    
    public WeatherDAOTest() {
    }

    @Test
    public void testFind() throws Exception {
        System.out.println(new WeatherDAOImpl().find("Taoyuan"));
    }
    
}
