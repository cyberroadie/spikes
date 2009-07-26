package net.transformatorhuis.junit.examples;

import net.transformatorhuis.junit.examples.*;
import java.util.logging.Formatter;
import java.util.logging.Level;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class CountLoggerTest {
    
    public CountLoggerTest() {
    }

    @Before
    public void createCountLogger() {
        
    }
    
    /**
     * Test of logSeverities method, of class CountLogger.
     */
    @Test
    public void testLogSeverities() {
        CountingLogHandler countHandler = new CountingLogHandler();
        CountLogger countLogger = new CountLogger();
        Formatter formatter = new CountingLogFormatter();
        countLogger.logger.setUseParentHandlers(false);
        countHandler.setFormatter(formatter);
        countLogger.logger.addHandler(countHandler);
        countLogger.logger.setLevel(Level.ALL);
        countLogger.logSeverities();
        assertEquals(3, countHandler.getLevelCount(Level.FINER));
        assertEquals(1, countHandler.getLevelCount(Level.FINE));
        assertEquals(1, countHandler.getLevelCount(Level.FINE));
        assertEquals(2, countHandler.getLevelCount(Level.FINEST));
        assertEquals(5, countHandler.getLevelCount(Level.INFO));
        assertEquals(4, countHandler.getLevelCount(Level.WARNING));
        assertEquals(2, countHandler.getLevelCount(Level.SEVERE));
        assertEquals(0, countHandler.getLevelCount(Level.CONFIG));
    }

    @Test
    public void testFormatter() {
        CountingLogHandler countHandler = new CountingLogHandler();
        CountLogger countLogger = new CountLogger();
        countLogger.logger.setUseParentHandlers(false);
        Formatter formatter = new CountingLogFormatter(countHandler);
        countHandler.setFormatter(formatter);
        countLogger.logger.addHandler(countHandler);
        countLogger.logger.setLevel(Level.ALL);
        countLogger.logSeverities();
    }

}