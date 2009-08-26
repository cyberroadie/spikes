package net.transformatorhuis.junit.agilejava.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cyberroadie
 */
public class AlarmClock extends Thread {

    private AlarmClockClient client;
    private AlarmEvent event = null;
    private long timeout = 0;
    private boolean alive = true;
    private Object monitor = new Object();

    public AlarmClock(AlarmClockClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (alive) {
            try {
                if (event == null) {
                    sleep(100);
                } else {
                    System.out.println("Wait for alarm");
                    synchronized(monitor) {
                        monitor.wait(timeout);
                    }
                    client.triggerAlarm(event);
                    event = null;
                }
            } catch (InterruptedException ex) {
                if(!alive) {
                    break;
                }
            }
        }
    }

    public void shutdown() {
        alive = false;
        this.interrupt();
    }

    public void submitEvent(AlarmEvent event, long timeout) {
        this.event = event;
        this.timeout = timeout;
    }
}
