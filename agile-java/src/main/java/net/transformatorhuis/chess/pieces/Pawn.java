package net.transformatorhuis.chess.pieces;

import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Pawn extends Piece {

    public static final char REPRESENTATION = 'p';
    
    public Pawn(Color color) {
        super(color);
    }

    public static Pawn createWhitePiece() {
        return new Pawn(Color.WHITE);
    }

    public static Pawn createBlackPiece() {
        return new Pawn(Color.BLACK);
    }

    @Override
    public List getPossibleMoves() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float getStrength() {
        return 1f;
    }

    @Override
    public char getPresentation() {
        if(getColor() == Color.BLACK)
            return Character.toUpperCase(REPRESENTATION);
        return REPRESENTATION;
    }

}
