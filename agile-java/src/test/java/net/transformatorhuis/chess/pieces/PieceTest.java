package net.transformatorhuis.chess.pieces;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Olivier Van Acker
 *         Date: 20-Jun-2009
 */
public class PieceTest {

    @Test
    public void testCreate() {
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.PAWN),
                Piece.createBlackPiece(Piece.Type.PAWN),
                Piece.Type.PAWN,
                Piece.PAWN_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.BISHOP),
                Piece.createBlackPiece(Piece.Type.BISHOP),
                Piece.Type.BISHOP,
                Piece.BISHOP_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.KING),
                Piece.createBlackPiece(Piece.Type.KING),
                Piece.Type.KING,
                Piece.KING_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.KNIGHT),
                Piece.createBlackPiece(Piece.Type.KNIGHT),
                Piece.Type.KNIGHT,
                Piece.KNIGHT_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.QUEEN),
                Piece.createBlackPiece(Piece.Type.QUEEN),
                Piece.Type.QUEEN,
                Piece.QUEEN_REPRESENTATION
                );
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.ROOK),
                Piece.createBlackPiece(Piece.Type.ROOK),
                Piece.Type.ROOK,
                Piece.ROOK_REPRESENTATION
                );
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece,
            Piece.Type type, char representation) {
            assertTrue(whitePiece.isWhite());
            assertEquals(type, whitePiece.getType());
            assertEquals(representation, whitePiece.getRepresentation());

            assertTrue(blackPiece.isBlack());
            assertEquals(type, blackPiece.getType());
            assertEquals(Character.toUpperCase(representation),
                    blackPiece.getRepresentation());
            
    }

}
