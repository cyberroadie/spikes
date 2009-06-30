package net.transformatorhuis.chess;

/**
 *
 * @author cyberroadie
 */
public class Position {

    int file;
    int rank;
    String location;

    public Position() {
    }

    public Position(String location) {
        this.file = Character.getNumericValue(location.charAt(0)) - 10;
        this.rank = Math.abs(Integer.parseInt(location.substring(1)) - 1 - 7);
        this.location = location;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Position))
            return false;
        Position position = (Position) object;
        if(position.getFile() == this.file && position.getRank() == this.rank)
            return true;
        return false;
    }

}
