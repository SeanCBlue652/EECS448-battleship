/**
*	@Name:	 Peter Tso
*	@KUID:	 2936825
*	@Email:  tsopeter@ku.edu
*	@Brief:
*		This is the collision handler file. When given char marker, it
*		checks the given Board Object at the position (x,y).
*		Then returns true if there is a collision, or
*		false when there is no collision.
*	@Note:
*		There are no protections from OutOfBounds. Please
*		implement protections on your own code when using
*		CollisionHandler.java
*
*		Update:	20200908
*
*		Added out of bounds detection.
*
*	@Req'd:
*		The required files are below:
*
*		--Board.java.
*
*		Thank you.
*
*	@Date_Created:					09-05-2020
*	@Date_Modified:					09-08-2020
*/
public class CollisionHandler {

	/**
	*	@pre:	 must be given a constructed Board and valid (x,y) position
	*	@post:	 checks to see if given place is same to marker
	*	@return: boolean
	*	@note:
	*		When using check() please use getCopyBoard()
	*/
	public static boolean check(Board g, char marker, int x, int y){
		if(x < 0 || y < 0 || x > g.getXSize() || y > g.getYSize()){
			throw new IllegalArgumentException("The proivded coordinates are out of bounds.");
		}
		if(g.getMarker(x, y) == marker){
			return true;
		}
		return false;
	}
}
