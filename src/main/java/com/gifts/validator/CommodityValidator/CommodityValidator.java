package com.gifts.validator.CommodityValidator;

import com.gifts.dao.CommodityDao;
import com.gifts.entity.Commodity;
import com.gifts.entity.CommodityCounter;
import com.gifts.service.CommodityService;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 31.05.17.
 */

@Component
public class CommodityValidator implements Validator{

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void validate(Object o) throws Exception {

        Commodity commodity = (Commodity) o;

        if (commodity.getName_of_commodity().isEmpty()){
            throw  new CommodityException(CommodityValidatorMessages.EMPTY_NAME_OF_COMMODITY_FIELD);
        }else if (commodityDao.findByName_of_commodity(commodity.getName_of_commodity()) !=null){
            throw  new  CommodityException(CommodityValidatorMessages.NAME_OF_COMMODITY_ALREADY_EXIST);
        }
    }
}
