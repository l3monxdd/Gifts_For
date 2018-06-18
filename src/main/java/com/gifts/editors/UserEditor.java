package com.gifts.editors;

import com.gifts.entity.User;
import com.gifts.service.UserService;

import java.beans.PropertyEditorSupport;

/**
 * Created by dell on 27.05.17.
 */
public class UserEditor extends PropertyEditorSupport {

    private final UserService userService;


    public UserEditor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setAsText(String idFromJSP) throws IllegalArgumentException {

        User user = userService.findOne(Integer.parseInt(idFromJSP));

        setValue(user);

    }



}
