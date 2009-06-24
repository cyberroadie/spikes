package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.Piece;
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
        assertEquals(16, board.getNoOfPieces());
        System.out.println(board.print());
        assertEquals(
                "........\n" +
                "pppppppp\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "PPPPPPPP\n" +
                "........\n",
                board.print()
                );
                
    }

    @Test
    public void testCount() {
        assertEquals(8, board.getNoOfBlackPieces(Piece.Type.PAWN));
        assertEquals(8, board.getNoOfWhitePieces(Piece.Type.PAWN));
    }

    @Test
    public void testGetPiece() {
        Piece whitePawn = board.getPiece("a2");
        assertEquals(Piece.Type.PAWN, whitePawn.getType());
        assertTrue(whitePawn.isWhite());

        Piece blackPawn = board.getPiece("f7");
        assertEquals(Piece.Type.PAWN, blackPawn.getType());
        assertTrue(blackPawn.isBlack());

    }

}
