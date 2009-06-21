package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.Pawn;
import java.util.ArrayList;

/**
 *
 * @author cyberroadie
 */
class Board {

    private int noOfPieces = 0;
    private ArrayList<ArrayList> board = new ArrayList<ArrayList>();

    public Board() {
        this.initialize();
    }

    public void initialize() {
        board.add(0, createEmptyRow());
        board.add(1, createPawnRow(Pawn.BLACK, Pawn.BLACK_CHAR));
        board.add(2, createEmptyRow());
        board.add(3, createEmptyRow());
        board.add(4, createEmptyRow());
        board.add(5, createEmptyRow());
        board.add(6, createPawnRow(Pawn.WHITE, Pawn.WHITE_CHAR));
        board.add(7, createEmptyRow());
    }

    public int getNoOfPieces() {
        return noOfPieces;
    }

    public String print() {
        StringBuilder boardString = new StringBuilder();
        for (ArrayList<Pawn> rank : board) {
            StringBuilder rankString = new StringBuilder();
            for (int i = 0; i < rank.size(); i++) {
                if (rank.get(i) == null) {
                    rankString.append('.');
                } else {
                    rankString.append(rank.get(i).toString());
                }
            }
            boardString.append(rankString.toString() + "\n");
        }
        return boardString.toString();
    }

    private ArrayList<Pawn> createPawnRow(String color, String printChar) {
        ArrayList<Pawn> pawnList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            pawnList.add(new Pawn(color, printChar));
            noOfPieces++;
        }
        return pawnList;
    }

    private ArrayList<Pawn> createEmptyRow() {
        ArrayList<Pawn> emptyList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            emptyList.add(null);
        }
        return emptyList;
    }
}
