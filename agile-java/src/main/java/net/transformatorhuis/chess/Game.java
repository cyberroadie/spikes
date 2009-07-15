package net.transformatorhuis.chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
        for (List<Piece> file : board.getBoardFileList()) {
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
        for (List<Piece> file : board.getBoardFileList()) {
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
}