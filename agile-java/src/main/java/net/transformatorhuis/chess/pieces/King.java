package net.transformatorhuis.chess.pieces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.transformatorhuis.chess.Position;

/**
 *
 * @author cyberroadie
 */
public class King extends Piece {

    public static final char REPRESENTATION = 'k';

    protected King(Color color) {
        super(color);
    }

    public static King createWhitePiece() {
        return new King(Color.WHITE);
    }

    public static King createBlackPiece() {
        return new King(Color.BLACK);
    }

    @Override
    public List getPossibleMoves() {
        List<Position> moveList = new ArrayList();
        Position position = getPosition();
        moveList.add(goNorth(position));
        moveList.add(goSouth(position));
        moveList.add(goEast(position));
        moveList.add(goWest(position));
        moveList.add(goNorthWest(position));
        moveList.add(goSouthEast(position));
        moveList.add(goNorthEast(position));
        moveList.add(goSouthWest(position));
        moveList.removeAll(Collections.singleton(null));
        return moveList;
    }

    @Override
    public float getStrength() {
        return 0f;
    }

    @Override
    public char getPresentation() {
        if(getColor() == Color.BLACK)
            return Character.toUpperCase(REPRESENTATION);
        return REPRESENTATION;
    }

}
