package net.transformatorhuis.chess.pieces;

/**
 * @author Olivier Van Acker
 *         Date: 20-Jun-2009
 */
public class Pawn {

    private String color;
    private String printableCharacter;
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    public static final String BLACK_CHAR = "P";
    public static final String WHITE_CHAR = "p";

    public Pawn(String color, String printableChar) {
        this.color = color;
        this.printableCharacter = printableChar;
    }

    public Pawn() {
        this(Pawn.WHITE, Pawn.WHITE_CHAR);
    }


    public String getColor() {
        return color;
    }

    public String toString() {
        return printableCharacter;
    }

}
