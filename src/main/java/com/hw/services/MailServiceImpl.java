package com.hw.services;

import com.hw.interfaces.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessagePreparator;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void sendEmail() {
        MimeMessagePreparator preparator = getMessagePreparator();

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator() {
        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress("winewinishkin@yandex.ru"));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("vbbaryshnikov@gmail.com"));
            mimeMessage.setText("Тестовоетекствовое письмо, которое может положить начало разработке сервера на spring оп винишку - е хо хо и бутылка рома :)");
            mimeMessage.setSubject("Wine");
        };
        return preparator;
    }
}
