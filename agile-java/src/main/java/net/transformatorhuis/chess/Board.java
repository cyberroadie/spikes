package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Board {
    
    private int noOfPieces = 0;
    private List<List> boardFileList = new ArrayList<List>();

    public Board() {
        this.initialize();
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            boardFileList.add(i, createEmptyRow());
        }
    }

    public int getNoOfPieces() {
        return noOfPieces;
    }

    public List<List> getBoardFileList() {
        return boardFileList;
    }

    public String print() {
        StringBuilder boardString = new StringBuilder();
        for (int file = 0; file < 8; file++) {
            StringBuilder rankString = new StringBuilder();
            for (int rank = 0; rank < 8; rank++) {
                Piece piece = (Piece) boardFileList.get(rank).get(file);
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
        for (List<Piece> rank : boardFileList) {
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
        for (List<Piece> rank : boardFileList) {
            for (Piece piece : rank) {
                if((piece != null) && (piece.getType() == type) && piece.isWhite()) {
                    noOfBlackPieces++;
                }
            }
        }
        return noOfBlackPieces;
    }

    public Piece getPiece(Position position) {
        Piece piece = (Piece) boardFileList.get(position.getFile()).get(position.getRank());
        return piece;

    }

    public void putPiece(Piece piece, Position position) {
        if(boardFileList.get(position.getFile()).get(position.getRank()) == null)
            noOfPieces++;
        boardFileList.get(position.getFile()).set(position.getRank(), piece);
        
    }

}
