package com.gifts.validator.UserValidator;

import com.gifts.entity.User;
import com.gifts.service.UserService;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 29.05.17.
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getLogin().isEmpty()){
            throw new UserException(UserValidatorMessages.EMPTY_USERNAME_FIELD);
        }else  if (userService.findByName(user.getLogin()) !=null){
            throw  new UserException(UserValidatorMessages.USERNAME_ALREADY_EXIST);
        } else if (userService.findByEmail(user.getEmail()) !=null) {
            throw  new UserException(UserValidatorMessages.EMAIL_ALREADY_EXIST);
        }/*if(user.getEmail().contains("@")){

        }*/

    }


}
