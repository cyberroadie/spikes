package net.transformatorhuis.chess.pieces;

import java.util.List;
import net.transformatorhuis.chess.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class QueenTest extends PieceTest {

    public QueenTest() {

    }

    @Test
    public void testGetPossibleMovesQueen() {
        Queen queen = Queen.createBlackPiece();
        queen.setPosition(new Position("e6"));
        List possibleMoves = queen.getPossibleMoves();
        // North
        assertContains(possibleMoves, "e7", "e8", "e5", "e4", "e3", "e2", "e1");
        // North East
        assertContains(possibleMoves, "f7", "g8");
        // South West
        assertContains(possibleMoves, "d5","c4");
    }

}