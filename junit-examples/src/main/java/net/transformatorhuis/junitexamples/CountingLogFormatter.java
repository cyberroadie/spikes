package net.transformatorhuis.junitexamples;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 *
 * @author cyberroadie
 */
public class CountingLogFormatter extends Formatter {

    CountingLogHandler countingLogHandler = null;

    public CountingLogFormatter() {
    }

    public CountingLogFormatter(CountingLogHandler countingLogHandler) {
        this.countingLogHandler = countingLogHandler;
    }

    @Override
    public String format(LogRecord record) {
        String recordMessage = new String();
        if (countingLogHandler == null) {
            recordMessage = String.format("%s: %s", record.getLevel().getName(), record.getMessage());
        } else {
            recordMessage = String.format(
                    "%s: %s (%s total = %d)",
                    record.getLevel().getName(),
                    record.getMessage(),
                    record.getLevel().getName(),
                    countingLogHandler.getLevelCount(record.getLevel()));
        }
        return recordMessage;
    }
}
