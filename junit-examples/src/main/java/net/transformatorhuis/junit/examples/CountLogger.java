package net.transformatorhuis.junit.examples;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cyberroadie
 */
public class CountLogger {

    Logger logger = Logger.getLogger(CountLogger.class.getName());

    public CountLogger() {
        
    }

    public void logSeverities() {
        logger.fine("fine");
        logger.finer("finer");
        logger.finer("finer");
        logger.finer("finer");
        logger.finest("finest");
        logger.finest("finest");
        logger.info("info");
        logger.info("info");
        logger.info("info");
        logger.info("info");
        logger.info("info");
        logger.severe("severe");
        logger.severe("severe");
        logger.warning("warning");
        logger.warning("warning");
        logger.warning("warning");
        logger.warning("warning");
    }


}
