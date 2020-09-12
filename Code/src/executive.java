public class executive {
    /*public String helloWorld() {
        return("Hello world!");
    }*/


//Used to convert letters to ints, used when given coordinates in (A1-I9) form
static int letterToInt(char col)
{
  if (col=='A' || col=='a')
  {
    return 0;
  }
  else if (col=='B' || col=='b')
  {
    return 1;
  }
  else if (col=='C' || col=='c')
  {
    return 2;
  }
  else if (col=='D' || col=='d')
  {
    return 3;
  }
  else if (col=='E' || col=='e')
  {
    return 4;
  }
  else if (col=='F' || col=='f')
  {
    return 5;
  }
  else if (col=='G' || col=='g')
  {
    return 6;
  }
  else if (col=='H' || col=='h')
  {
    return 7;
  }
  else if (col=='I' || col=='i')
  {
    return 8;
  }
  else //temp for bad input
  {
    return 0;
  }
}

//Writes menu
static void postMenu()
{
  System.out.println("Menu:");
  System.out.println("Type '1' to choose where to attack.");
  System.out.println("Type '2' to review your board.");
  System.out.println("Type '3' to view your attack history.");
  System.out.println("Type '4' to forfeit the match.");
  System.out.println("CHOICE:");
}






//main function
public static void main()
{
//SET-UP--------------------------------------------------------------------------------------------------------------------------------
BufferedReader consoleInput=new BufferedReader (new InputStream(System.in));
int numberOfShips;
char shipDirection;
//greetings
System.out.println("Welcome to the game of Battleship!");
System.out.println("How many ships (per person) would you like to play with (1-5)?");
//INPUT taken from user: numberOfShips (1-5)
numberOfShips=Integer.parseInt(consoleInput.readLine());
    //There are numberOfShips ships to place for each player, each with ships sized 1x(1->numberOfShips)
System.out.println("Player 2, please look away from the screen while Player 1 places their ships.");
int tempShipRow;
char tempShipRowChar;
int tempShipCol;
char tempShipColChar;
int tempShipSize;
//for loop: Where does P1 want the tip of their boat (A1-I9)
for (int i=0; i<numberOfShips; i++)
{
  System.out.println("Where do you want to place the tip of your ship? (A1-I9)? ");
  tempShipColChar=consoleInput.readLine().charAt(0);
  tempShipRowChar=consoleInput.readline().charAt(1);
  //(y-axis) column char to int
  tempShipCol=letterToInt(tempShipColChar);
  //(x-axis) row char to int
  if (Character.getNumericValue(tempShipRowChar)>=1 && Character.getNumericValue(tempShipRowChar)<=9) //only proceed if row is valid
  {
    tempShipRow=Character.getNumericValue(tempShipRowChar) - 1;
  }
  else
  {
    break;
  }
//tip must be in a valid spot
//if length is >1, then there must be at least one possible placement to fit the rest of the ship from the chosen spot for the ship's tip

  System.out.println("Which direction do you want this ship to face ('N' for North, 'E' for East, 'S' for South, or 'W' for West)?");
  shipDirection=consoleInput.readLine().charAt(0);
    //Check to see if the rest of the ship fits on the board
    //if not, inform user and ask for another direction


//IMPORTANT
//NEEDS IMPLEMENTATION--use shipDirection with tempShipRow & tempShipCol to place ship, using i to check what size ship
//IMPORTANT


  //progress through for loop for each ship
}
//warn player 1 to now look away from the screen

for (int i=0; i<9; i++)
{
 System.out.println("---");
}

System.out.println("It's now Player 1's turn to look away from the screen while Player 2 places their ships.");
for (int i=0; i<numberOfShips; i++)
{
  System.out.println("Where do you want to place the tip of your ship? (A1-I9)? ");
  tempShipColChar=consoleInput.readLine().charAt(0);
  tempShipRowChar=consoleInput.readline().charAt(1);
  //(y-axis) column char to int
  letterToInt(tempShipColChar);
  //(x-axis) row char to int
  if (Character.getNumericValue(tempShipRowChar)>=1 && Character.getNumericValue(tempShipRowChar)<=9) //only proceed if row is valid
  {
    tempShipRow=Character.getNumericValue(tempShipRowChar) - 1;
  }
  else
  {
    break;
  }
  //tip must be in a valid spot
  //if length is >1, then there must be at least one possible placement to fit the rest of the ship from the chosen spot for the ship's tip

  System.out.println("Which direction do you want this ship to face ('N' for North, 'E' for East, 'S' for South, or 'W' for West)?");
  shipDirection=consoleInput.readLine().charAt(0);
      //Check to see if the rest of the ship fits on the board
      //if not, inform user and ask for another direction

//IMPORTANT
//NEEDS IMPLEMENTATION--use shipDirection with tempShipRow & tempShipCol to place ship, using i to check what size ship
//IMPORTANT

}

//GAME START--------------------------------------------------------------------------------------------------------------------------------
boolean p1Win=false;
boolean p2Win=false;
int i=0;
int menuChoice;
int attackCol;
int attackRow;
char attackColChar;
char attackRowChar;

do
{
    if (i%2==0)//player 1's turn
    {
       for (int i=0; i<9; i++)
       {
        System.out.println("---");
       }
       System.out.println("It is now Player 1's turn.");
        //MENU:
         postMenu();
         menuChoice=Integer.parseInt(consoleInput.readLine());
        //Type "1" to choose where to attack
        if (menuChoice==1)
        {
          System.out.println("Where do you want to send your attack? (A1-I9)? ");
          attackColChar=consoleInput.readLine().charAt(0);
          attackRowChar=consoleInput.readline().charAt(1);
          //(y-axis) column char to int
          attackCol=letterToInt(attackColChar);
          //(x-axis) row char to int
          //only proceed if row is valid
          if (Character.getNumericValue(attackRowChar)>=1 && Character.getNumericValue(attackRowChar)<=9)
          {
            attackRow=Character.getNumericValue(attackRowChar) - 1;
          }
          else
          {
            break;
          }

//IMPORTANT
//NEEDS IMPLEMENTATION--Use attackCol and attackRow as x and y values
//NEEDS IMPLEMENTATION--Change value of p1Win, if applicable
//IMPORTANT

          i++;
        }
        //Type "2" to review your board
        else if (menuChoice==2)
        {
          do {
          //Print player 2's board
          //does not end player's turn
          //type "Q" or "q" to display menu again

//IMPORTANT
//NEEDS IMPLEMENTATION--print current player (Player 1)'s board)
//IMPORTANT

          } while (consoleInput.readLine()!='q' || consoleInput.readLine()!='Q');
          postMenu();
          menuChoice=Integer.parseInt(consoleInput.readLine());
        }
        //Type "3" to view your attack history
        else if (menuChoice==3)
        {
          do {
            //Print Player 2's attack history board
            //does not end player's turn
            //type "Q" or "q" to display menu again

//IMPORTANT
//NEEDS IMPLEMENTATION--print current player (Player 1)'s attack history board)
//IMPORTANT

          } while (consoleInput.readLine()!='q' || consoleInput.readLine()!='Q');
          postMenu();
          menuChoice=Integer.parseInt(consoleInput.readLine());
        }
        //Type "4" to forfeit match
        else if (menuChoice==4)
        {
          //exit loop
          //player 2 declared winner & p1 as loser
          p1Win=false;
          p2Win=true;
          i++;
        }
        //if illegal input, print apology, then display menu choices again
        else
        {
          System.out.println("Sorry, that is not a valid menu option.");
          postMenu();
          menuChoice=Integer.parseInt(consoleInput.readLine());
        }
    }

//player2 turn
    else
    {
      for (int i=0; i<9; i++)
      {
       System.out.println("---");
      }
     //player 2's turn
      System.out.println("It is now Player 2's turn.");
     //MENU:
     postMenu();
     menuChoice=Integer.parseInt(consoleInput.readLine());
     //Type "1" to choose where to attack
     if (menuChoice==1)
     {
       System.out.println("Where do you want to send your attack? (A1-I9)? ");
       attackColChar=consoleInput.readLine().charAt(0);
       attackRowChar=consoleInput.readline().charAt(1);
       //(y-axis) column char to int
       attackCol=letterToInt(attackColChar);
       //(x-axis) row char to int
       //only proceed if row is valid
       if (Character.getNumericValue(attackRowChar)>=1 && Character.getNumericValue(attackRowChar)<=9)
       {
         attackRow=Character.getNumericValue(attackRowChar) - 1;
       }
       else
       {
         break;
       }

//IMPORTANT
//NEEDS IMPLEMENTATION--Use attackCol and attackRow as x and y values
//NEEDS IMPLEMENTATION--Change value of p2Win, if applicable
//IMPORTANT

       i++;
     }

     //Type "2" to review your board
     else if (menuChoice==2)
     {
       do {
       //Print player 2's board
       //does not end player's turn

//IMPORTANT
//NEEDS IMPLEMENTATION--print current player (Player 2)'s board
//IMPORTANT

       //type "Q" or "q" to display menu again
       } while (consoleInput.readLine()!='q' || consoleInput.readLine()!='Q');
       postMenu();
       menuChoice=Integer.parseInt(consoleInput.readLine());
     }

     //Type "3" to view your attack history
     else if (menuChoice==3)
     {
       do {
         //Print Player 2's attack history board
         //does not end player's turn

//IMPORTANT
//NEEDS IMPLEMENTATION--print current player (Player 2)'s attack history board)
//IMPORTANT

         //type "Q" or "q" to display menu again
       } while (consoleInput.readLine()!='q' || consoleInput.readLine()!='Q');
       postMenu();
       menuChoice=Integer.parseInt(consoleInput.readLine());
     }
     //Type "4" to forfeit match
     else if (menuChoice==4)
     {
        //exit loop
        //player 1 declared winner & p2 as loser
        System.out.println("");
        p1Win=true;
        p2Win=false;
        i++;
      }
     //if illegal input, print apology, then display menu choices again
     else
     {
       System.out.println("Sorry, that is not a valid menu option.");
       postMenu();
       menuChoice=Integer.parseInt(consoleInput.readLine());
     }
   }

}
while (p1Win == false && p2Win == false);
//GAME END--------------------------------------------------------------------------------------------------------------------------------
  //Print Congratulations to winning player
  if (p1Win==true && p2Win==false)
  {
    System.out.println("Congratulations, Player 1!");
  }
  else if (p1Win==false && p2Win==true)
  {
    System.out.println("Congratulations, Player 2!");
  }
  else
  {
    System.out.println("Sorry, there was an error.");
  }
  //Thank you for playing
  System.out.println("Thank you for playing.");
  System.out.println(" ");

}
}

//references: https://www.quora.com/What-function-do-we-use-in-Java-in-place-of-cin-in-C++
//ref: https://www.javatpoint.com/java-char-to-int
//ref: https://beginnersbook.com/2013/12/java-string-charat-method-example/
