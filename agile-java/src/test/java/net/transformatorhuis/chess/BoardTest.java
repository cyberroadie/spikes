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


    @Test
    public void testRelativeStrength() {

        board.setPiece(Piece.createBlackPiece(Piece.Type.KING), "b8");
        board.setPiece(Piece.createBlackPiece(Piece.Type.ROOK), "c8");
        assertEquals(5f, board.getBlackStrength());
        assertEquals(0f, board.getWhiteStrength());
        board.setPiece(Piece.createBlackPiece(Piece.Type.PAWN), "a7");
        board.setPiece(Piece.createBlackPiece(Piece.Type.PAWN), "c7");
        board.setPiece(Piece.createBlackPiece(Piece.Type.BISHOP), "d7");
        assertEquals(10f, board.getBlackStrength());
        assertEquals(0f, board.getWhiteStrength());
        board.setPiece(Piece.createBlackPiece(Piece.Type.PAWN), "b6");
        board.setPiece(Piece.createBlackPiece(Piece.Type.QUEEN), "e6");
        assertEquals(20f, board.getBlackStrength());
        assertEquals(0f, board.getWhiteStrength());
        board.setPiece(Piece.createWhitePiece(Piece.Type.KNIGHT), "f4");
        board.setPiece(Piece.createWhitePiece(Piece.Type.QUEEN), "g4");
        assertEquals(20f, board.getBlackStrength());
        assertEquals(11.5f, board.getWhiteStrength());
        board.setPiece(Piece.createWhitePiece(Piece.Type.PAWN), "f3");
        board.setPiece(Piece.createWhitePiece(Piece.Type.PAWN), "h3");
        assertEquals(20f, board.getBlackStrength());
        assertEquals(13.5f, board.getWhiteStrength());
        board.setPiece(Piece.createWhitePiece(Piece.Type.PAWN), "f2");
        board.setPiece(Piece.createWhitePiece(Piece.Type.PAWN), "g2");
        assertEquals(20f, board.getBlackStrength());
//        assertEquals(14.5f, board.getWhiteStrength());
        board.setPiece(Piece.createWhitePiece(Piece.Type.ROOK), "e1");
        board.setPiece(Piece.createWhitePiece(Piece.Type.KING), "f1");
        assertEquals(20f, board.getBlackStrength());
//        assertEquals(19.5f, board.getWhiteStrength());


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

//        assertEquals(20f, board.getBlackStrength());
//        assertEquals(19.5f, board.getWhiteStrength());

    }


}
