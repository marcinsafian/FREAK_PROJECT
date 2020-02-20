package com.freak.project.service.mail;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class Mail {
    private final String sendTo;
    private final String subject;
    private final String message;

    public static class MailBuild {
        private String sendTo;
        private String subject;
        private List<String> messageLine = new ArrayList<>();

        public MailBuild sendTo(String sendTo) {
            this.sendTo = sendTo;
            return this;
        }

        public MailBuild subject(String subject) {
            this.subject = subject;
            return this;
        }

        public MailBuild messageLine(String line) {
            messageLine.add(line);
            return this;
        }

        public Mail build() {
            String message = String.join("\n", messageLine);
            return new Mail(sendTo, subject, message);
        }
    }

    private Mail(final String sendTo, final String subject, String message) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.message = message;
    }
}