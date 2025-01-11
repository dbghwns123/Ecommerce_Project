package com.zerobase.user.service;

import com.zerobase.user.client.MailgunClient;
import com.zerobase.user.client.mailgun.SendMailForm;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {
    private final MailgunClient mailgunClient;

    public Response sendEmail() {
        SendMailForm form = SendMailForm.builder()
                .from("zerobase-test.my.com")
                .to("education.rhinokim.gmail.com")
                .subject("Test email from zero base")
                .text("my text")
                .build();

        return mailgunClient.sendEmail(form);
    }

}
