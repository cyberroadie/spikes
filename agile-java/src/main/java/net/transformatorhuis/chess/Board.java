package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.Piece;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author cyberroadie
 */
class Board {
    
    private int noOfPieces = 0;
    private List<List> board = new ArrayList<List>();
    private List blackStrengthList = new ArrayList();
    private List whiteStrengthList = new ArrayList();

    public Board() {
        this.initialize();
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            board.add(i, createEmptyRow());
        }
    }

    public int getNoOfPieces() {
        return noOfPieces;
    }

    public String print() {
        StringBuilder boardString = new StringBuilder();
        for (int file = 0; file < 8; file++) {
            StringBuilder rankString = new StringBuilder();
            for (int rank = 0; rank < 8; rank++) {
                Piece piece = (Piece) board.get(rank).get(file);
                if (piece == null) {
                    rankString.append('.');
                } else {
                    rankString.append(piece.getRepresentation());
                }
            }
            boardString.append(rankString.toString() + StringUtil.NEWLINE);
        }
        return boardString.toString();
    }

    private List<Piece> createEmptyRow() {
        List<Piece> emptyList = new ArrayList<Piece>();
        for (int i = 0; i < 8; i++) {
            emptyList.add(null);
        }
        return emptyList;
    }

    public int getNoOfBlackPieces(Piece.Type type) {
        int noOfBlackPieces = 0;
        for (List<Piece> rank : board) {
            for (Piece piece : rank) {
                if((piece != null) && (piece.getType() == type) && piece.isBlack()) {
                    noOfBlackPieces++;
                }
            }
        }
        return noOfBlackPieces;
    }

    public int getNoOfWhitePieces(Piece.Type type) {
        int noOfBlackPieces = 0;
        for (List<Piece> rank : board) {
            for (Piece piece : rank) {
                if((piece != null) && (piece.getType() == type) && piece.isWhite()) {
                    noOfBlackPieces++;
                }
            }
        }
        return noOfBlackPieces;
    }

    public Piece getPiece(String location) {
        // Conversion to column
        int file = Character.getNumericValue(location.charAt(0)) - 10;
        int rank = Math.abs(Integer.parseInt(location.substring(1)) - 1 - 7);

        Piece piece = (Piece) board.get(file).get(rank);
        return piece;

    }

    public void setPiece(Piece piece, String location) {
        // Conversion to column
        int file = Character.getNumericValue(location.charAt(0)) - 10;
        int rank = Math.abs(Integer.parseInt(location.substring(1)) - 1 - 7);

        if(board.get(file).get(rank) == null)
            noOfPieces++;
        board.get(file).set(rank, piece);
        
    }

    private List getRank(int index) {
        return board.get(index);
    }

    public float getBlackStrength() {
        float overalStrength = 0;
        blackStrengthList = new ArrayList();
        for (List<Piece> file : board) {
            for (Piece piece : file) {
                if(piece != null) {
                    if(piece.isBlack()) {
                        float strength =  getStrengthOfType(piece, file);
                        overalStrength = overalStrength + strength;
                        piece.setStrength(strength);
                        blackStrengthList.add(piece);
                    }
                }
            }
        }
        Collections.sort(blackStrengthList);
        return overalStrength;
    }

    public float getWhiteStrength() {
        float overalStrength = 0;
        whiteStrengthList = new ArrayList();
        for (List<Piece> file : board) {
            for (Piece piece : file) {
                if(piece != null) {
                    if(piece.isWhite()) {
                        float strength =  getStrengthOfType(piece, file);
                        overalStrength = overalStrength + strength;
                        piece.setStrength(strength);
                        whiteStrengthList.add(piece);
                    }
                        
                }
            }
        }
        Collections.sort(whiteStrengthList);
        return overalStrength;
    }

    private float getStrengthOfType(Piece piece, Collection file) {
        switch(piece.getType()) {
            case PAWN :
                if(Collections.frequency(file, piece) > 1)
                    return 0.5f;
                else
                    return 1f;
            case BISHOP: return 3;
            case KNIGHT: return 2.5f;
            case QUEEN: return 9;
            case ROOK: return 5;
        }
        return 0;
    }

    public List getBlackStrengthList() {
        return blackStrengthList;
    }

    public List getWhiteStrengthList() {
        return whiteStrengthList;
    }


}
