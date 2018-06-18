package com.gifts.validator.SuitOfDeliveryValidator;

import com.gifts.entity.SuitOfDelivery;
import com.gifts.service.SuitOfDeliveryService;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 29.05.17.
 */

@Component
public class SuitOfDeliveryValidator implements Validator {

    @Autowired
    private SuitOfDeliveryService suitOfDeliveryService;

    @Override
    public void validate(Object o) throws Exception {

        SuitOfDelivery suitOfDelivery = (SuitOfDelivery) o;

        if (suitOfDelivery.getName().isEmpty()){
            throw new  SuitOfDeliveryException(SuitOfDeliveryValidatorMessages.EMPTY_NAME_FIELD);
        }else if (suitOfDeliveryService.findByName(suitOfDelivery.getName()) !=null){
            throw  new SuitOfDeliveryException(SuitOfDeliveryValidatorMessages.SUIT_ALREADY_EXIST);
        }

    }
}
