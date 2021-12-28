package com.example.validphonecheck.controller;

import com.example.validphonecheck.service.PhoneService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ValidController {

    private final PhoneService phoneService;

    public ValidController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/valid-phone/{phone}")
    public String validate(@PathVariable String phone) {
        return phoneService.checkPhoneIsValid(phone);
    }
}
