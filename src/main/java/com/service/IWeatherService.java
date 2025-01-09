package com.service;

import com.model.Weather;

import java.util.Optional;

public interface IWeatherService extends IService<Weather> {
    Optional<Weather> findByLocation(String location);
}
