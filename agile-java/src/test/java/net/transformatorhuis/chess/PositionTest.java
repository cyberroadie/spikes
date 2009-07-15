package net.transformatorhuis.chess;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class PositionTest {

    public PositionTest() {
    }

    /**
     * Test of getFile method, of class Position.
     */
    @Test
    public void testGet() {
        System.out.println("getFile");
        Position position = new Position("a1");
        assertEquals(0, position.getFile());
        assertEquals(7, position.getRank());
        assertEquals("a1", position.getLocation());
        position = new Position("h8");
        assertEquals(7, position.getFile());
        assertEquals(0, position.getRank());
        assertEquals("h8", position.getLocation());
        position = new Position("a2");
        assertEquals(0, position.getFile());
        assertEquals(6, position.getRank());
        assertEquals("a2", position.getLocation());
        position = new Position("b6");
        assertEquals(1, position.getFile());
        assertEquals(2, position.getRank());
        assertEquals("b6", position.getLocation());
        position = new Position("h1");
        assertEquals(7, position.getFile());
        assertEquals(7, position.getRank());
        assertEquals("h1", position.getLocation());
        position = new Position("a7");
        assertEquals(0, position.getFile());
        assertEquals(1, position.getRank());
        assertEquals("a7", position.getLocation());
    }

}