package net.transformatorhuis.junitexamples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class ValueOfCharacterTest {

    @Test
    public void getCharCount() {
        assertEquals(10, Character.getNumericValue('a'));
        assertEquals(10, Character.getNumericValue('A'));
    }
    
}
