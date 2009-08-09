package net.transformatorhuis.junit.agilejava;

import net.transformatorhuis.junit.examples.*;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author cyberroadie
 */
public class ReverseStackTraceTest {

    Logger logger = Logger.getLogger(ReverseStackTraceTest.class.getName());

    @Test
    public void testReverseStacktrace() {
        try {
            Boom.rethrows();
        } catch (Exception e) {
            reverseStackTrace(e.getStackTrace());
        }
    }

    private void reverseStackTrace(StackTraceElement[] stackTrace) {
        for (int i = stackTrace.length - 1; i >= 0 ; i--) {
            StackTraceElement stackTraceElement = stackTrace[i];
            logger.severe(stackTraceElement.toString());
        }
    }
}
