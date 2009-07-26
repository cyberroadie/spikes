package net.transformatorhuis.junit.examples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class exclusiveOrAndPrecedenceOfOperatorsTest {

    @Test
    public void exclusiveOrTest() {
        assertFalse(true ^ true);
        assertFalse(false ^ false);
        assertTrue(true ^ false);
        assertTrue(false ^ true);
    }

    @Test
    public void precedence() {
        assertTrue(!true && true ^ true || true );
    }
}
