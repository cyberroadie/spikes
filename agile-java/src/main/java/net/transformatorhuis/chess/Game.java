package net.transformatorhuis.chess;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.transformatorhuis.chess.pieces.Bishop;
import net.transformatorhuis.chess.pieces.King;
import net.transformatorhuis.chess.pieces.Knight;
import net.transformatorhuis.chess.pieces.Pawn;
import net.transformatorhuis.chess.pieces.Piece;
import net.transformatorhuis.chess.pieces.Queen;
import net.transformatorhuis.chess.pieces.Rook;


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

    public Game(File saveGame) throws FileNotFoundException, IOException, ClassNotFoundException {
        board = loadBoard(saveGame);
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

    public void saveBoard(File saveFile) throws FileNotFoundException, IOException {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(saveFile));
            output.writeObject(this.board);
        } finally {
            output.close();
        }
    }

    public void saveAsciiBoard(File saveFile) throws FileNotFoundException, IOException {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(saveFile);
            output.write(board.print().getBytes());
        } finally {
            output.close();
        }
    }

    public Board loadBoard(File saveFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream(saveFile));
            board = (Board) input.readObject();
        } finally {
            input.close();
        }
        return board;
    }
    
    public Board loadAsciiBoard(File saveFile) throws IOException {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(saveFile));
            String line = null;
            int row = 8;
            while((line = input.readLine()) != null) {
                char[] pieces = line.toCharArray();
                for (int i = 1; i <= pieces.length; i++) {
                    StringBuilder stringPosition = new StringBuilder();
                    char c = pieces[i - 1];
                    Piece piece = createPieceBasedOnChar(c);
                    stringPosition.append(((char) (i + 96)));
                    stringPosition.append(row);
                    System.out.println("Position: " + stringPosition.toString());
                    board.putPiece(piece, new Position(stringPosition.toString()));
                }
                row--;
            }

        } finally {
            input.close();
        }
        return board;
    }

    private Piece createPieceBasedOnChar(char charPiece) {
        if(charPiece == 'k') {
            return King.createWhitePiece();
        } else if (charPiece == 'K') {
            return King.createBlackPiece();
        } else if (charPiece == 'b') {
            return Bishop.createWhitePiece();
        } else if (charPiece == 'B') {
            return Bishop.createBlackPiece();
        } else if (charPiece == 'n') {
            return Knight.createWhitePiece();
        } else if (charPiece == 'N') {
            return Knight.createBlackPiece();
        } else if (charPiece == 'p') {
            return Pawn.createWhitePiece();
        } else if (charPiece == 'P') {
            return Pawn.createBlackPiece();
        } else if (charPiece == 'q') {
            return Queen.createWhitePiece();
        } else if (charPiece == 'Q') {
            return Queen.createBlackPiece();
        } else if (charPiece == 'r') {
            return Rook.createWhitePiece();
        } else if (charPiece == 'R') {
            return Rook.createBlackPiece();
        }
        return null;
    }

    public Board getBoard() {
        return board;
    }

}