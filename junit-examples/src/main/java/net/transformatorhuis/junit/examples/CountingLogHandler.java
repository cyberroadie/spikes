package net.transformatorhuis.junit.examples;

import java.util.HashMap;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 *
 * @author cyberroadie
 */
public class CountingLogHandler extends Handler {

    HashMap<Level, Integer> severityMap = new HashMap<Level, Integer>();

    public CountingLogHandler() {
        severityMap.put(Level.FINE, 0);
        severityMap.put(Level.FINER, 0);
        severityMap.put(Level.FINEST, 0);
        severityMap.put(Level.INFO, 0);
        severityMap.put(Level.SEVERE, 0);
        severityMap.put(Level.WARNING, 0);
        severityMap.put(Level.CONFIG, 0);
    }

    public int getLevelCount(Level level) {
        return severityMap.get(level);
    }

    @Override
    public void publish(LogRecord record) {
        severityMap.put(record.getLevel(), severityMap.get(record.getLevel()) + 1);
        System.out.println(this.getFormatter().format(record));
    }

    @Override
    public void flush() {
        
    }

    @Override
    public void close() throws SecurityException {
        
    }

}
