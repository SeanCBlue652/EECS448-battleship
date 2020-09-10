/**
*  @Name:  Peter Tso
*  @Email:  tsopeter@ku.edu
*  @Brief:
*            This handles the multiplexing the boards.
*
*  Update:
*            This class no longer supports multiplexing of the boards,
*            in accordance to the specifications and requriements.
*            It also no longer is implemeted from BoardInterface class.
*            The file has been renamed to BoardPrinterWrapper.
*
*            @Date_Updated: 09-10-2020
*  @Note:
*             This class requires the following files:
*             --Board.java
*  @Date_Created: 09-08-2020
*  @Date_Modified: 09-10-2020
*
*/
public class BoardPrinterWrapper{
  private int xOffset;
  private int yOffset;
  private int indexOffset;

  private char ship_marker;
  private char board_marker;
  private boolean indexed;

  private Board g;
  private Board ui;

  /**
  * @pre:   constructor
  * @post:  implements the Board for the main board
  * @param: must have offset and index offset
  * @return:None
  */
  public BoardPrinterWrapper(Board t_g, char t_ship_marker, char t_board_marker, boolean t_indexed){
    this.xOffset = 1;
    this.yOffset = 1;
    this.indexOffset = 1;
    this.ship_marker = t_ship_marker;
    this.board_marker = t_board_marker;
    this.indexed = t_indexed;

    this.g = t_g;
    this.ui = new Board(g.getXSize() + this.indexOffset + 2 * this.xOffset, g.getYSize() + 2 * this.indexOffset + this.yOffset, this.board_marker);

  }

  /**
  * @pre:     must have constructed
  * @post:    adds board to a board that has all the necessary elements
  */
  private void addBoard(){
      int xInput = 0;
      int yInput = 0;

      char x_ui = '0';
      char y_ui = 'A';

      xInput = this.xOffset + (0 * (this.xOffset + g.getXSize())) + (0+1) * this.indexOffset;
      yInput = this.yOffset + (0 * (this.yOffset + g.getYSize())) + (0+1) * this.indexOffset;
      for(int i = -1; i < g.getYSize(); i++){
        for(int k = -1; k < g.getXSize(); k++){
          if(i == -1 && indexed){
            ui.addMarker(x_ui, k + xInput, i + yInput);
            x_ui ++;
          }
          else if(k == -1 && indexed){
            ui.addMarker(y_ui, k + xInput, i + yInput);
            y_ui++;
          }
        }
      }

      xInput = this.xOffset + (0 * (this.xOffset + g.getXSize())) + (0+1) * this.indexOffset;
      yInput = this.yOffset + (0 * (this.yOffset + g.getYSize())) + (0+1) * this.indexOffset;
      for(int i = 0; i < g.getYSize(); i++){
        for(int k = 0; k < g.getXSize(); k++){
            ui.addMarker(g.getMarker(k, i), xInput + k, yInput + i);
        }
      }
  }


  /**
  * @pre: must have called create
  * @post:  adds a character to a arbitrary location on board
  */
  public void addElement(char marker, int x, int y){
    this.ui.addMarker(marker, x, y);
  }

  /**
  * @pre:  must have called create
  * @post:  returns a character of an arbitrary location on board
  * @return: char
  */
  public char getElement(int x, int y){
    return this.ui.getMarker(x, y);
  }

  /**
  * @pre: must have called constructor
  * @post:  returns the main Board Object
  * @return: board
  */
  public Board getCopyBoard(){
    Board copy = new Board(ui.getXSize(), ui.getYSize(), this.board_marker);
    for(int i = 0; i < ui.getYSize(); i++){
      for(int k = 0; k < ui.getXSize(); k++){
        copy.addMarker(ui.getMarker(k, i), k, i);
      }
    }
    return copy;
  }

  /**
  *
  */
  public void print(boolean t_hidden){
    this.addBoard();
    if(t_hidden){
      BoardPrinter.printAndRemove(this.ui.getCopyBoard(), this.ship_marker);
    }
    else{
      BoardPrinter.printBoard(this.ui.getCopyBoard());
    }
  }

}
