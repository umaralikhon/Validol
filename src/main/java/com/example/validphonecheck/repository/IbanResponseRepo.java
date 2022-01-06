package com.example.validphonecheck.repository;

import com.example.validphonecheck.model.iban.IbanResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IbanResponseRepo extends JpaRepository<IbanResponseDto, Long> {
}
