/**
*	@Name:	 Peter Tso
*	@KUID:	 2936825
*	@Email:  tsopeter@ku.edu
*	@Brief:
*		This is the printer file. It partially handles the UI of the game.
*	@Req'd:
*		The required files are below:
*		--Board.java.
*
*		Thank you.
*
*	@Date_Created:					09-05-2020
* @Date_Modified:					09-08-2020
*/
public class BoardPrinter{
	/**
	*	@pre:  must have valid Board
	*	@post: prints the board
	*/
	public static void printBoard(Board g){
		for(int i = 0; i < g.getYSize(); i++){
			for(int k = 0; k < g.getXSize(); k++){
				System.out.print(g.getMarker(k, i));
				System.out.print(' ');
			}
			System.out.print('\n');
		}
	}

	/**
	*	@pre:	must have valid Board
	* @post: prints the board without a given character
	*/
	public static void printAndRemove(Board g, char remove_marker){
		for(int i = 0; i < g.getYSize(); i++){
			for(int k = 0; k < g.getXSize(); k++){
				if(g.getMarker(k, i) == remove_marker){
					System.out.print(g.board_marker);
				}
				else{
					System.out.print(g.getMarker(k, i));
				}
				System.out.print(' ');
			}
			System.out.print('\n');
		}
	}

}
