package com.example.validphonecheck.service;

import com.example.validphonecheck.model.iban.IbanResponseDto;
import com.example.validphonecheck.model.phone.PhoneValidationResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ConnectService {

    private final RestTemplate restTemplate;

    @Autowired
    public ConnectService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<PhoneValidationResponseDto> connect(String phone) {
        String url = "https://phonevalidation.abstractapi.com/v1/?api_key=0c96e64ac71546c19db6b22b60f3b4f7&phone=" + phone;
        ResponseEntity<PhoneValidationResponseDto> response = restTemplate.getForEntity(url, PhoneValidationResponseDto.class, phone);

        if(response.getStatusCode().is2xxSuccessful()) {
            return response;
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<IbanResponseDto> connectToIban(String iban) {
        String url = "https://ibanvalidation.abstractapi.com/v1/?api_key=af696f6261d147a28231108c3af0d0a6&iban=" + iban;
        ResponseEntity<IbanResponseDto> response = restTemplate.getForEntity(url, IbanResponseDto.class, iban);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response;
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
