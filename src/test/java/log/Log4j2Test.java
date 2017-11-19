package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by wsylp on 2017/9/17.
 */
public class Log4j2Test {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Log4j2Test.class.getName());
        logger.trace("trace");
        logger.debug("debug");
        logger.info("hello");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
    }

}
