package net.transformatorhuis.chess;

import java.util.List;
import net.transformatorhuis.chess.pieces.Piece;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.Assert.*;
import static net.transformatorhuis.chess.pieces.Piece.Type.*;

/**
 *
 * @author cyberroadie
 */
public class BoardTest {

    Board board;
   
    @Test
    public void testCreate() {
        assertEquals(15, board.getNoOfPieces());
        System.out.println(board.print());
        assertEquals(
                ".KR.....\n" +
                "P.PB....\n" +
                ".P..Q...\n" +
                "........\n" +
                ".....nq.\n" +
                ".....p.p\n" +
                ".....pp.\n" +
                "....rk..\n",
                board.print()
                );
                
    }

    @Test
    public void testCount() {
        assertEquals(3, board.getNoOfBlackPieces(PAWN));
        assertEquals(4, board.getNoOfWhitePieces(PAWN));
    }

    @Test
    public void testCountWhenReplacingPiece() {
        board.putPiece(Piece.createBlackPiece(PAWN), new Position("e6"));
        assertEquals(15, board.getNoOfPieces());
    }

    @Test
    public void testGetPiece() {
        Piece whitePawn = board.getPiece(new Position("f3"));
        assertEquals(PAWN, whitePawn.getType());
        assertTrue(whitePawn.isWhite());

        Piece blackPawn = board.getPiece(new Position("c7"));
        assertEquals(PAWN, blackPawn.getType());
        assertTrue(blackPawn.isBlack());

    }

    @Before
    public void createBoard() {
        board = new Board();
        board.putPiece(Piece.createBlackPiece(KING), new Position("b8"));
        board.putPiece(Piece.createBlackPiece(ROOK), new Position("c8"));
        board.putPiece(Piece.createBlackPiece(PAWN), new Position("a7"));
        board.putPiece(Piece.createBlackPiece(PAWN), new Position("c7"));
        board.putPiece(Piece.createBlackPiece(BISHOP), new Position("d7"));
        board.putPiece(Piece.createBlackPiece(PAWN), new Position("b6"));
        board.putPiece(Piece.createBlackPiece(QUEEN), new Position("e6"));
        board.putPiece(Piece.createWhitePiece(KNIGHT), new Position("f4"));
        board.putPiece(Piece.createWhitePiece(QUEEN), new Position("g4"));
        board.putPiece(Piece.createWhitePiece(PAWN), new Position("f3"));
        board.putPiece(Piece.createWhitePiece(PAWN), new Position("h3"));
        board.putPiece(Piece.createWhitePiece(PAWN), new Position("f2"));
        board.putPiece(Piece.createWhitePiece(PAWN), new Position("g2"));
        board.putPiece(Piece.createWhitePiece(ROOK), new Position("e1"));
        board.putPiece(Piece.createWhitePiece(KING), new Position("f1"));
    }

}
