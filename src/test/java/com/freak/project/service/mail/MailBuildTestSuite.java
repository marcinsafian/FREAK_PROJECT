package com.freak.project.service.mail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailBuildTestSuite {
    @Test
void testMailBuild() {
    //Given
    //When
    Mail mail = new Mail.MailBuild().subject("SUBJECT")
            .sendTo("SEND TO")
            .messageLine("FIRST LINE OF MESSAGE")
            .messageLine("2nd LINE OF MESSAGE")
            .messageLine("last LINE OF MESSAGE")
            .build();
    assertEquals("SUBJECT", mail.getSubject());
    assertEquals("SEND TO", mail.getSendTo());
    assertEquals("FIRST LINE OF MESSAGE\n2nd LINE OF MESSAGE\nlast LINE OF MESSAGE", mail.getMessage());
}
}