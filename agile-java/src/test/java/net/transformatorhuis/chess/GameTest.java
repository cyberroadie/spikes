package net.transformatorhuis.chess;

import java.util.List;
import net.transformatorhuis.chess.pieces.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        assertEquals(King.class, blackStrengthList.get(0).getClass());
        assertEquals(Queen.class, blackStrengthList.get(blackStrengthList.size() - 1).getClass());
        List<Piece> whiteStrengthList = game.getWhiteStrengthList();
        assertEquals(King.class, whiteStrengthList.get(0).getClass());
        assertEquals(Queen.class, whiteStrengthList.get(whiteStrengthList.size() -  1).getClass());
    }

}