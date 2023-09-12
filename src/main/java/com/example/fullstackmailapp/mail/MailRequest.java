package com.example.fullstackmailapp.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {
        private String subject;
        private String message;
        private String sender;
        private String receiver;
}
