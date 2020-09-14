/**
* <h1> BoardPrinter </h1>
* <b> tsopeter@ku.edu </b>
*	<p>
*		This is the printer file. It handles printing to the screen
* </p>
*	<p> <b> Required Files: </b> </p>
* <ul>
*		<li> Board.java </li>
* </ul>
* <p> <b>
*		Thank you.
* </b> </p>
* <p>
* @author tsopeter
* @version 20200913
*	@since					09-05-2020
*	@since					09-08-2020
* @since					09-13-2020
* </p>
* <p> <b> References: </b> </p>
* <ul>
* <li> https://www.tutorialspoint.com/java/java_documentation.html </li>
* <li> https://docs.oracle.com/javase/8/docs/technotes/tools/winodws/javadoc.html </li>
* </ul>
*/
public class BoardPrinter{
	/**
	* This static method prints the board normally
	* <p> <b> Preconditions: </b> </p>
	* <p>
	*	Must have valid Board Object
	* </p>
	* <p> <b> Postconditions: </b> </p>
	* <p>
	* Outputs the board to the console
	* </p>
	*	@param g Board
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
	*	This static method prints the board without a given character
	* <p> <b> Preconditions: </b> </p>
	* <p>
	*	Must have valid Board Object and remove_character
	* </p>
	* <p> <b> Postconditions: </b> </p>
	* <p>
	* Outputs the board to the console
	* </p>
	* @param g Board
	* @param remove_marker char
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
