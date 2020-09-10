/**
*  @Name:  Peter Tso
*  @Email:  tsopeter@ku.edu
*  @Brief:
*            This handles the multiplexing the boards.
*  @Note:
*             This class requires the following files:
*             --Board.java
*             --BoardInterface.java
*  @Date_Created: 09-08-2020
*
*/

public class BoardHandler implements BoardInterface{
  private int xNum;
  private int yNum;
  private int xOffset;
  private int yOffset;
  private int indexOffset;

  private int xBoard;
  private int yBoard;
  private Board ui;

  /**
  * @pre:   constructor
  * @post:  implements the restrictions for the main board
  * @param: must have board size, offset and index offset
  * @return:None
  */
  public BoardHandler(int t_xNum, int t_yNum, int t_xOffset, int t_yOffset, int t_indexOffset){
    this.xNum = t_xNum;
    this.yNum = t_yNum;

    this.xOffset = t_xOffset;
    this.yOffset = t_yOffset;
    this.indexOffset = t_indexOffset;
  }

  /**
  * @pre:     must have called constructor
  * @post:    creates the board with the size of the internal boards
  * @param:   x and y of the size of internal boards, and default marker
  */
  public void create(int x, int y, char t_board_marker){
    this.xBoard = x;
    this.yBoard = y;
    int xdimensions = this.xNum * (x + indexOffset);
    xdimensions = xdimensions + this.xOffset * (this.xNum + 1);

    int ydimensions = this.yNum * (y + indexOffset);
    ydimensions = ydimensions + this.yOffset * (this.yNum + 1);

    char marker = 183;
    ui = new Board(xdimensions, ydimensions, t_board_marker);
  }

  /**
  * @pre:     must have create called
  * @post:    adds board to a certain x and y value on main board
  * @param:   Pass in Board Object (do not use getCopyBoard()) and index boolean
  *           (true is index, false is no index)
  */
  public void addBoard(Board g, int x, int y, boolean indexed){
    if(g.getXSize() != this.xBoard || g.getYSize() != this.yBoard){
        String msg = "BoardHandler::addBoard() :Board size does not fit\n";
        throw new RuntimeException(msg);
    }
      int xInput = 0;
      int yInput = 0;

      char x_ui = '0';
      char y_ui = 'A';

      xInput = this.xOffset + (x * (this.xOffset + g.getXSize())) + (x+1) * this.indexOffset;
      yInput = this.yOffset + (y * (this.yOffset + g.getYSize())) + (y+1) * this.indexOffset;
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

      xInput = this.xOffset + (x * (this.xOffset + g.getXSize())) + (x+1) * this.indexOffset;
      yInput = this.yOffset + (y * (this.yOffset + g.getYSize())) + (y+1) * this.indexOffset;
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
    char marker = 183;
    Board copy = new Board(ui.getXSize(), ui.getYSize(), marker);
    for(int i = 0; i < ui.getYSize(); i++){
      for(int k = 0; k < ui.getXSize(); k++){
        copy.addMarker(ui.getMarker(k, i), k, i);
      }
    }
    return copy;
  }

}
