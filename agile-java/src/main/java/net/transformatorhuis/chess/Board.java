package net.transformatorhuis.chess;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.transformatorhuis.chess.pieces.Piece;
import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Board implements Iterable<Piece>, Serializable {

    private static final long serialVersionUID = 8404060220437057028L;

    private int noOfPieces = 0;
    private Piece[][] board = new Piece[8][8];

    public Board() {
        this.initialize();
    }

    public void initialize() {
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                board[rank][file] = null;

            }
        }
    }

    public int getNoOfPieces() {
        return noOfPieces;
    }

    public List<Piece> getBoardFileList(int file) {
        List boardFileList = new ArrayList();
        for (int rank = 0; rank < 8; rank++) {
            Piece piece = board[rank][file];
            boardFileList.add(piece);

        }
        return boardFileList;
    }

    /**
     * Print an ASCII representation of the board
     * @return ASCII board
     */
    public String print() {
        StringBuilder boardString = new StringBuilder();
        for (int rank = 0; rank < 8; rank++) {
            StringBuilder rankString = new StringBuilder();
            for (int file = 0; file < 8; file++) {
                Piece piece = board[rank][file];
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

    public int getNoOfBlackPieces(Class type) {
        int noOfBlackPieces = 0;
        for (Piece piece : this) {
            if ((piece != null) && (piece.getClass() == type) && piece.isBlack()) {
                noOfBlackPieces++;
            }
        }
        return noOfBlackPieces;
    }

    public int getNoOfWhitePieces(Class type) {
        int noOfWhitePieces = 0;
        for (Piece piece : this) {
            if ((piece != null) && (piece.getClass() == type) && piece.isWhite()) {
                noOfWhitePieces++;
            }

        }
        return noOfWhitePieces;
    }

    public Piece getPiece(
            Position position) {
        Piece piece = (Piece) board[position.getRank()][position.getFile()];
        return piece;

    }

    public void putPiece(Piece piece, Position position) {
        if (board[position.getRank()][position.getFile()] == null) {
            noOfPieces++;
        }

        board[position.getRank()][position.getFile()] = piece;
    }

    @Override
    public Iterator<Piece> iterator() {
        List pieceList = new ArrayList();
        for (int rank = 0; rank <
                8; rank++) {
            for (int file = 0; file <
                    8; file++) {
                pieceList.add(board[rank][file]);
            }

        }
        pieceList.removeAll(Collections.singleton(null));
        return pieceList.iterator();
    }

    public void save(File backupFile) {

    }

    public void Load(File backupFile) {
        
    }

}
