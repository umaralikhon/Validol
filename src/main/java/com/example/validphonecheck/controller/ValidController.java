package com.example.validphonecheck.controller;

import com.example.validphonecheck.service.PhoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/valid")
public class ValidController {

    private final PhoneService phoneService;

    public ValidController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/phone/{phone}")
    public Boolean validate(@PathVariable String phone) {
        return phoneService.checkPhoneIsValid(phone);
    }

    @GetMapping("/iban/{iban}")
    public Boolean validateIban(@PathVariable String iban){
        return phoneService.checkIbanValid(iban);
    }
}
