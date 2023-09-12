package com.example.fullstackmailapp.mail;

import com.example.fullstackmailapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final UserRepository userRepository;
    private final MailRepository mailRepository;

    public void sendMail(MailRequest mailRequest) {
        var sender = userRepository.findByEmail(mailRequest.getSender())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + mailRequest.getSender()));
        var receiver = userRepository.findByEmail(mailRequest.getReceiver())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + mailRequest.getReceiver()));
        Mail mail = Mail.builder()
                .subject(mailRequest.getSubject())
                .message(mailRequest.getMessage())
                .sender(sender)
                .receiver(receiver)
                .isRead(false)
                .isFavourite(false)
                .date(new Date())
                .build();
        mailRepository.save(mail);


    }

    public List<Mail> getAllMailsForUser(String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        return mailRepository.findAll();
    }
}
