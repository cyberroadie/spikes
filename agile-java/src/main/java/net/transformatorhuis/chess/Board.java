package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.Piece;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static net.transformatorhuis.chess.pieces.Piece.Type.*;

/**
 *
 * @author cyberroadie
 */
public class Board {
    
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
                    rankString.append(piece.getPresentation());
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

    public Piece getPiece(Position position) {
        Piece piece = (Piece) board.get(position.getFile()).get(position.getRank());
        return piece;

    }

    public void setPiece(Piece piece, Position position) {
        if(board.get(position.getFile()).get(position.getRank()) == null)
            noOfPieces++;
        board.get(position.getFile()).set(position.getRank(), piece);
        
    }

    public void movePiece(Position from, Position to) {
        if(getPiece(from).getType() == KING)
            ;
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
        if(Piece.Type.PAWN == piece.getType() && Collections.frequency(file, piece) > 1)
            return piece.getType().getStrength() / 2;
        return piece.getType().getStrength();
    }

    public List getBlackStrengthList() {
        return blackStrengthList;
    }

    public List getWhiteStrengthList() {
        return whiteStrengthList;
    }

    public List getPossibleMoves(Position position) {
        Piece piece = getPiece(position);
        List<Position> moveList = new ArrayList();
        if(piece.getType() == KING) {
                moveList.add(getNorth(position));
                moveList.add(getSouth(position));
                moveList.add(getEast(position));
                moveList.add(getWest(position));
                moveList.add(getNorthWest(position));
                moveList.add(getSouthEast(position));
                moveList.add(getNorthEast(position));
                moveList.add(getSouthWest(position));
                moveList.removeAll(Collections.singleton(null));
        }
        return moveList;
    }

    private Position getNorth(Position position) {
        if(position.getRank() == 0 || position == null)
            return null;
        Position newPosition = new Position();
        newPosition.setFile(position.getFile());
        newPosition.setRank(position.getRank() - 1);
        return newPosition;
    }

    private Position getSouth(Position position) {
        if(position.getRank() == 7 || position == null)
            return null;
        Position newPosition = new Position();
        newPosition.setFile(position.getFile());
        newPosition.setRank(position.getRank() + 1);
        return newPosition;
    }

    private Position getEast(Position position) {
        if(position.getFile() == 7 || position == null)
            return null;
        Position newPosition = new Position();
        newPosition.setFile(position.getFile() + 1);
        newPosition.setRank(position.getRank());
        return newPosition;
    }

    private Position getWest(Position position) {
        if(position.getFile() == 0 || position == null)
            return null;
        Position newPosition = new Position();
        newPosition.setFile(position.getFile() - 1);
        newPosition.setRank(position.getRank());
        return newPosition;
    }

    private Position getSouthWest(Position position) {
        return getSouth(getWest(position));
    }

    private Position getSouthEast(Position position) {
        return getSouth(getEast(position));
    }

    private Position getNorthEast(Position position) {
        return getNorth(getEast(position));
    }

    private Position getNorthWest(Position position) {
        return getNorth(getWest(position));
    }

}
