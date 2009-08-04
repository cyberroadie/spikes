package net.transformatorhuis.junit.agilejava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class EvaluationOrderTest {

    public EvaluationOrderTest() {
    }

    @Test
    public void evaluationOrder() {
        final double TOLERANCE = 0.01;
        int x = 5; int y = 10;
        assertEquals(39 , x * 5 + y++ * 7 / 5);
        x = 5; y = 10;
        assertEquals(300 , ++x * 5 * y++);
        x = 5; y = 10;
        assertEquals(275 , x++ * 5 * ++y);
        x = 5; y = 10;
        assertEquals(51 , ++x + 5 * 7 + y++);
//        x = 5; y = 10;
//        assertEquals(51 , ++y++ % ++x++);
        x = 5; y = 10;
        assertEquals(true , x * 7 == 35 || y++ == 0);
        x = 5; y = 10;
        assertEquals(66 , ++x * ++y);
        x = 5; y = 10;
        assertEquals(50 , x++ * y++);
//        x = 5; y = 10;
//        assertEquals(true , true && x * 7);
        x = 5; y = 10;
        assertEquals(true ,x * 2 == y-- || ++y == 10);
        x = 5; y = 10;
        assertEquals(true ,x * 2 == --y || ++y == 10);

    }
}