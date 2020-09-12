import java.util.Scanner;

class executive {

    /**
	  *	@pre:	None
	  *	@post: Prints "Hello World". This method provides an example to the team of how to call methods from other classes in Java.
	  *	@param: None
	  */
    public void helloWorld() {
      System.out.println("Hello world!");
    }

    /**
	  *	@pre:	None
	  *	@post: Prints 50 newlines to the terminal in order to move previous messages out of sight
	  *	@param: None
	  */
    public void clearTerminal() {
      for (int i = 0; i < 50; i++) {
        System.out.println("");
      }
    }
    
}

//SET-UP--------------------------------------------------------------------------------------------------------------------------------
//greetings
//How many ships do you want to play with for each player?
  //INPUT BOTH-numberOfShips (1-5)
    //There are numberOfShips ships to place for each player, each with a ship size 1x(1 to NumberOfShips)
//warn player 2 to look away from the screen while player 1 places ships
//for (1 to number of Ships) Where do you want the tip of your boat (A1-I9)
  //INPUT USER1-shipTipSpot
    //Input as String
      //string.at(0) - convert letter to number, x-axis
      //string.at(1) - y-axis
    //tip must be in a valid spot
    //if length is >1, then there must be at least one possible placement to fit the rest of the ship from the chosen spot for the ship's tip
  //Which direction do you want this ship to face? ('N' for North, 'E' for East, 'S' for South, or 'W' for West)
    //INPUT USER1-direction
      //Check to see if the rest of the ship fits on the board
      //if not, inform user and ask for another direction
  //progress through for loop for each ship
//warn player 1 to now look away from the screen
//for (1 to number of Ships) Where do you want the tip of your boat (A1-I9)
  //INPUT USER2-shipTipSpot
    //Input as String
      //string.at(0) - convert letter to number, x-axis
      //string.at(1) - y-axis
    //tip must be in a valid spot
    //if length is >1, then there must be at least one possible placement to fit the rest of the ship from the chosen spot for the ship's tip
  //Which direction do you want this ship to face? ('N' for North, 'E' for East, 'S' for South, or 'W' for West)
    //INPUT USER2-direction
      //Check to see if the rest of the ship fits on the board
      //if not, inform user and ask for another direction
  //loop for


//GAME START--------------------------------------------------------------------------------------------------------------------------------
//for (i=0; i++)
  //i%2

    //if i=0
      //player 1's turn
        //MENU:
        //Type "1" to choose where to attack
          //enter coordinates
          //if attack hits, update attack history with hit spot then check if there’s any more battleship spots on player 2’s board array
            //if there are no ship spots left, then win
          //If attack misses, update attack history with miss spot
        //Type "2" to review your board
          //Print player 1's board
          //does not end player's turn
          //type "Q" or "q" to display menu again
        //Type "3" to view your attack history
          //Print Player 1's attack history board
          //does not end player's turn
          //type "Q" or "q" to display menu again
        //Type "4" to forfeit match
          //exit loop
          //player 2 declared winner
        //if illegal input, print "Sorry, that is not a valid menu option." then display menu choices again

    //else
     //player 2's turn
      //MENU:
      //Type "1" to choose where to attack
        //enter coordinates
        //if attack hits, update attack history with hit spot then check if there’s any more battleship spots on player 1’s board array
          //if there are no ship spots left, then win
        //If attack misses, update attack history with miss spot
     //Type "2" to review your board
       //Print player 2's board
       //does not end player's turn
       //type "Q" or "q" to display menu again
     //Type "3" to view your attack history
       //Print Player 2's attack history board
       //does not end player's turn
       //type "Q" or "q" to display menu again
     //Type "4" to forfeit match
        //exit loop
        //player 1 declared winner
     //if illegal input, print "Sorry, that is not a valid menu option." then display menu choices again


//GAME END--------------------------------------------------------------------------------------------------------------------------------
  //Print Congratulations to winning player
  //Thank you for playing
