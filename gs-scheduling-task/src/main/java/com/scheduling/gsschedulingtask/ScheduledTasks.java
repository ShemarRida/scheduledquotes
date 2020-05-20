package com.scheduling.gsschedulingtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random",Quote.class);
        log.info(quote.toString());
    }
}
