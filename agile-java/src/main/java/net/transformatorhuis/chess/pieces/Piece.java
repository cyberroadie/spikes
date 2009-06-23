package net.transformatorhuis.chess.pieces;

/**
 * @author Olivier Van Acker
 *         Date: 20-Jun-2009
 */
public class Piece {

    private Piece.Color color;
    private Piece.Type type;
    private char representation;

    private String printableCharacter;

    private enum Color { WHITE, BLACK };
    public enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING };

    public static final char PAWN_REPRESENTATION = 'p';
    public static final char ROOK_REPRESENTATION = 'r';
    public static final char KNIGHT_REPRESENTATION = 'k';
    public static final char BISHOP_REPRESENTATION = 'b';
    public static final char QUEEN_REPRESENTATION = 'q';
    public static final char KING_REPRESENTATION = 'k';

    private Piece(Piece.Type name, Piece.Color color, char representation) {
        this.color = color;
        this.type = name;
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
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
            case PAWN : return new Piece(type, Color.WHITE, Piece.PAWN_REPRESENTATION);
            case BISHOP : return new Piece(type, Color.WHITE, Piece.BISHOP_REPRESENTATION);
            case KING : return new Piece(type, Color.WHITE, Piece.KING_REPRESENTATION);
            case KNIGHT : return new Piece(type, Color.WHITE, Piece.KNIGHT_REPRESENTATION);
            case QUEEN : return new Piece(type, Color.WHITE, Piece.QUEEN_REPRESENTATION);
            case ROOK : return new Piece(type, Color.WHITE, Piece.ROOK_REPRESENTATION);
        }
        return null;
    }

    public static Piece createBlackPiece(Piece.Type type) {
        switch(type) {
            case PAWN : return new Piece(type, Color.BLACK, Character.toUpperCase(Piece.PAWN_REPRESENTATION));
            case BISHOP : return new Piece(type, Color.BLACK, Character.toUpperCase(Piece.BISHOP_REPRESENTATION));
            case KING : return new Piece(type, Color.BLACK, Character.toUpperCase(Piece.KING_REPRESENTATION));
            case KNIGHT : return new Piece(type, Color.BLACK, Character.toUpperCase(Piece.KNIGHT_REPRESENTATION));
            case QUEEN : return new Piece(type, Color.BLACK, Character.toUpperCase(Piece.QUEEN_REPRESENTATION));
            case ROOK : return new Piece(type, Color.BLACK, Character.toUpperCase(Piece.ROOK_REPRESENTATION));
        }
        return null;
    }

}
