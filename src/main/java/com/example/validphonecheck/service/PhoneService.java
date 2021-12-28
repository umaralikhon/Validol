package com.example.validphonecheck.service;

import com.example.validphonecheck.Model.ValidationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    private final ConnectService connectService;

    @Autowired
    public PhoneService(ConnectService connectService){
        this.connectService = connectService;
    }

    public String checkPhoneIsValid(String phone){
        ValidationResponseDto responseDto = connectService.connect(phone);

        if(responseDto.getValid()){
            return phone + " is valid";
        }else {
            return phone + " is invalid";
        }
    }

}
