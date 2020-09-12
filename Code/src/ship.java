/**
*		@Name: Peter Tso
*		@Email: tsopeter@ku.edu
*	  @Brief
*						This file handles placing ships onto the board,
*						checking for collisions, and checking if the ship
*						has been sunk.
*		@Required:
*						+Board.java
*
*		@Date_created:		09-11-2020
*/
public class ship{
	private int xPos;
	private int yPos;
	private int size;
	private int orientation;

	private char marker;
	private char hit_marker;
	private int hit_taken;

	private int shipFront;
	private int shipEnd;

	private Board g;

	public ship(){
		System.out.println("ship created");
		xPos = 0;
		yPos = 0;
		size = 0;
		orientation = 0;
		marker = '\0';
		hit_marker = '\0';
		hit_taken = 0;
	}

	/**
	*		@pre:	must have called setMarker
	*		@param:	takes a Board, int x, int y, int size, int orientation
	*		@post: sets down the ship
	*		@return:	true when ship has been set
	*/
	public boolean setShip(Board t_g, int t_xPos, int t_yPos, int t_size, int t_orientation){
		if(t_xPos < 0 || t_xPos >= t_g.getXSize() || t_yPos < 0 || t_yPos >= t_g.getYSize()){
			System.out.println("ship::setShip(): out of bounds");
			return false;
		}
		if(CollisionHandler.check(t_g.getCopyBoard(), this.marker, t_xPos, t_yPos)){
			System.out.println("ship::setShip(): collision[1]");
			return false;
		}
		if(t_size == 1){
			this.size = t_size;
			this.orientation = 0;
			this.g = t_g;
			this.xPos = t_xPos;
			this.yPos = t_yPos;
			this.g.addMarker(marker, this.xPos, this.yPos);
			return true;
		}

		int begin = 0;
		int end = 0;
		if(t_orientation == 1){
			begin = t_yPos - t_size + 1;
			end = t_yPos;
		}
		else if(t_orientation == 2){
			begin = t_xPos;
			end = t_xPos + t_size - 1;
		}
		else if(t_orientation == 3){
			begin = t_yPos;
			end = t_yPos + t_size -1;
		}
		else if(t_orientation == 4){
			begin = t_xPos - t_size + 1;
			end = t_xPos;
		}
		else{
			System.out.println("ship::setShip(): false orientation");
			return false;
		}
		for(int i = begin; i <= end; i++){
			if(t_orientation == 1 || t_orientation == 3){
				if(CollisionHandler.check(t_g.getCopyBoard(), this.marker, t_xPos, i)){
					System.out.println("ship::setShip(): orientation collision");
					return false;
				}
			}
			else{
					if(CollisionHandler.check(t_g.getCopyBoard(), this.marker, i, t_yPos)){
						System.out.println("ship::setShip(): orientation collision");
						return false;
					}
			}
		}
		this.orientation = t_orientation;
		this.xPos = t_xPos;
		this.yPos = t_yPos;
		this.size = t_size;
		this.g = t_g;
		this.shipFront = begin;
		this.shipEnd = end;
		for(int i = begin; i <= end; i++){
			if(orientation == 1 || orientation == 3){
				this.g.addMarker(this.marker, this.xPos, i);
			}
			else{
				this.g.addMarker(this.marker, i, this.yPos);
			}
		}
		return true;
	}

	/**
	*		@pre:	must have constructed
	*		@param:	char ship_marker, char hit_marker
	*		@post: sets the characters for the ship
	*		@return: NONE
	*/
	public void setMarker(char t_marker, char t_hit_marker){
		this.marker = t_marker;
		this.hit_marker = t_hit_marker;
	}

	/**
	*		@pre: must be called by isSunk()
	*		@param: None
	*		@post: checks the condition of the ship
	*		@return: None
	*/
	private void checkForDamage(){
		if(hit_taken == size){
			return;
		}
		this.hit_taken = 0;
		for(int i = this.shipFront; i <= this.shipEnd; i++){
			if(orientation == 1 || orientation == 3){
				if(this.g.getMarker(this.xPos, i) == this.hit_marker){
					this.hit_taken++;
				}
			}
			else{
				if(this.g.getMarker(i, this.yPos) == this.hit_marker){
					this.hit_taken++;
				}
			}
		}
	}

	/**
	*		@pre: must have setShip called
	*		@param: NONE
	*		@post:	checks when ship has isSunk
	*		@return: true when ship is sunk
	*/
	public boolean isSunk(){
		this.checkForDamage();
		if(hit_taken == size){
			return true;
		}
		return false;
	}
}
