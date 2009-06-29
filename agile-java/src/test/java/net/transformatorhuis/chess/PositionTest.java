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
        position = new Position("h8");
        assertEquals(7, position.getFile());
        assertEquals(0, position.getRank());
        position = new Position("a2");
        assertEquals(0, position.getFile());
        assertEquals(6, position.getRank());
        position = new Position("b6");
        assertEquals(1, position.getFile());
        assertEquals(2, position.getRank());
        position = new Position("h1");
        assertEquals(7, position.getFile());
        assertEquals(7, position.getRank());
    }

}