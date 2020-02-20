package com.freak.project.service.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    private JavaMailSender javaMailSender;

    private static MailService mailServiceInstance = null;

    public static MailService getInstance() {
        if (mailServiceInstance == null) {
            mailServiceInstance = new MailService();
        }
        return mailServiceInstance;
    }
    private MailService(){}
    private MimeMessagePreparator createMimeMessage(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getSendTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(mail.getMessage());
        };
    }
    void send(final Mail mail) {
        LOGGER.info("Working for preparation your email...");
        try {
            javaMailSender.send(createMimeMessage(mail));
            LOGGER.info("Email has been sent.");
        } catch(MailException e) {
            LOGGER.error("We have problem with your email " + e.getMessage(), e);
        }
    }
}
