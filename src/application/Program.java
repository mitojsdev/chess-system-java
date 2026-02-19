package application;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				chessMatch.performChessMove(source, target);
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				if (sc.hasNextLine()) {
					sc.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				if (sc.hasNextLine()) {
					sc.nextLine();
				}
			} catch (NoSuchElementException e) {
				System.out.println("Input stream was closed. Finishing application.");
				break;
			}
		}

		sc.close();
	}

}
