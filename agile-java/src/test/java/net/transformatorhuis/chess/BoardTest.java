package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.*;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class BoardTest {

    Board board;
    final String boardLayout =
            ".KR.....\n" +
            "P.PB....\n" +
            ".P..Q...\n" +
            "........\n" +
            ".....nq.\n" +
            ".....p.p\n" +
            ".....pp.\n" +
            "....rk..\n";

    @Test
    public void testCreate() {
        assertEquals(15, board.getNoOfPieces());
        System.out.println(board.print());
        assertEquals(boardLayout, board.print());
    }

    @Test
    public void testCount() {
        assertEquals(3, board.getNoOfBlackPieces(Pawn.class));
        assertEquals(4, board.getNoOfWhitePieces(Pawn.class));
    }

    @Test
    public void testCountWhenReplacingPiece() {
        board.putPiece(Pawn.createBlackPiece(), new Position("e6"));
        assertEquals(15, board.getNoOfPieces());
    }

    @Test
    public void testGetPiece() {
        Piece whitePawn = board.getPiece(new Position("f3"));
        assertTrue(whitePawn instanceof Pawn);
        assertTrue(whitePawn.isWhite());

        Piece blackPawn = board.getPiece(new Position("c7"));
        assertTrue(blackPawn instanceof Pawn);
        assertTrue(blackPawn.isBlack());

    }

    @Before
    public void createBoard() {
        board = new Board();
        board.putPiece(King.createBlackPiece(), new Position("b8"));
        board.putPiece(Rook.createBlackPiece(), new Position("c8"));
        board.putPiece(Pawn.createBlackPiece(), new Position("a7"));
        board.putPiece(Pawn.createBlackPiece(), new Position("c7"));
        board.putPiece(Bishop.createBlackPiece(), new Position("d7"));
        board.putPiece(Pawn.createBlackPiece(), new Position("b6"));
        board.putPiece(Queen.createBlackPiece(), new Position("e6"));
        board.putPiece(Knight.createWhitePiece(), new Position("f4"));
        board.putPiece(Queen.createWhitePiece(), new Position("g4"));
        board.putPiece(Pawn.createWhitePiece(), new Position("f3"));
        board.putPiece(Pawn.createWhitePiece(), new Position("h3"));
        board.putPiece(Pawn.createWhitePiece(), new Position("f2"));
        board.putPiece(Pawn.createWhitePiece(), new Position("g2"));
        board.putPiece(Rook.createWhitePiece(), new Position("e1"));
        board.putPiece(King.createWhitePiece(), new Position("f1"));
    }

    @Test
    public void testIterator() {
        int i = 0;
        for (Piece piece : board) {
            switch (i) {
                case 0:
                    assertTrue(piece instanceof King);
                    break;
                case 4:
                    assertTrue(piece instanceof Bishop);
                    break;
            }
            i++;
        }
    }
   
}
