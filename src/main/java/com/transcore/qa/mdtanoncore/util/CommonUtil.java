package com.transcore.qa.mdtanoncore.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
public class CommonUtil {

    public static int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    public void waitForMinutes(int noOfMinutes) {
        log.info("Waiting for {} minutes.",noOfMinutes);
        for (int i = 0; i < noOfMinutes; i++) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
