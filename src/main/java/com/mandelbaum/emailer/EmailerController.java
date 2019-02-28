package com.mandelbaum.emailer;

import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.*;
import javax.mail.internet.*;
import javax.validation.ValidationException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
@RequestMapping("/email")
public class EmailerController
{
    private EmailConfig config;

    public EmailerController(EmailConfig emailConfig)
    {
        config = emailConfig;
    }

    @PostMapping
    private void sendEmail(@RequestBody Email email, BindingResult br)
    {
        if(br.hasErrors())
        {
            throw new ValidationException("email failed");
        }

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(this.config.getHost());
        sender.setPort(this.config.getPort());
        sender.setUsername(this.config.getUsername());
        sender.setPassword(this.config.getPassword());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getEmail());
        message.setText(email.getMessage());
        message.setTo("davidbench95@yahoo.com");
        message.setSubject("new message for " + email.getName());

        sender.send(message);

    }
}
