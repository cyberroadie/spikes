package net.transformatorhuis.chess.pieces;

import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Bishop extends Piece {

    public static final char REPRESENTATION = 'b';

    public Bishop(Color color) {
        super(color);
    }

    public static Bishop createWhitePiece() {
        return new Bishop(Color.WHITE);
    }

    public static Bishop createBlackPiece() {
        return new Bishop(Color.BLACK);
    }

    @Override
    public List getPossibleMoves() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float getStrength() {
        return 3f;
    }

    @Override
    public char getPresentation() {
        if(getColor() == Color.BLACK)
            return Character.toUpperCase(REPRESENTATION);
        return REPRESENTATION;
    }

}
