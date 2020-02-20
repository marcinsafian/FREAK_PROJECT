//package com.freak.project.service.mail;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import java.util.ArrayList;
//import java.util.List;
//
//@AllArgsConstructor
//@Getter
//public class Mail {
//    private final String sendTo;
//    private final String subject;
//    private final String message;
//
//    public static class MailBuild {
//        private  String sendTo;
//        private  String subject;
//        private List<String> messageLines = new ArrayList<>();
//
//        public MailBuild sendTo(String sendTo){
//            this.sendTo = sendTo;
//            return this;
//        }
//        public MailBuild subject(String subiect){
//            this.subject = subiect;
//            return this;
//        }
//        public MailBuild messageLines(String line){
//            messageLines.add(line);
//            return this;
//        }
//        public Mail build(){
//            String message = String.join("\n",messageLines);
//            return new Mail(sendTo,subject,message);
//        }
//    }
//}
