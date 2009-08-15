package net.transformatorhuis.chess;

import java.io.Serializable;

/**
 *
 * @author cyberroadie
 */
public class Position implements Comparable<Position>, Serializable {

    private static final long serialVersionUID = 8769527256155278896L;

    int file = 0;
    int rank = 0;
    String location = null;

    public Position() {
//        calculateLocation();
    }

    public Position(String location) {
        this.file = Character.getNumericValue(location.charAt(0)) - 10;
        this.rank = Math.abs(Integer.parseInt(location.substring(1)) - 1 - 7);
        calculateLocation();
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
        calculateLocation();
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
        calculateLocation();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private void calculateLocation() {
        char fileLocation = ((char) (file + 97));
        int rankLocation = Math.abs(rank - 1 - 7);
        StringBuilder bld = new StringBuilder("");
        bld.append(fileLocation);
        bld.append(rankLocation);
        setLocation(bld.toString());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Position)) {
            return false;
        }
        Position position = (Position) object;
        if (position.getFile() == this.file && position.getRank() == this.rank) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.file;
        hash = 73 * hash + this.rank;
        hash = 73 * hash + (this.location != null ? this.location.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return location;
    }

    @Override
    public int compareTo(Position position) {
        int comparint = getFile() - position.getFile();
        if (comparint == 0) {
            return position.getRank() - getRank();
        }
        return comparint;
    }
    
}
