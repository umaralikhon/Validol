package com.example.validphonecheck.service;

import com.example.validphonecheck.model.iban.IbanResponseDto;
import com.example.validphonecheck.model.phone.PhoneValidationResponseDto;
import com.example.validphonecheck.repository.IbanResponseRepo;
import com.example.validphonecheck.repository.PhoneResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    private final ConnectService connectService;
    private final PhoneResponseRepo phoneResponseRepo;
    private final IbanResponseRepo ibanRepository;

    @Autowired
    public PhoneService(
            ConnectService connectService,
            PhoneResponseRepo phoneResponseRepo,
            IbanResponseRepo ibanRepository) {

        this.connectService = connectService;
        this.phoneResponseRepo = phoneResponseRepo;
        this.ibanRepository = ibanRepository;
    }

    public Boolean checkPhoneIsValid(String phone) {
        ResponseEntity<PhoneValidationResponseDto> response = connectService.connect(phone);

        if (response.getBody().getValid()) {
            if(checkForPhoneIdentity(phone) == false) {
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

    public Boolean checkForPhoneIdentity(String phone){
        List<PhoneValidationResponseDto> phoneList = phoneResponseRepo.findAll();
        Boolean isExist = false;

        for(PhoneValidationResponseDto p: phoneList){
            if(p.getPhone().equals(phone)){
                isExist = true;
            }
        }
        return isExist;
    }

    public Boolean checkIbanValid(String iban) {
        ResponseEntity<IbanResponseDto> ibanResponse = connectService.connectToIban(iban);

        if (ibanResponse.getBody().getIsValid()) {
            if (checkForIbanIdentity(iban) == false) {
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

    public Boolean checkForIbanIdentity(String iban){
        List<IbanResponseDto> ibanList = ibanRepository.findAll();
        Boolean isExist = false;

        for(IbanResponseDto i : ibanList){
            if(i.getIban().equals(iban)){
                isExist = true;
            }
        }
        return isExist;
    }

}
