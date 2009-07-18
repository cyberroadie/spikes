package net.transformatorhuis.chess.pieces;

import java.util.List;
import net.transformatorhuis.chess.Position;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cyberroadie
 */
public class KingTest {

    public KingTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getPossibleMoves method, of class King.
     */
    @Test
    public void testGetPossibleMovesKing() {
       King king = King.createBlackPiece();
       king.setPosition(new Position("b8"));
       List possibleMoves = king.getPossibleMoves();
       assertTrue("Test a8", possibleMoves.contains(new Position("a8")));
       assertTrue("Test c8", possibleMoves.contains(new Position("c8")));
       assertTrue("Test a7", possibleMoves.contains(new Position("a7")));
       assertTrue("Test b7", possibleMoves.contains(new Position("b7")));
       assertTrue("Test c7", possibleMoves.contains(new Position("c7")));
    }

}