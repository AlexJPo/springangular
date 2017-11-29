package com.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
@Configuration
public class AppStarte {

    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        //Using gmail
        mailSender.setHost("smtp.yandex.ru");
        mailSender.setPort(465);
        mailSender.setUsername("winewinishkin@yandex.ru");
        mailSender.setPassword("winewinishkin29112017");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.ssl.enable", "true");
        javaMailProperties.put("mail.smtps.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(AppStarte.class, args);
    }
}
