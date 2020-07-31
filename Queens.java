import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Queens {
	static int[][] board;

	public static void main(String[] a) {
		Scanner s = new Scanner(System.in);
		int size;
		// get the board size
		while (true) {
			try {
				System.out.println("Size of board: ");
				size = s.nextInt();
				if (size < 4) {
					throw new Exception();
				}
				board = new int[size][size];
				break;
			} catch (Exception e) {
				System.out.println("Invalid");
			}
		}
		s.close();
		buildBoard(size, 0);
	}

	// put together the board. size is how big the board is.
	// column is current column a queen is beign placed at
	// board is initially all 0. If a queen gets placed, that spot is -1
	// then all spaces the queen can move to are incremented by 1.
	// if there's another column to add queens, make a recursive call.
	// Otherwise print the results.
	static void buildBoard(int size, int column) {
		if (column == size) {
			printBoard();
			return;
		}
		int i, j, k, l;
		for (i = 0; i < size; i++) {
			// found a safe spot
			if (board[i][column] == 0) {
				// mark all locations the queen can be
				for (j = 0; j < size; j++) {
					board[i][j]++;
					board[j][column]++;
				}
				// top left diagonal
				for (k = i, l = column;k >= 0 && l>= 0 ;k--,l--){
					board[k][l]++;
				}
				// bottom left diagonal
				for (k = i, l = column; k >= 0 && l < size; k--, l++) {
					board[k][l]++;
				}
				// top right diagonal
				for (k = i, l = column; k < size && l >= 0; k++, l--) {
					board[k][l]++;
				}
				// bottom right diagonal
				for (k = i, l = column; k < size && l < size; k++, l++) {
					board[k][l]++;
				}
				// set the queen
				board[i][column] = -1;
				// make a recursive call to the next column
				buildBoard(size, column + 1);
				// undo placement
				for (j = 0; j < size; j++) {
					board[i][j]--;
					board[j][column]--;
				}
				// top left diagonal
				for (k = i, l = column; k >= 0 && l >= 0; k--, l--) {
					board[k][l]--;
				}
				// bottom left diagonal
				for (k = i, l = column; k >= 0 && l < size; k--, l++) {
					board[k][l]--;
				}
				// top right diagonal
				for (k = i, l = column; k < size && l >= 0; k++, l--) {
					board[k][l]--;
				}
				// bottom right diagonal
				for (k = i, l = column; k < size && l < size; k++, l++) {
					board[k][l]--;
				}
				board[i][column] = 0;

			}
		}
	}

	static void printBoard() {
		int i, j;
		for (i = 0; i < board.length; i++) {
			for (j = 0; j < board.length; j++) {
				if (board[i][j] == -1) {
					System.out.print("Q ");
				} else {
					System.out.print("x ");
				}
			}
			System.out.println();
		}
		System.out.println();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}