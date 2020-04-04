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

    public MailScheduler(MailService mailService, UserRepository userRepository,
                         ApiWheaderService apiWheaderService, MailSentRepository mailSentRepository) {
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
        Stations stations = (Stations) apiWheaderService.fetchByName(user.getId().toString());
        return new Mail.MailBuild().sendTo(user.getEmail()).subject(SUBJECT)
        .messageLine("\tGood morning, " + user.getFirstName() + "!\n")
                .messageLine("Are you wondering what the weather is ?")
                .messageLine(stations.getStation() + "\n")
                .messageLine("The weather was updated " + stations.getHour_measure())
                .messageLine("Wind:\t\t\t\t\t   " + stations.getWind_speed()+ "m/s " + stations.getWind_direction())
                .messageLine("Air temperature:\t\t\t" + stations.getTemperature() + "\u00B0C")
                .messageLine("Air pressure:\t\t  " + stations.getPressure()+ "MPa")
                .messageLine("\nHave a nice day!")
                .build();
    }
}
