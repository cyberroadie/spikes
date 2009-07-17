package net.transformatorhuis.chess.pieces;

import java.util.List;
import net.transformatorhuis.chess.Position;
import org.junit.Test;
import static org.junit.Assert.*;
import static net.transformatorhuis.chess.pieces.Piece.Type.*;

/**
 * @author Olivier Van Acker
 *         Date: 20-Jun-2009
 */
public class PieceTest {

    @Test
    public void testCreate() {
        verifyCreation(
                Piece.createWhitePiece(PAWN),
                Piece.createBlackPiece(PAWN),
                PAWN,
                Piece.PAWN_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(BISHOP),
                Piece.createBlackPiece(BISHOP),
                BISHOP,
                Piece.BISHOP_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(KING),
                Piece.createBlackPiece(KING),
                KING,
                Piece.KING_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(KNIGHT),
                Piece.createBlackPiece(KNIGHT),
                KNIGHT,
                Piece.KNIGHT_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(QUEEN),
                Piece.createBlackPiece(QUEEN),
                QUEEN,
                Piece.QUEEN_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(ROOK),
                Piece.createBlackPiece(ROOK),
                ROOK,
                Piece.ROOK_REPRESENTATION
                );
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece,
            Piece.Type type, char representation) {
            assertTrue(whitePiece.isWhite());
            assertEquals(type, whitePiece.getType());
            assertEquals(representation, whitePiece.getPresentation());

            assertTrue(blackPiece.isBlack());
            assertEquals(type, blackPiece.getType());
            assertEquals(Character.toUpperCase(representation),
                    blackPiece.getPresentation());
            
    }

    @Test
    public void testGetPossibleMovesKing() {
       Piece piece = Piece.createBlackPiece(KING);
       piece.setPosition(new Position("b8"));
       List possibleMoves = piece.getPossibleMoves();
       assertTrue("Test a8", possibleMoves.contains(new Position("a8")));
       assertTrue("Test c8", possibleMoves.contains(new Position("c8")));
       assertTrue("Test a7", possibleMoves.contains(new Position("a7")));
       assertTrue("Test b7", possibleMoves.contains(new Position("b7")));
       assertTrue("Test c7", possibleMoves.contains(new Position("c7")));
    }

    @Test
    public void testGetPossibleMovesQueen() {
        Piece piece = Piece.createBlackPiece(QUEEN);
        piece.setPosition(new Position("e6"));
        List possibleMoves = piece.getPossibleMoves();
        assertTrue("Test e7", possibleMoves.contains(new Position("e7")));
        assertTrue("Test e8", possibleMoves.contains(new Position("e8")));
        assertTrue("Test e5", possibleMoves.contains(new Position("e5")));
        assertTrue("Test e4", possibleMoves.contains(new Position("e4")));
        assertTrue("Test e3", possibleMoves.contains(new Position("e3")));
        assertTrue("Test e2", possibleMoves.contains(new Position("e2")));
        assertTrue("Test e1", possibleMoves.contains(new Position("e1")));
    }

}
