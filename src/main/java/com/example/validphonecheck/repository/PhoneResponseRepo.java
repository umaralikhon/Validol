package com.example.validphonecheck.repository;

import com.example.validphonecheck.model.phone.PhoneValidationResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneResponseRepo extends JpaRepository<PhoneValidationResponseDto, Long> {
}
