/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author diego
 */
@Entity
class EntWeather {

    
    private double temp_min;
    private double temp_max;
    private double temp;
    private String date;
    private String description;
    private String city;
    @Id
    private Long id;
    
    
    EntWeather(double temp_min, double temp_max, double temp, String date, String description, String city) {
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.temp = temp;
        this.date = date;
        this.description = description;
        this.city = city;


    }

    EntWeather(double temp_min, double temp_max, double temp, String description, String city) {
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.temp = temp;
        this.description = description;
        this.city = city;
    }
    
    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}
