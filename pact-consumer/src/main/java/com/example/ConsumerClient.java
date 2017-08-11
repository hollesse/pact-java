package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ConsumerClient{
    private String url;
    private RestTemplate restTemplate;

    @Autowired
    public ConsumerClient(@Value("${serviceUrl}") String url) {
        this.url = url;
        this.restTemplate = new RestTemplate();
    }

    public List<Course> courses() {
        ParameterizedTypeReference<List<Course>> responseType = new ParameterizedTypeReference<List<Course>>() {};
        return restTemplate.exchange(url + "/courses", HttpMethod.GET, null, responseType).getBody();
    }
}
