package com.example.validphonecheck.model.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneValidationRequestDto {

    @JsonProperty("phone")
    private String phone;
}
