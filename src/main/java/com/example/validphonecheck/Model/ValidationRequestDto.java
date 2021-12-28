package com.example.validphonecheck.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationRequestDto {

    @JsonProperty("phone")
    private String phone;
}
