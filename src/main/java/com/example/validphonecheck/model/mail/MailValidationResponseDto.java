package com.example.validphonecheck.model.mail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailValidationResponseDto {
    private String mail;
    private Boolean valid;
}
