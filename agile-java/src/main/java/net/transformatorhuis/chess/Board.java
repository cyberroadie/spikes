package net.transformatorhuis.chess;

import net.transformatorhuis.chess.pieces.Pawn;
import java.util.ArrayList;

/**
 *
 * @author cyberroadie
 */
class Board {

    private ArrayList<Pawn> pieces = new ArrayList<Pawn>();

    public Board() {

    }

    public int getNoOfPieces() {
        return pieces.size();
    }

    public ArrayList<Pawn> getPieces() {
        return pieces;
    }

    void addPawn(Pawn pawn) {
        pieces.add(pawn);
    }
    
}
