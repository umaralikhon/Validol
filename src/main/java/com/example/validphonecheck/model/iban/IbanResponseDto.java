package com.example.validphonecheck.model.iban;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "iban")
@Data
public class IbanResponseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("iban")
    private String iban;

    @JsonProperty("is_valid")
    private Boolean isValid;
}
