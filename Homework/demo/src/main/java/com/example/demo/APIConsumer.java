/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author diego
 */

//7860757f363f493db0e73a47956103cf


public class APIConsumer {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String ENDPOINT = "forecast";
    private static final String CURRENT = "weather";
    private static final String METRIC = "&units=metric";
    private static final String ACCESS_KEY = "7860757f363f493db0e73a47956103cf";
    private static CloseableHttpClient httpClient = HttpClients.createDefault();



    public APIConsumer() {}

    public EntWeather sendRequestForWeatherCurrent(String city) {
        HttpGet get = new HttpGet(BASE_URL + CURRENT + "?q=" + city + "&appid=" + ACCESS_KEY + METRIC);
        
        EntWeather result = null;
        
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
             
            JSONObject weatherReport = new JSONObject(EntityUtils.toString(entity));

            double temp = weatherReport.getJSONObject("main").getDouble("temp");
            double temp_min = weatherReport.getJSONObject("main").getDouble("temp_min");
            double temp_max = weatherReport.getJSONObject("main").getDouble("temp_max");
            String description = weatherReport.getJSONArray("weather").getJSONObject(0).getString("description");

            result = new EntWeather(temp_min, temp_max, temp, description, city);

            //System.out.print(result);

            response.close();
          } catch (IOException e) {
            e.printStackTrace();
            return null;
          }

        return result;
    
    }
    public List<EntWeather> sendRequestForWeatherInfo(String city) {
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?q=" + city + "&appid=" + ACCESS_KEY + METRIC);
        
        List<EntWeather> reportWeather = new ArrayList();
        
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            JSONObject weatherReport = new JSONObject(EntityUtils.toString(entity));
            JSONArray report = weatherReport.getJSONArray("list");

            //System.out.print(weatherReport);

            
            for (int i = 0; i < report.length(); i++) {
              JSONObject tmp = report.getJSONObject(i);

              double temp = tmp.getJSONObject("main").getDouble("temp");
              double temp_min = tmp.getJSONObject("main").getDouble("temp_min");
              double temp_max = tmp.getJSONObject("main").getDouble("temp_max");
              String description = tmp.getJSONArray("weather").getJSONObject(0).getString("description");
              String date = tmp.getString("dt_txt");

              EntWeather result = new EntWeather(temp_min, temp_max, temp, date, description, city);
              
              //System.out.print(result);
              
              reportWeather.add(result);
            }

            response.close();
          } catch (IOException e) {
            e.printStackTrace();
            return null;
          }

        return reportWeather;
    
    }
}