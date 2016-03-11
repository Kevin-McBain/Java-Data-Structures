package queens;

/**
 * Solve the n queens problem
 * 
 * @author KWM
 * @version (a version number or a date)
 */
public class Game {
	public static final int SIZE = 6;

	public static void main(String args[]) {
		Game game = new Game();

		System.out.println("Solution is \n" + game.placeQueen(0, new Board()));
	}

	/**
	 * @return the new board if Queens can be placed on Board b in column col..
	 *          SIZE-1, or null if not possible
	 */
	private Board placeQueen(int col, Board b) {
		Position p;
		Board result;

		for (int row = 0; row < Game.SIZE; row++) {
			p = new Position(row, col);
			result = new Board(b); // copy constuctor
			result.addQueen(p);
			if (!result.check())
				if (col < SIZE - 1) {
					result = placeQueen(col + 1, result);
					if (result != null)
						return result;
				} else
					return result; // BASE CASE
		}
		return null;
	}

}
