package net.transformatorhuis.chess;

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
        assertEquals(16, board.getNoOfPieces());
        System.out.println(board.print());
        assertEquals(
                "........\n" +
                "pppppppp\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "PPPPPPPP\n" +
                "........\n",
                board.print()
                );
                
    }

}
