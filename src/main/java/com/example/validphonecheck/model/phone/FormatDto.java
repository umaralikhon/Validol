package com.example.validphonecheck.model.phone;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "format")
@Data
public class FormatDto implements Serializable, BaseRequestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String international;
    private String local;
}