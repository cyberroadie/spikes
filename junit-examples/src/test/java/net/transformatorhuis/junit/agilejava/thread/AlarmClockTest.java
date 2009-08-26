package net.transformatorhuis.junit.agilejava.thread;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class AlarmClockTest {

    String alarmMessage = null;
    AlarmClock alarmClock = null;
    Object monitor = new Object();

    public AlarmClockTest() {
    }

    @After
    public void cleanupThread() throws InterruptedException {
//        assertTrue(alarmClock.isAlive());
        alarmClock.shutdown();
        alarmClock.join(3000);
        assertFalse(alarmClock.isAlive());
    }

    /**
     * Test of submitEvent method, of class AlarmClock.
     */
    @Test
    public void testSubmitEvent() throws InterruptedException {
        alarmClock = new AlarmClock(new Client());
        alarmClock.start();

        Date alarm2 = AlarmClock.now(2000);
        alarmClock.setAlarm(new Event("Alarm1!"), AlarmClock.now(1000));
        alarmClock.setAlarm(new Event("Alarm2!"), alarm2);
        alarmClock.setAlarm(new Event("Alarm3!"), AlarmClock.now(3000));

        synchronized (monitor) {
            monitor.wait();
        }
        assertEquals("Alarm1!", alarmMessage);
        alarmClock.deleteAlarm(alarm2);
        synchronized (monitor) {
            monitor.wait();
        }
        assertEquals("Alarm3!", alarmMessage);

    }

    public class Event implements AlarmEvent {

        String alarmMessage;

        public Event(String alarmMessage) {
            this.alarmMessage = alarmMessage;
        }

        @Override
        public String doSomething() {
            return alarmMessage;
        }
    }

    public class Client implements AlarmClockClient {

        @Override
        public void triggerAlarm(AlarmEvent event) {
            alarmMessage = event.doSomething();
            synchronized(monitor) {
                monitor.notifyAll();
            }
            System.out.println(alarmMessage);
        }
    }
}
