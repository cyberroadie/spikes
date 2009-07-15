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

    @Test
    public void testCharacterNo() {
        assertEquals('a', ((char) 97));
        assertEquals('b', ((char) 98));
        assertEquals('c', ((char) 99));
        assertEquals('d', ((char) 100));
        assertEquals('e', ((char) 101));
        assertEquals('f', ((char) 102));
        assertEquals('g', ((char) 103));
        assertEquals('h', ((char) 104));
    }
}
