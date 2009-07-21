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
public class KingTest extends PieceTest {

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
       assertContains(possibleMoves, "a8", "c8", "a7", "b7", "c7");
    }

}