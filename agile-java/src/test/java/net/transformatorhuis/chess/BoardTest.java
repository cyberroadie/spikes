package net.transformatorhuis.chess;

import java.util.List;
import net.transformatorhuis.chess.pieces.Piece;
import org.junit.Before;
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
        board.setPiece(Piece.createBlackPiece(PAWN), "e6");
        assertEquals(15, board.getNoOfPieces());
    }

    @Test
    public void testGetPiece() {
        Piece whitePawn = board.getPiece("f3");
        assertEquals(PAWN, whitePawn.getType());
        assertTrue(whitePawn.isWhite());

        Piece blackPawn = board.getPiece("c7");
        assertEquals(PAWN, blackPawn.getType());
        assertTrue(blackPawn.isBlack());

    }

    @Test
    public void testRelativeStrength() {
        assertEquals(20f, board.getBlackStrength());
        assertEquals(19.5f, board.getWhiteStrength());
    }

    @Test
    public void testSorting() {
        board.getBlackStrength();
        board.getWhiteStrength();
        List<Piece> blackStrengthList = board.getBlackStrengthList();
        assertEquals(KING, blackStrengthList.get(0).getType());
        assertEquals(QUEEN, blackStrengthList.get(blackStrengthList.size() - 1).getType());
        List<Piece> whiteStrengthList = board.getWhiteStrengthList();
        assertEquals(KING, whiteStrengthList.get(0).getType());
        assertEquals(QUEEN, whiteStrengthList.get(whiteStrengthList.size() -  1).getType());
        
    }

    @Before
    public void createBoard() {
        board = new Board();
        board.setPiece(Piece.createBlackPiece(KING), "b8");
        board.setPiece(Piece.createBlackPiece(ROOK), "c8");
        board.setPiece(Piece.createBlackPiece(PAWN), "a7");
        board.setPiece(Piece.createBlackPiece(PAWN), "c7");
        board.setPiece(Piece.createBlackPiece(BISHOP), "d7");
        board.setPiece(Piece.createBlackPiece(PAWN), "b6");
        board.setPiece(Piece.createBlackPiece(QUEEN), "e6");
        board.setPiece(Piece.createWhitePiece(KNIGHT), "f4");
        board.setPiece(Piece.createWhitePiece(QUEEN), "g4");
        board.setPiece(Piece.createWhitePiece(PAWN), "f3");
        board.setPiece(Piece.createWhitePiece(PAWN), "h3");
        board.setPiece(Piece.createWhitePiece(PAWN), "f2");
        board.setPiece(Piece.createWhitePiece(PAWN), "g2");
        board.setPiece(Piece.createWhitePiece(ROOK), "e1");
        board.setPiece(Piece.createWhitePiece(KING), "f1");
    }


}
