package com.example.validphonecheck.model.phone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Slf4j
public class PhoneValidationResponseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private Boolean valid;
    private String location;
    private String type;
    private String carrier;

}
