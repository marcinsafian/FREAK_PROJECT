package com.freak.project.service.mail;

import com.freak.project.domain.Stations;
import com.freak.project.exception.UserNotFoundException;
import com.freak.project.reposytory.MailSentRepository;
import com.freak.project.reposytory.UserRepository;
import com.freak.project.service.ApiWheaderService;
import com.freak.project.statistic.AllUsersCount;
import com.freak.project.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MailScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailScheduler.class);
    private static final String SUBJECT = "The weather";

    private final MailService mailService;
    private final UserRepository userRepository;
    private final ApiWheaderService apiWheaderService;
    private final MailSentRepository mailSentRepository;

    public MailScheduler(MailService mailService, UserRepository userRepository, ApiWheaderService apiWheaderService, MailSentRepository mailSentRepository) {
        this.mailService = mailService;
        this.userRepository = userRepository;
        this.apiWheaderService = apiWheaderService;
        this.mailSentRepository = mailSentRepository;
    }
    @Scheduled(cron = "0 00 08 * * *")
    private void sendMail(){
        LOGGER.info("scheduler start up ");
        int userCount = 0;
        int emailCount = 0;
        for (User user : userRepository.findAll()){
            userCount++;
            if(user.isSchedulerOn()){
                try{
                    mailService.send(prepareMesageToMail(user));
                    emailCount++;
                }catch (Exception e){
                    LOGGER.error("Sorry We have problem with our post office");
                }
            }
        }
        mailSentRepository.save(new AllUsersCount(LocalDateTime.now(),userCount,emailCount));
    }
    public Mail prepareMesageToMail(User user) throws UserNotFoundException {
        Stations stations = (Stations) apiWheaderService.fetchByName("");
        return new Mail.MailBuild().sendTo(user.getEmail()).subject(SUBJECT)
        .messageLines("\tGood morning, " + user.getFirstName() + "!\n")
                .messageLines("Are you wondering what the weather is ?")
                .messageLines(stations.getStacja() + "\n")
                .messageLines("The weather was updated " + stations.getGodzina_pomiaru())
                .messageLines("Wind:\t\t\t\t\t   " + stations.getPredkosc_wiatru()+ "m/s " + stations.getKierunek_wiatru())
                .messageLines("Air temperature:\t\t\t" + stations.getTemperatura() + "\u00B0C")
                .messageLines("Air pressure:\t\t  " + stations.getCisnienie()+ "MPa")
                .messageLines("\nHave a nice day!")
                .build();
    }
}
