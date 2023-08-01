package ru.fkjob.delivery.web.service.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.fkjob.delivery.web.dto.mail.WelcomeDTO;

@Service
public class MailMessageSenderImpl implements MessageSender {
    private final JavaMailSender javaMailSender;

    public MailMessageSenderImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public boolean sendMessage(String mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        WelcomeDTO dto = new WelcomeDTO();
        simpleMailMessage.setTo(mail);
        simpleMailMessage.setSubject(dto.getSubject());
        simpleMailMessage.setText(dto.getText());
        javaMailSender.send(simpleMailMessage);
        return true;
    }
}
