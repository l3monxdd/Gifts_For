package com.gifts.validator.MeasuringSystemValidator;

import com.gifts.entity.MeasuringSystem;
import com.gifts.service.MeasuringSystemService;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 30.05.17.
 */
@Component
public class MeasuringSystemValidator implements Validator {

    @Autowired
    private MeasuringSystemService measuringSystemService;

    @Override
    public void validate(Object o) throws Exception {

        MeasuringSystem measuringSystem = (MeasuringSystem) o;

        if (measuringSystem.getName().isEmpty()){
            throw  new MeasuringSystemException(MeasuringSystemValidatorMessages.EMPTY_NAME_FIELD);
        }else if (measuringSystemService.findByName(measuringSystem.getName()) !=null){
            throw  new MeasuringSystemException(MeasuringSystemValidatorMessages.MEASURING_SYSTEM_ALREADY_EXIST);
        }

    }
}
