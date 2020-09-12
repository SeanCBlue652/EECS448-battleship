/**
*	@Name:	Peter Tso
*	@KUID:	2936825
*	@Email: tsopeter@ku.edu
*	@Brief:
*		The Board.java file handles the char[][] map object.
*		It allows to fill in the board with char board_marker
*		and allows to add to board, get from board, and get the
*		dimensions of the board.
*
*
*	@Note:
*		There are no protections from OutOfBounds. Please
*		implement protections on your own code when using
*		Board.java.
*
*
*		Use tsopeter/feature/BoardHandler to have the most
*		up-to-date version of Board.java
*
*		Thank you.
*
*	@Date_Created:					09-05-2020
*	@Date_Modified:					09-05-2020
*/
public class Board{
	private char[][] map;
	private int xSize;
	private int ySize;
	char board_marker;

	/**
	*	@pre:	constructor
	*	@post:	creates a Board object
	*	@param: int, int, char
	*/
	public Board(int x, int y, char t_board_marker){
		this.xSize = 0;
		this.ySize = 0;
		this.board_marker = '\0';

		this.xSize = x;
		this.ySize = y;

		this.board_marker = t_board_marker;

		this.map = new char[this.ySize][this.xSize];
		for(int i = 0; i < this.ySize; i++){
			for(int k = 0; k < this.xSize; k++){
				this.map[i][k] = this.board_marker;
			}
		}
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 pass this.map Object
	*	@return: char[][]
	*/
	public char[][] getBoard(){
		return this.map;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 pass a instance of char[][] Object
	*	@return: char[][]
	*/
	public char[][] getCopyMap(){
		char[][] copy = new char[this.ySize][this.xSize];
		for(int i = 0; i < this.ySize; i++){
			for(int k = 0; k < this.xSize; k++){
				copy[i][k] = this.map[i][k];
			}
		}
		return copy;
	}
	/**
	*	@pre:	must be constructed
	*	@post: pass copy Board Object that has the same value
	*	@return: Board
	*/
	public Board getCopyBoard(){
		Board copy = new Board(this.xSize, this.ySize, this.board_marker);
		for(int i = 0; i < this.ySize; i++){
			for(int k = 0; k < this.xSize; k++){
				copy.addMarker(this.map[i][k], k, i);
			}
		}
		return copy;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 returns the x-axis dimension
	*		 of board
	*	@return: int
	*/
	public int getXSize(){
		return this.xSize;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 returns the y-axis dimension
	*		 of board
	*	@return: int
	*/
	public int getYSize(){
		return this.ySize;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 adds char marker to char[y][x] map
	*	@return: NONE
	*/
	public void addMarker(char marker, int x, int y){
		this.map[y][x] = marker;
	}

	/**
	*	@pre:	 must been constructed
	*	@post:	 gets char marker from char[y][x] map
	*	@return: char
	*/
	public char getMarker(int x, int y){
		return this.map[y][x];
	}
}
