package com.example.fullstackmailapp.mail;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
     @PostMapping
    public ResponseEntity<String> sendMail(
            @RequestBody MailRequest request
     ) {
         mailService.sendMail(request);
         return ResponseEntity.ok("Mail sent");
     }

     @GetMapping("/received")
     public List<Mail> getReceivedMails(@RequestParam String email){
         return mailService.getAllMailsForUser(email);
     }

}
