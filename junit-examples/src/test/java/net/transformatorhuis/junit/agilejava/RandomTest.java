package net.transformatorhuis.junit.agilejava;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class RandomTest {

    public RandomTest() {
    }

    @Test
    public void random50() {
        for (int i = 0; i < 9999999; i++) {
            int random = randomFifty();
            assertTrue(random >= 0 && random <= 50);
        }
    }

    public int randomFifty() {
        return (int) (Math.random() / 2 * 100);
    }
}