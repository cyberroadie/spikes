package net.transformatorhuis.chess.pieces;

/**
 * @author Olivier Van Acker
 *         Date: 20-Jun-2009
 */
public class Piece implements Comparable<Piece> {

    private Piece.Color color;
    private Piece.Type type;
    private float strength;

    @Override
    public int compareTo(Piece that) {
        return Float.valueOf(this.getStrength()).compareTo(that.getStrength());
    }

    private enum Color { WHITE, BLACK };

    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'n';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';

    public enum Type {
        PAWN(1f, PAWN_REPRESENTATION),
        ROOK(5f, ROOK_REPRESENTATION),
        KNIGHT(2.5f, KNIGHT_REPRESENTATION),
        BISHOP(3f, BISHOP_REPRESENTATION),
        QUEEN(9f, QUEEN_REPRESENTATION),
        KING(0f, KING_REPRESENTATION);

        private float strength;
        private char presentation;

        private Type(float strength, char presentation) {
            this.strength = strength;
            this.presentation = presentation;
        }

        public float getStrength() {
            return strength;
        }

        public char getPresentation() {
            return presentation;
        }

    }

    private Piece(Piece.Type name, Piece.Color color) {
        this.color = color;
        this.type = name;
    }

    public Type getType() {
        return type;
    }

    public boolean isWhite() {
        return(color == Color.WHITE ? true : false);
    }

    public boolean isBlack() {
        return(color == Color.BLACK ? true : false);
    }

    public static Piece createWhitePiece(Type type) {
        switch(type) {
            case PAWN : return new Piece(type, Color.WHITE);
            case BISHOP : return new Piece(type, Color.WHITE);
            case KING : return new Piece(type, Color.WHITE);
            case KNIGHT : return new Piece(type, Color.WHITE);
            case QUEEN : return new Piece(type, Color.WHITE);
            case ROOK : return new Piece(type, Color.WHITE);
        }
        return null;
    }

    public static Piece createBlackPiece(Type type) {
        switch(type) {
            case PAWN : return new Piece(type, Color.BLACK);
            case BISHOP : return new Piece(type, Color.BLACK);
            case KING : return new Piece(type, Color.BLACK);
            case KNIGHT : return new Piece(type, Color.BLACK);
            case QUEEN : return new Piece(type, Color.BLACK);
            case ROOK : return new Piece(type, Color.BLACK);
        }
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Piece))
            return false;
        Piece piece = (Piece) object;
        if(piece.color == this.color &&
                piece.type == this.type)
            return true;
        return false;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }

    public char getPresentation() {
        if(this.color == Color.WHITE)
            return this.type.getPresentation();
        return Character.toUpperCase(this.type.getPresentation());
    }

}
