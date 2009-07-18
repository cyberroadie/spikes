package net.transformatorhuis.chess.pieces;

import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Rook extends Piece {

    public static final char REPRESENTATION = 'r';

    public Rook(Color color) {
        super(color);
    }

    public static Rook createWhitePiece() {
        return new Rook(Color.WHITE);
    }

    public static Rook createBlackPiece() {
        return new Rook(Color.BLACK);
    }

    @Override
    public List getPossibleMoves() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float getStrength() {
        return 5;
    }

    @Override
    public char getPresentation() {
        if(getColor() == Color.BLACK)
            return Character.toUpperCase(REPRESENTATION);
        return REPRESENTATION;
    }
    
}
