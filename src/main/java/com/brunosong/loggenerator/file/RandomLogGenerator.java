package com.brunosong.loggenerator.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class RandomLogGenerator {

    private static final Logger logger = LoggerFactory.getLogger(RandomLogGenerator.class);

    private static final String[] LOG_LEVELS = {"DEBUG", "INFO", "WARN", "ERROR"};
    private static final String[] REQUEST_URLS = {"http://brunosong.com/api", "http://brunosong.com/login", "http://brunosong.com/dashboard"};


    @Scheduled(fixedRate = 2000)
    public void generateRandomLog() {

        Random random = new Random();

        int levelIndex = random.nextInt(LOG_LEVELS.length);
        int urlIndex = random.nextInt(REQUEST_URLS.length);

        String level = LOG_LEVELS[levelIndex];
        String requestUrl = REQUEST_URLS[urlIndex];

        String message = generateRandomMessage(requestUrl);
        String log = String.format("[%s] %s - %s", level, getCurrentTimestamp(), message);

        switch (level) {
            case "DEBUG":
                logger.debug(log);
                break;
            case "INFO":
                logger.info(log);
                break;
            case "WARN":
                logger.warn(log);
                break;
            case "ERROR":
                logger.error(log);
                break;
        }
    }

    private String generateRandomMessage(String requestUrl) {
        return String.format("Request received from %s", requestUrl);
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return dateFormat.format(new Date());
    }

}
