package com.example.validphonecheck.controller;

import com.example.validphonecheck.service.PhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/valid")
@Slf4j
public class ValidController {

    private final PhoneService phoneService;

    public ValidController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/phone")
    public Boolean validate(@RequestParam String phone) {
        return phoneService.checkPhoneIsValid(phone);
    }

    @GetMapping("/iban")
    public Boolean validateIban(@RequestParam String iban){
        return phoneService.checkIbanValid(iban);
    }
}
