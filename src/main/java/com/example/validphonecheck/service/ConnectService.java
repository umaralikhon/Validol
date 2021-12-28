package com.example.validphonecheck.service;

import com.example.validphonecheck.Model.ValidationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConnectService {

    private final RestTemplate restTemplate;

    @Autowired
    public ConnectService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ValidationResponseDto connect(String phone) {
        String url = "https://phonevalidation.abstractapi.com/v1/?api_key=0c96e64ac71546c19db6b22b60f3b4f7&phone=" + phone;
        ValidationResponseDto responseDto = restTemplate.getForObject((url), ValidationResponseDto.class);

        return responseDto;
    }

}
