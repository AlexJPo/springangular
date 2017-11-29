package com.hw.services;

import com.hw.interfaces.MailService;
import com.hw.model.Email;
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
    public void sendEmail(Object emailObject) {
        MimeMessagePreparator preparator = getMessagePreparator((Email)emailObject);

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator(Email email) {
        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress("winewinishkin@yandex.ru"));
            if (email.getTo().isEmpty()) {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("vbbaryshnikov@gmail.com"));
            } else {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
            }

            mimeMessage.setText(email.getBody());
            mimeMessage.setSubject("Wine");
        };
        return preparator;
    }
}
