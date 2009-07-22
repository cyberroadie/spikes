package net.transformatorhuis.chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.transformatorhuis.chess.pieces.Pawn;
import net.transformatorhuis.chess.pieces.Piece;


public class Game {

    private Board board;
    private List blackStrengthList = new ArrayList();
    private List whiteStrengthList = new ArrayList();

    public Game() {
        board = new Board();
        board.initialize();
    }

    public Game(Board board) {
        this.board = board;
    }

    public float getBlackStrength() {
        float overalStrength = 0;
        blackStrengthList = new ArrayList();
        for (int rank = 0; rank < 8; rank++) {
            List<Piece> file = board.getBoardFileList(rank);
            for (Piece piece : file) {
                if(piece != null) {
                    if(piece.isBlack()) {
                        float strength =  getStrengthOfType(piece, file);
                        overalStrength = overalStrength + strength;
//                        piece.setStrength(strength);
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
        for (int rank = 0; rank < 8; rank++) {
            List<Piece> file = board.getBoardFileList(rank);
            for (Piece piece : file) {
                if(piece != null) {
                    if(piece.isWhite()) {
                        float strength =  getStrengthOfType(piece, file);
                        overalStrength = overalStrength + strength;
//                        piece.setStrength(strength);
                        whiteStrengthList.add(piece);
                    }

                }
            }
        }
        Collections.sort(whiteStrengthList);
        return overalStrength;
    }
    
    private float getStrengthOfType(Piece piece, Collection file) {
        if(piece instanceof Pawn  && Collections.frequency(file, piece) > 1)
            return piece.getStrength() / 2;
        return piece.getStrength();
    }

    public List getBlackStrengthList() {
        return blackStrengthList;
    }

    public List getWhiteStrengthList() {
        return whiteStrengthList;
    }
}