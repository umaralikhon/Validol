package com.example.validphonecheck.service;

import com.example.validphonecheck.model.iban.IbanResponseDto;
import com.example.validphonecheck.model.phone.PhoneValidationResponseDto;
import com.example.validphonecheck.repository.IbanResponseRepo;
import com.example.validphonecheck.repository.PhoneResponseRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class IdentityCheck {

    private final PhoneResponseRepo phoneRepo;
    private final IbanResponseRepo ibanRepo;

    public Boolean checkForPhoneIdentity(String phone){
        List<PhoneValidationResponseDto> phoneList = phoneRepo.findAll();
        Boolean isExist = false;

        for(PhoneValidationResponseDto p: phoneList){
            if(p.getPhone().equals(phone)){
                isExist = true;
            }
        }
        return isExist;
    }

    public Boolean checkForIbanIdentity(String iban){
        List<IbanResponseDto> ibanList = ibanRepo.findAll();
        Boolean isExist = false;

        for(IbanResponseDto i : ibanList){
            if(i.getIban().equals(iban)){
                isExist = true;
            }
        }
        return isExist;
    }
}
