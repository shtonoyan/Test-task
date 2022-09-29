package gui.core;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;

@UtilityClass
@Log4j
public class Logger {
    public void log(Object logText) {
        log.info(logText);
    }
}
