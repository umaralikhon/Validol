package com.example.validphonecheck.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationResponseDto {
    private String phone;
    private Boolean valid;
}
