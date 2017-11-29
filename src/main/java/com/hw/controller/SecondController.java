package com.hw.controller;

import com.hw.model.AnswerMessage;
import com.hw.model.Email;
import com.hw.services.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/second")
public class SecondController {
    @Autowired
    MailServiceImpl mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    //@ResponseStatus(value = HttpStatus.OK)
    public AnswerMessage sendMail(@RequestBody Email mail) {
        mailService.sendEmail(mail);

        AnswerMessage answerMessage = new AnswerMessage();
        answerMessage.setData("Email was send");
        answerMessage.setStatus(true);
        answerMessage.setMessage("work");

        return answerMessage;
    }
}
