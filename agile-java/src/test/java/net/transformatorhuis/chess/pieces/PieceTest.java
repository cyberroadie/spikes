package net.transformatorhuis.chess.pieces;

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
            assertEquals(representation, whitePiece.getRepresentation());

            assertTrue(blackPiece.isBlack());
            assertEquals(type, blackPiece.getType());
            assertEquals(Character.toUpperCase(representation),
                    blackPiece.getRepresentation());
            
    }

}
