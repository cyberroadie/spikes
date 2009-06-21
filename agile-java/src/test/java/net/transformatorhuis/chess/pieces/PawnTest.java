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

        Pawn whitePawn = new Pawn(Pawn.WHITE, Pawn.WHITE_CHAR);
        assertEquals(white, whitePawn.getColor());
        assertEquals("p", whitePawn.toString());

        Pawn blackPawn = new Pawn(Pawn.BLACK, Pawn.BLACK_CHAR);
        assertEquals(black, blackPawn.getColor());
        assertEquals("P", blackPawn.toString());

    }

    @Test
    public void testCreateDefault() {
        Pawn pawn = new Pawn();
        assertEquals(white, pawn.getColor());
    }

}
