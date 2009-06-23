package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyberroadie
 */
class Board {
    
    private int noOfPieces = 0;
    private List<List> board = new ArrayList<List>();

    public Board() {
        this.initialize();
    }

    public void initialize() {
        board.add(0, createEmptyRow());
        board.add(1, createWhitePawnRow());
        board.add(2, createEmptyRow());
        board.add(3, createEmptyRow());
        board.add(4, createEmptyRow());
        board.add(5, createEmptyRow());
        board.add(6, createBlackPawnRow());
        board.add(7, createEmptyRow());
    }

    public int getNoOfPieces() {
        return noOfPieces;
    }

    public String print() {
        StringBuilder boardString = new StringBuilder();
        for (List<Piece> rank : board) {
            StringBuilder rankString = new StringBuilder();
            for (int i = 0; i < rank.size(); i++) {
                if (rank.get(i) == null) {
                    rankString.append('.');
                } else {
                    rankString.append(rank.get(i).getRepresentation());
                }
            }
            boardString.append(rankString.toString() + StringUtil.NEWLINE);
        }
        return boardString.toString();
    }

    private List<Piece> createWhitePawnRow() {
        List<Piece> pawnList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            pawnList.add(Piece.createWhitePiece(Piece.Type.PAWN));
            noOfPieces++;
        }
        return pawnList;
    }

    private List<Piece> createBlackPawnRow() {
        List<Piece> pawnList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            pawnList.add(Piece.createBlackPiece(Piece.Type.PAWN));
            noOfPieces++;
        }
        return pawnList;
    }

    private List<Piece> createEmptyRow() {
        List<Piece> emptyList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            emptyList.add(null);
        }
        return emptyList;
    }
}
