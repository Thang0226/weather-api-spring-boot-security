package com.controller;

import com.model.Weather;
import com.model.security.User;
import com.service.impl.UserService;
import com.service.impl.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
@CrossOrigin("*")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/{username}/{password}/{location}")
    public ResponseEntity<String> getWeather(@PathVariable String username, @PathVariable String password, @PathVariable String location) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Optional<Weather> weatherOptional = weatherService.findByLocation(location);
        if (weatherOptional.isPresent()) {
            return new ResponseEntity<>(weatherOptional.get().getDescription(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
