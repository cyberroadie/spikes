package net.transformatorhuis.chess;

/**
 *
 * @author cyberroadie
 */
public class Position {

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
        if(!(object instanceof Position))
            return false;
        Position position = (Position) object;
        if(position.getFile() == this.file && position.getRank() == this.rank)
            return true;
        return false;
    }

}
