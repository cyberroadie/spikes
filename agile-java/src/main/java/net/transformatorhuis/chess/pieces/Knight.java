package net.transformatorhuis.chess.pieces;

import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Knight extends Piece {

    public static final char REPRESENTATION = 'n';

    public Knight(Color color) {
        super(color);
    }

    public static Knight createWhitePiece() {
        return new Knight(Color.WHITE);
    }

    public static Knight createBlackPiece() {
        return new Knight(Color.BLACK);
    }

    @Override
    public List getPossibleMoves() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float getStrength() {
        return 2.5f;
    }

    @Override
    public char getPresentation() {
        if(getColor() == Color.BLACK)
            return Character.toUpperCase(REPRESENTATION);
        return REPRESENTATION;
    }

}
