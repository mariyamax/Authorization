package authorization.utils;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private static org.apache.logging.log4j.Logger log;

    public static void info(String info) {
        if (log == null){
            log = LogManager.getLogger();
        }
        log.info(info);
    }

    public static void error(String error) {
        if (log == null){
            log = LogManager.getLogger();
        }
        log.error(error);
    }

}
