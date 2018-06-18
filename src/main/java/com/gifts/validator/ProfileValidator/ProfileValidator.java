package com.gifts.validator.ProfileValidator;

import com.gifts.entity.Address;
import com.gifts.service.AddressService;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 13.07.17.
 */
@Component
public class ProfileValidator implements Validator {

    @Autowired
    private AddressService addressService;

    @Override
    public void validate(Object o) throws Exception {
        Address address = (Address) o;

        if(address.getStreet().isEmpty()){
            throw new ProfileException(ProfileValidatorMessages.STREET_FIELD_IS_EMPTY);
        }else if(address.getNumber_of_build().isEmpty()){
            throw new ProfileException(ProfileValidatorMessages.EMPTY_NUMBER_OF_BUILD_FIELD);
        }else  if(address.getNumber_of_apartament().isEmpty()){
            throw new ProfileException(ProfileValidatorMessages.EMPTY_NUMBER_OF_APA_FIELD);
        }else if(address.getTown().isEmpty()){
            throw  new ProfileException(ProfileValidatorMessages.EMPTY_TOWN_FIELD);
        }else  if(!address.getTown().replaceAll("[^0-9]","").isEmpty()){
            throw  new ProfileException(ProfileValidatorMessages.TOWN_CONTAIN_NUMBERS);
        }

    }
}
