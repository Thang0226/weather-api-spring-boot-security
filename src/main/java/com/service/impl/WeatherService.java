package com.service.impl;

import com.model.Weather;
import com.service.IWeatherService;
import com.repository.IWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService implements IWeatherService {
    @Autowired
    private IWeatherRepository weatherRepository;

    @Override
    public Iterable<Weather> findAll() {
        return weatherRepository.findAll();
    }

    @Override
    public Weather save(Weather weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public Optional<Weather> findById(Long id) {
        return weatherRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        weatherRepository.deleteById(id);
    }
}
