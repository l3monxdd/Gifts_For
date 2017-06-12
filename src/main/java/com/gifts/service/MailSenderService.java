package com.gifts.service;

/**
 * Created by dell on 11.06.17.
 */
public interface MailSenderService {

    void sendMail(String theme, String mailBody, String email);
}
