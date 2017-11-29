package com.hw.controller;

import com.hw.services.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {
    @Autowired
    MailServiceImpl mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public void sendMail() {
        mailService.sendEmail();
    }
}
