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
        board.setPiece(Piece.createBlackPiece(PAWN), new Position("e6"));
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
        board.setPiece(Piece.createBlackPiece(KING), new Position("b8"));
        board.setPiece(Piece.createBlackPiece(ROOK), new Position("c8"));
        board.setPiece(Piece.createBlackPiece(PAWN), new Position("a7"));
        board.setPiece(Piece.createBlackPiece(PAWN), new Position("c7"));
        board.setPiece(Piece.createBlackPiece(BISHOP), new Position("d7"));
        board.setPiece(Piece.createBlackPiece(PAWN), new Position("b6"));
        board.setPiece(Piece.createBlackPiece(QUEEN), new Position("e6"));
        board.setPiece(Piece.createWhitePiece(KNIGHT), new Position("f4"));
        board.setPiece(Piece.createWhitePiece(QUEEN), new Position("g4"));
        board.setPiece(Piece.createWhitePiece(PAWN), new Position("f3"));
        board.setPiece(Piece.createWhitePiece(PAWN), new Position("h3"));
        board.setPiece(Piece.createWhitePiece(PAWN), new Position("f2"));
        board.setPiece(Piece.createWhitePiece(PAWN), new Position("g2"));
        board.setPiece(Piece.createWhitePiece(ROOK), new Position("e1"));
        board.setPiece(Piece.createWhitePiece(KING), new Position("f1"));
    }


}
