package net.transformatorhuis.chess.pieces;

/**
 * @author Olivier Van Acker
 *         Date: 20-Jun-2009
 */
public class Pawn {

    private String color;
    static final String WHITE = "white";
    static final String BLACK = "black";

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn() {
        this(Pawn.WHITE);
    }


    public String getColor() {
        return color;
    }
    
}
