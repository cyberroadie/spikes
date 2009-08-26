package net.transformatorhuis.junit.agilejava.thread;

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
        
        alarmClock.submitEvent(new Event("Alarm!"), 1000);
        Thread.sleep(1200);
        assertEquals("Alarm!", alarmMessage);

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
            System.out.println(alarmMessage);
        }
    }
    
}