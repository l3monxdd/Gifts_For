package com.gifts.validator.UserValidator;

import com.gifts.dao.UserDao;
import com.gifts.entity.User;
import com.gifts.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 12.07.17.
 */
@Component
public class UserLoginValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getLogin().isEmpty()) {
            throw new UserException(UserLoginValidationMessages.EMPTY_USERNAME_FIELD);
        } else if (userDao.findByLogin(user.getLogin()) == null) {
            throw new UserException(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD);
        } else if (encoder.matches(user.getPassword(),
                userDao.findByLogin(user.getLogin()).getPassword())){
            throw new UserException(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD);
        }

    }
}
