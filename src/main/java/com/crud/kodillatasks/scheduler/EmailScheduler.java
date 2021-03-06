package com.crud.kodillatasks.scheduler;

import com.crud.kodillatasks.config.AdminConfig;
import com.crud.kodillatasks.domain.Mail;
import com.crud.kodillatasks.repository.TaskRepository;
import com.crud.kodillatasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Trello";

    @Autowired
    private SimpleEmailService emailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    //@Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "*/60 * * * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        emailService.sendTrelloMime(new Mail(adminConfig.getAdminMail(), SUBJECT,
                "Currently in database you got: " + size + (size == 1 ?" task":" tasks")));
    }
}
