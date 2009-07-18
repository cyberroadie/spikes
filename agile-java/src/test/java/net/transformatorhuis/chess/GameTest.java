package net.transformatorhuis.chess;

import java.util.List;
import net.transformatorhuis.chess.pieces.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static net.transformatorhuis.chess.pieces.Piece.Type.*;

/**
 *
 * @author cyberroadie
 */
public class GameTest {

    private static final double TOLERANCE = 0.05;
    Game game;

    public GameTest() {
    }

   @Before
    public void createBoard() {
        Board board = new Board();
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
        game = new Game(board);
    }

    @Test
    public void testRelativeStrength() {
        assertEquals(20f, game.getBlackStrength(), TOLERANCE);
        assertEquals(19.5f, game.getWhiteStrength(), TOLERANCE);
    }

    @Test
    public void testSorting() {
        game.getBlackStrength();
        game.getWhiteStrength();
        List<Piece> blackStrengthList = game.getBlackStrengthList();
        assertEquals(KING, blackStrengthList.get(0).getType());
        assertEquals(QUEEN, blackStrengthList.get(blackStrengthList.size() - 1).getType());
        List<Piece> whiteStrengthList = game.getWhiteStrengthList();
        assertEquals(KING, whiteStrengthList.get(0).getType());
        assertEquals(QUEEN, whiteStrengthList.get(whiteStrengthList.size() -  1).getType());
    }

}