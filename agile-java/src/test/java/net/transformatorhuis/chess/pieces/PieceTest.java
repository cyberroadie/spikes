package net.transformatorhuis.chess.pieces;

import java.util.List;
import net.transformatorhuis.chess.Position;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public abstract class PieceTest {

        public void assertContains(List moves, String...expectedMoves) {
        for (String move : expectedMoves) {
            assertTrue(moves.contains(new Position(move)));
        }
    }

}
