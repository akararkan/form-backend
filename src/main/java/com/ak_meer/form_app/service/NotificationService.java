package com.ak_meer.form_app.service;

import com.ak_meer.form_app.model.UserResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.fromNumber}")
    private String fromNumber;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private QuestionService questionService;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String to, String message) {
        Message.creator(new PhoneNumber(to), new PhoneNumber(fromNumber), message).create();
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    public void notifyAdminAndUser(UserResponse userResponse) {
        String subject = "New User Response";

        // Building email body
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("User: ").append(userResponse.getName()).append("\n");
        emailBody.append("Email: ").append(userResponse.getEmail()).append("\n");
        emailBody.append("Phone: ").append(userResponse.getPhone()).append("\n");
        emailBody.append("Responses:\n");

        // Building SMS body
        StringBuilder smsBody = new StringBuilder();
        smsBody.append("Responses:\n");

        userResponse.getAnswers().forEach((questionId, answer) -> {
            String questionText = questionService.getQuestionText(questionId);
            emailBody.append("Question: ").append(questionText).append(": ").append(answer).append("\n");

            // For SMS, include only necessary information due to length constraints
            smsBody.append(questionText).append(": ").append(answer).append("\n");
        });

        // Sending email with full details
        sendEmail(userResponse.getEmail(), subject, emailBody.toString());

        // Sending SMS with question and answer summary
//        sendSms(userResponse.getPhone(), smsBody.toString());
    }
}
