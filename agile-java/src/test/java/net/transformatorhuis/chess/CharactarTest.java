package net.transformatorhuis.chess;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class CharactarTest {

    @Test
    public void testWhiteSpace() {
        assertTrue(Character.isWhitespace(' '));
        assertTrue(Character.isWhitespace('\t'));
        assertTrue(Character.isWhitespace('\n'));
    }
    
}
