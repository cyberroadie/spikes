package net.transformatorhuis.chess.pieces;

import java.util.List;
import net.transformatorhuis.chess.Position;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class QueenTest {

    public QueenTest() {

    }

    @Test
    public void testGetPossibleMovesQueen() {
        Queen queen = Queen.createBlackPiece();
        queen.setPosition(new Position("e6"));
        List possibleMoves = queen.getPossibleMoves();
        // North
        assertTrue("Test e7", possibleMoves.contains(new Position("e7")));
        assertTrue("Test e8", possibleMoves.contains(new Position("e8")));
        assertTrue("Test e5", possibleMoves.contains(new Position("e5")));
        assertTrue("Test e4", possibleMoves.contains(new Position("e4")));
        assertTrue("Test e3", possibleMoves.contains(new Position("e3")));
        assertTrue("Test e2", possibleMoves.contains(new Position("e2")));
        assertTrue("Test e1", possibleMoves.contains(new Position("e1")));
        // North East
        assertTrue("Test f7", possibleMoves.contains(new Position("f7")));
        assertTrue("Test g8", possibleMoves.contains(new Position("g8")));
        // South West
        assertTrue("Test d5", possibleMoves.contains(new Position("d5")));
        assertTrue("Test c4", possibleMoves.contains(new Position("c4")));

    }

}