/**
*		@Name:		Peter Tso
*		@Email:		tsopeter@ku.edu
*		@Brief:
*							Interface file to forcing functionality of
*							derived classes
*	 @Date_Created: 09-08-2020
*/
public interface BoardInterface {

	/**
	* @pre:     must have called constructor
	* @post:    creates the board with the size x and y
	* @param:   x and y of the size of internal boards, and default marker
	*/
	void create(int x, int y, char board_marker);

	/**
  * @pre: must have made board
  * @post:  adds a character to a arbitrary location on board
  */
	void addElement(char marker, int x, int y);

	/**
  * @pre:  must have made Board
  * @post:  returns a character of an arbitrary location on board
  * @return: char
  */
	char getElement(int x, int y);

	/**
	* @pre: must have made board
	* @post:  returns a Board Object
	* @return: board
	*/
	Board getCopyBoard();
}
