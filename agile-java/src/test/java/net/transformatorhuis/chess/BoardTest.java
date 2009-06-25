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
        assertEquals(0, board.getNoOfPieces());
        System.out.println(board.print());
        assertEquals(
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n",
                board.print()
                );
                
    }

    @Test
    public void testCount() {
        assertEquals(0, board.getNoOfBlackPieces(Piece.Type.PAWN));
        assertEquals(0, board.getNoOfWhitePieces(Piece.Type.PAWN));
    }

    @Test
    public void testGetPiece() {
//        Piece whitePawn = board.getPiece("a2");
//        assertEquals(Piece.Type.PAWN, whitePawn.getType());
//        assertTrue(whitePawn.isWhite());
//
//        Piece blackPawn = board.getPiece("f7");
//        assertEquals(Piece.Type.PAWN, blackPawn.getType());
//        assertTrue(blackPawn.isBlack());

    }

    @Test
    public void setPiece() {
        Piece blackKing = Piece.createBlackPiece(Piece.Type.KING);
        Piece blackRook = Piece.createBlackPiece(Piece.Type.ROOK);
        Piece whiteKing = Piece.createWhitePiece(Piece.Type.KING);

        board.setPiece(whiteKing, "c4");
        board.setPiece(blackKing, "b6");
        board.setPiece(blackRook, "b5");

        System.out.println(board.print());
        assertEquals(
                "........\n" +
                "........\n" +
                ".K......\n" +
                ".R......\n" +
                "..k.....\n" +
                "........\n" +
                "........\n" +
                "........\n",
                board.print()
                );
    }

}
