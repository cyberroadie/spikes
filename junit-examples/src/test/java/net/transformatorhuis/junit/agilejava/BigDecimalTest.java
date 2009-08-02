package net.transformatorhuis.junit.agilejava;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BigDecimalTest {

    public BigDecimalTest() {
    }

    @Test
    public void immutableBigDecimalProof() {
        BigDecimal fatOne = new BigDecimal("10.0000");
        BigDecimal fatTwo = new BigDecimal("20.0000");
        fatOne.add(fatTwo);
        assertEquals(new BigDecimal("10.0000"), fatOne);
        fatOne = fatOne.add(fatTwo);
        assertEquals(new BigDecimal("30.0000"), fatOne);
    }
}