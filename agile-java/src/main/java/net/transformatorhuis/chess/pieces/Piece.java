package net.transformatorhuis.chess.pieces;

import java.io.Serializable;
import java.util.List;
import net.transformatorhuis.chess.Position;

/**
 * @author Olivier Van Acker
 *         Date: 20-Jun-2009
 */
public abstract class Piece implements Comparable<Piece>, Serializable {

    private static final long serialVersionUID = 5861106917050229362L;

    private Piece.Color color;
    private Position position;

    @Override
    public int compareTo(Piece that) {
        return Float.valueOf(this.getStrength()).compareTo(that.getStrength());
    }

    protected enum Color {
        WHITE, BLACK
    };
    
    protected Piece(Color color) {
        this.color = color;
    }
    
    public boolean isWhite() {
        return (color == Color.WHITE ? true : false);
    }

    public boolean isBlack() {
        return (color == Color.BLACK ? true : false);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Piece)) {
            return false;
        }
        Piece piece = (Piece) object;
        if (piece.color == this.color &&
                piece.getClass()== this.getClass()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.color.hashCode();
        hash = 79 * hash + (this.position != null ? this.position.hashCode() : 0);
        return hash;
    }

    public abstract float getStrength();

    

    public Position goNorth(Position position) {
        if (position == null || position.getRank() == 0) {
            return null;
        }
        Position newPosition = new Position();
        newPosition.setFile(position.getFile());
        newPosition.setRank(position.getRank() - 1);
        return newPosition;
    }

    public Position goSouth(Position position) {
        if (position == null || position.getRank() == 7 ) {
            return null;
        }
        Position newPosition = new Position();
        newPosition.setFile(position.getFile());
        newPosition.setRank(position.getRank() + 1);
        return newPosition;
    }

    public Position goEast(Position position) {
        if (position == null || position.getFile() == 7) {
            return null;
        }
        Position newPosition = new Position();
        newPosition.setFile(position.getFile() + 1);
        newPosition.setRank(position.getRank());
        return newPosition;
    }

    public Position goWest(Position position) {
        if (position == null || position.getFile() == 0) {
            return null;
        }
        Position newPosition = new Position();
        newPosition.setFile(position.getFile() - 1);
        newPosition.setRank(position.getRank());
        return newPosition;
    }

    public Position goSouthWest(Position position) {
        return goSouth(goWest(position));
    }

    public Position goSouthEast(Position position) {
        return goSouth(goEast(position));
    }

    public Position goNorthEast(Position position) {
        return goNorth(goEast(position));
    }

    public Position goNorthWest(Position position) {
        return goNorth(goWest(position));
    }

    public abstract List getPossibleMoves();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public abstract char getPresentation();
    
}
