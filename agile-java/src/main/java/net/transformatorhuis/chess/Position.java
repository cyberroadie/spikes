package net.transformatorhuis.chess;

/**
 *
 * @author cyberroadie
 */
public class Position {

    int file;
    int rank;

    public Position(String location) {
        file = Character.getNumericValue(location.charAt(0)) - 10;
        rank = Math.abs(Integer.parseInt(location.substring(1)) - 1 - 7);
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

}
