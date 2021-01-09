/**
 * Implements board and aux functions for tic-tac-toe game
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 1
 *
 */
public class Evaluate {
	// initial variables
	private int boardRows, boardColumns, tilesNeeded, maxLevels;
	private char[][] gameBoard;

	/**
	 * constructor for Evaluate class
	 * 
	 * @param boardRows
	 * @param boardColumns
	 * @param tilesNeeded
	 * @param maxLevels
	 */
	public Evaluate(int boardRows, int boardColumns, int tilesNeeded, int maxLevels) {
		this.boardColumns = boardColumns;
		this.boardRows = boardRows;
		gameBoard = new char[boardRows][boardColumns]; // create new board
		for (int i = 0; i < boardRows; i++) { // for each slot in board
			for (int j = 0; j < boardColumns; j++)
				gameBoard[i][j] = 'g'; // fill with valid (empty) tiles
		}
		this.tilesNeeded = tilesNeeded;
		this.maxLevels = maxLevels;
	}

	/**
	 * method Dictionary
	 * 
	 * @return dict
	 * 
	 *         dictionary that was just created
	 */
	public Dictionary createDictionary() {
		Dictionary dict = new Dictionary(34157);
		return dict;
	}

	/**
	 * method toString
	 * 
	 * @param board
	 * 
	 *              game board to convert to string
	 * @return stringBoard
	 * 
	 *         converted board string
	 */
	private String toString(char[][] board) {
		String stringBoard = "";
		for (int i = 0; i < boardRows; i++) {
			for (int j = 0; j < boardColumns; j++) // for each slot in board
				stringBoard = stringBoard + board[i][j]; // convert slots to strings
		}
		return stringBoard;
	}

	/**
	 * method repeatedConfig
	 * 
	 * @param dict
	 * @return true if game board already exists in Dictionary
	 */
	public Data repeatedConfig(Dictionary dict) {
		return dict.get(toString(gameBoard));
	}

	/**
	 * method insertConfig
	 * 
	 * inserts new game board into Dictionary
	 * 
	 * @param dict
	 * @param score
	 * @param level
	 */
	public void insertConfig(Dictionary dict, int score, int level) {
		dict.put(new Data(toString(gameBoard), score, level));
	}

	/**
	 * method storePlay
	 * 
	 * @param row
	 * @param col
	 * @param symbol
	 * 
	 *               symbol to be stored in board
	 */
	public void storePlay(int row, int col, char symbol) {
		gameBoard[row][col] = symbol;
	}

	/**
	 * method squareIsEmpty
	 * 
	 * @param row
	 * @param col
	 * @return true if empty
	 */
	public boolean squareIsEmpty(int row, int col) {
		return (gameBoard[row][col] == 'g');
	}

	/**
	 * method tileOfComputer
	 * 
	 * @param row
	 * @param col
	 * @return true if computer tile else false
	 */
	public boolean tileOfComputer(int row, int col) {
		return (gameBoard[row][col] == 'o');
	}

	/**
	 * method tileOfHuman
	 * 
	 * @param row
	 * @param col
	 * @return true if human tile else false
	 */
	public boolean tileOfHuman(int row, int col) {
		return (gameBoard[row][col] == 'b');
	}

	/**
	 * method wins
	 * 
	 * @param symbol
	 * @return true if won by either human or computer depending on specified symbol
	 */
	public boolean wins(char symbol) {
		int horiTally, vertTally, diagRightTally, diagLeftTally;
		for (int i = 0; i < boardRows; i++) {
			for (int j = 0; j < boardColumns; j++) {
				if (gameBoard[i][j] == symbol) { // for each slot in board
					horiTally = 0;
					vertTally = 0;
					diagRightTally = 0;
					diagLeftTally = 0;
					// scan horizontal
					for (int hori = i; hori < boardRows; hori++) {
						if (gameBoard[hori][j] == symbol)
							horiTally++;
						else
							break;
						if (horiTally == tilesNeeded) // if winning condition
							return true; // register a win
					}
					// scan vertical
					for (int vert = j; vert < boardColumns; vert++) {
						if (gameBoard[i][vert] == symbol)
							vertTally++;
						else
							break;
						if (vertTally == tilesNeeded) // if winning condition
							return true; // register a win
					}
					// scan top-left to bottom-right
					for (int diag = 0; diag < tilesNeeded; diag++) {
						if ((i + diag >= boardRows) || (j + diag >= boardColumns))
							break;
						if (gameBoard[i + diag][j + diag] == symbol)
							diagRightTally++;
						else
							break;
						if (diagRightTally == tilesNeeded) // if winning condition
							return true; // register a win
					}
					// scan top right to bottom left
					for (int diag1 = 0; diag1 < tilesNeeded; diag1++) {
						if ((i - diag1 < 0) || (j + diag1 >= boardColumns))
							break;
						if (gameBoard[i - diag1][j + diag1] == symbol)
							diagLeftTally++;
						else
							break;
						if (diagLeftTally == tilesNeeded) // if winning condition
							return true; // register a win
					}
				}
			}
		}
		return false;
	}

	/**
	 * method isDraw
	 * 
	 * @return true if game is a draw else false
	 */
	public boolean isDraw() {
		for (int i = 0; i < boardRows; i++) {
			for (int j = 0; j < boardColumns; j++) {
				if (squareIsEmpty(i, j)) // if there are still empty tiles
					return false; // game is ongoing
			}
		}
		return true; // else game is a draw
	}

	/**
	 * method evalBoard
	 * 
	 * @return returns current condition of the game
	 */
	public int evalBoard() {
		if (wins('o')) // return 3 if computer wins
			return 3;
		else if (wins('b')) // return 0 if human wins
			return 0;
		else if (isDraw()) // return 2 if draw
			return 2;
		else // return 1 if game is unfinished
			return 1;
	}
}
