package net.transformatorhuis.junit.agilejava.thread;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
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
    private final Object monitor = new Object();
    private Hashtable<Date, AlarmEvent> alarmList = new Hashtable<Date, AlarmEvent>();

    public AlarmClock(AlarmClockClient client) {
        this.client = client;
    }

    public static Date now(long extraTime) {
        long now = Calendar.getInstance().getTime().getTime();
        return new Date(now + extraTime);
    }

    @Override
    public void run() {
        while (alive) {
            try {
                sleep(500);
                if (alarmList.size() > 0) {
                    synchronized (this) {
                        Set<Date> alarmTimes = alarmList.keySet();
                        for (Date date : alarmTimes) {
                            if (date.getTime() < now(0).getTime()) {
                                client.triggerAlarm(alarmList.get(date));
                                alarmList.remove(date);
                                break;
                            }
                        }
                    }
                }
            } catch (InterruptedException ex) {
                if (!alive) {
                    break;
                }
            }
        }
    }

    public void shutdown() {
        alive = false;
        this.interrupt();
    }

    public void setAlarm(AlarmEvent event, Date alarm) {
        alarmList.put(alarm, event);
    }

    public void deleteAlarm(Date date) {
        alarmList.remove(date);
    }
}
