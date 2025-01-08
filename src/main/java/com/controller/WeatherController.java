package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @PostMapping("/{username}/{password}/{location}")
    public ResponseEntity<String> getWeather(@PathVariable String username, @PathVariable String password, @PathVariable String location) {
        return null;
    }
}
