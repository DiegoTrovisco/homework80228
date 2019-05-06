/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 */
@Component
@Controller
@RequestMapping(path = "/")
public class WeatherAPI {

  @Autowired private APIConsumer response;

  @GetMapping(path = "/current")
  public String current(@RequestParam("city") String location, Model modelo) {
    EntWeather r = response.sendRequestForWeatherCurrent(location);
    
    modelo.addAttribute("current", r);
    
    
    return "current";
  }

  @GetMapping(path = "/forecast")
  public String forecast(@RequestParam("city") String location, Model modelo) {
    List<EntWeather> list = response.sendRequestForWeatherInfo(location);

    modelo.addAttribute("forecast", list);
    
    return "forecast";
  }
}   