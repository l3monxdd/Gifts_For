package com.gifts.validator.AddressValidator;

import com.gifts.entity.Address;
import com.gifts.service.AddressService;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 30.05.17.
 */
@Component
public class AddressValidator implements Validator {

    @Autowired
    private AddressService addressService;


    @Override
    public void validate(Object o) throws Exception {

        Address address = (Address) o;

        if(address.getStreet().isEmpty()){
            throw  new AddressException(AddressValidatorMessages.EMPTY_STREET_FIELD);
        }else if(addressService.findByStreet(address.getStreet()) !=null){
            throw  new AddressException(AddressValidatorMessages.STREET_ALREADY_EXIST);
        }

    }
}

