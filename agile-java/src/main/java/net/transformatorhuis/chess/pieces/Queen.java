package net.transformatorhuis.chess.pieces;

import java.util.ArrayList;
import java.util.List;
import net.transformatorhuis.chess.Position;

/**
 * @author cyberroadie
 */
public class Queen extends Piece {

    public static final char REPRESENTATION = 'q';

    protected Queen(Color color) {
        super(color);
    }

    public static Queen createWhitePiece() {
        return new Queen(Color.WHITE);
    }

    public static Queen createBlackPiece() {
        return new Queen(Color.BLACK);
    }

    @Override
    public List getPossibleMoves() {
        List<Position> moveList = new ArrayList();
        Position position = getPosition();

        Position newPosition = goNorth(position);
        if (newPosition != null) {
            moveList.add(newPosition);
            while ((newPosition = goNorth(newPosition)) != null) {
                moveList.add(newPosition);
            }
        }

        newPosition = goSouth(position);
        if (newPosition != null) {
            moveList.add(newPosition);
            while ((newPosition = goSouth(newPosition)) != null) {
                moveList.add(newPosition);
            }
        }

        newPosition = goEast(position);
        if (newPosition != null) {
            moveList.add(newPosition);
            while ((newPosition = goEast(newPosition)) != null) {
                moveList.add(newPosition);
            }
        }

        newPosition = goWest(position);
        if (newPosition != null) {
            moveList.add(newPosition);
            while ((newPosition = goWest(newPosition)) != null) {
                moveList.add(newPosition);
            }
        }

        newPosition = goNorthWest(position);
        if (newPosition != null) {
            moveList.add(newPosition);
            while ((newPosition = goNorthWest(newPosition)) != null) {
                moveList.add(newPosition);
            }
        }

        newPosition = goSouthEast(position);
        if (newPosition != null) {
            moveList.add(newPosition);
            while ((newPosition = goSouthEast(newPosition)) != null) {
                moveList.add(newPosition);
            }
        }

        newPosition = goNorthEast(position);
        if (newPosition != null) {
            moveList.add(newPosition);
            while ((newPosition = goNorthEast(newPosition)) != null) {
                moveList.add(newPosition);
            }
        }

        newPosition = goSouthWest(position);
        if (newPosition != null) {
            moveList.add(newPosition);
            while ((newPosition = goSouthWest(newPosition)) != null) {
                moveList.add(newPosition);
            }

        }
        return moveList;
    }

    @Override
    public float getStrength() {
        return 9f;
    }

    @Override
    public char getPresentation() {
        if(getColor() == Color.BLACK)
            return Character.toUpperCase(REPRESENTATION);
        return REPRESENTATION;
    }
    
}
