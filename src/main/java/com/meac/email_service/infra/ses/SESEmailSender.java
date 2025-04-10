package com.meac.email_service.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.meac.email_service.adapters.EmailSenderGateway;
import com.meac.email_service.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SESEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService emailService;


    @Autowired
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
        } catch (AmazonServiceException exception) {
           throw new EmailServiceException("A error occurred while sending the email", exception);
        }

    }
}
