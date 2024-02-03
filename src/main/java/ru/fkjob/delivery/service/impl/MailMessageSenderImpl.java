package ru.fkjob.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.dto.baseuser.UserDto;
import ru.fkjob.delivery.service.MessageSender;

@Service
@RequiredArgsConstructor
public class MailMessageSenderImpl implements MessageSender {
    private final JavaMailSender mailSender;

    @Override
    public String sendMessage(UserDto user) {
        SimpleMailMessage message =  new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Подтверждение регистрации");
        message.setText("Пожалуйста, подтвердите свою регистрацию, перейдя по следующей ссылке:\n"
                + "http://localhost:8080/confirm?token=" + user.getUsername());
        mailSender.send(message);
        return "Сообщение успешно отправлено!";
    }
}
