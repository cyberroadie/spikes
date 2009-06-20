package net.transformatorhuis.chess.pieces;

import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * @author Olivier Van Acker
 *         Date: 20-Jun-2009
 */
public class PawnTest {

    final String white = "white";
    final String black = "black";

    @Test
    public void testCreate() {

        Pawn pawn = new Pawn(Pawn.WHITE);
        assertEquals(white, pawn.getColor());

        Pawn pawn2 = new Pawn(Pawn.BLACK);
        assertEquals(black, pawn2.getColor());

    }

    @Test
    public void testCreateDefault() {
        Pawn pawn = new Pawn();
        assertEquals(white, pawn.getColor());
    }

}
