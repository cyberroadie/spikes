package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.Pawn;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BoardTest {

    Board board;

    @Before
    public void createBoard() {
        board = new Board();
    }
    @Test
    public void testCreate() {
        Board board = new Board();
        assertEquals(0, board.getNoOfPieces());
    }

    @Test
    public void testAddPawn() {
        Board board = new Board();
        assertEquals(0, board.getNoOfPieces());
        Pawn pawn = new Pawn();
        board.addPawn(pawn);
        assertEquals(1, board.getNoOfPieces());
        assertTrue(board.getPieces().contains(pawn));


    }
}
