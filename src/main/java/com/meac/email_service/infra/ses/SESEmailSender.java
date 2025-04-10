package com.meac.email_service.infra.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.meac.email_service.adapters.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class SESEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService emailService;


    public SESEmailSender(AmazonSimpleEmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {

        SendEmailRequest request = new SendEmailRequest()
                .withSource("meac@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message().withSubject(new Content(subject)).withBody(new Body().withText(new Content(body))));


        try {
            emailService.sendEmail(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
