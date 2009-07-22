package net.transformatorhuis.chess;

import java.util.ArrayList;
import net.transformatorhuis.chess.pieces.Piece;
import java.util.List;

/**
 *
 * @author cyberroadie
 */
public class Board {

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
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                Piece piece = board[rank][file];
                if ((piece != null) && (piece.getClass() == type) && piece.isBlack()) {
                    noOfBlackPieces++;
                }

            }
        }
        return noOfBlackPieces;
    }

    public int getNoOfWhitePieces(Class type) {
        int noOfWhitePieces = 0;
        for (int rank = 0; rank <
                8; rank++) {
            for (int file = 0; file < 8; file++) {
                Piece piece = (Piece) board[rank][file];
                if ((piece != null) && (piece.getClass() == type) && piece.isWhite()) {
                    noOfWhitePieces++;
                }

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
}
