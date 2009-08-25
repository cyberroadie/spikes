package net.transformatorhuis.junit.agilejava.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cyberroadie
 */
public class AlarmClock {

    private Client client;

    public AlarmClock(Client client) {
        this.client = client;
    }

    public void submitEvent(Event event, long timeout) {
        try {
            this.wait(timeout);
        } catch (InterruptedException ex) {
            Logger.getLogger(AlarmClock.class.getName()).log(Level.SEVERE, null, ex);
        }
        client.triggerAlarm();
    }
}
