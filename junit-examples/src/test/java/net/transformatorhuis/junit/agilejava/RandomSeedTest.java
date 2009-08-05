package net.transformatorhuis.junit.agilejava;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class RandomSeedTest {

    public RandomSeedTest() {
    }

    @Test
    public void testSeed() {
        Random randomWithSeed = new Random(1);
        Random randomWithOutSeed = new Random();
        assertTrue(randomWithOutSeed.nextDouble() != randomWithSeed.nextDouble());
    }

}