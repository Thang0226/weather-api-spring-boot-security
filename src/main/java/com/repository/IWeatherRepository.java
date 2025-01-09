package com.repository;

import com.model.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWeatherRepository extends CrudRepository<Weather, Long> {
    Optional<Weather> findByLocation(String location);
}
