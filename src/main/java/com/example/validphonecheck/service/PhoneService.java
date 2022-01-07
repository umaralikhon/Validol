package com.example.validphonecheck.service;

import com.example.validphonecheck.model.iban.IbanResponseDto;
import com.example.validphonecheck.model.phone.PhoneValidationResponseDto;
import com.example.validphonecheck.repository.IbanResponseRepo;
import com.example.validphonecheck.repository.PhoneResponseRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class PhoneService {
    private final ConnectService connectService;
    private final PhoneResponseRepo phoneResponseRepo;
    private final IbanResponseRepo ibanRepository;
    private final IdentityCheck identityCheck;

    public Boolean checkPhoneIsValid(String phone) {
        ResponseEntity<PhoneValidationResponseDto> response = connectService.connect(phone);

        if (response.getBody().getValid()) {
            if(identityCheck.checkForPhoneIdentity(phone) == false) {
                try {
                    phoneResponseRepo.save(response.getBody());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkIbanValid(String iban) {
        ResponseEntity<IbanResponseDto> ibanResponse = connectService.connectToIban(iban);

        if (ibanResponse.getBody().getIsValid()) {
            if (identityCheck.checkForIbanIdentity(iban) == false) {
                try {
                    ibanRepository.save(ibanResponse.getBody());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return true;
        }else{
            return false;
        }
    }



}
