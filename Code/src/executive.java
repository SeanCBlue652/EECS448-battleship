import java.util.Scanner;
import java.lang.IllegalArgumentException;

/**
 * @Name: Sean Cunningham
 * @KUID: 2935773
 * @Email: s096c429@ku.edu
 */
class executive {

  private Scanner consoleInput = new Scanner(System.in);
  private char[] coordinateLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' };

  /**
   * @pre: None
   * @post: Prints "Hello World". This method provides an example to the team of
   *        how to call methods from other classes in Java.
   * @param: None
   */
  public void helloWorld() {
    System.out.println("Hello world!");
  }

  /**
   * @pre: None
   * @post: Prints 50 newlines to the terminal in order to move previous messages
   *        out of sight
   * @param: None
   */
  public void clearTerminal() {
    for (int i = 0; i < 50; i++) {
      System.out.println("");
    }
  }

  // Used to convert letters to ints, used when given coordinates in (A1-I9) form
  private int letterToInt(char col) {
    col = Character.toLowerCase(col);
    for (int i = 0; i < coordinateLetters.length; i++) {
      if (col == coordinateLetters[i]) {
        return (i);
      }
    }
    throw new IllegalArgumentException(col + " is out of bounds.");
  }

  // Writes menu
  private void postMenu() {
    System.out.println("Menu:");
    System.out.println("Type '1' to choose where to attack.");
    System.out.println("Type '2' to review your board.");
    System.out.println("Type '3' to view your attack history.");
    System.out.println("Type '4' to forfeit the match.");
    System.out.println("CHOICE:");
  }

  private boolean validateShipNum(int num) {
    if (num > 5 || num < 1) {
      return (false);
    }
    return (true);
  }

  private int safelyGetIntInput() {
    boolean invalidInput = true;
    String input = "";
    int output = 0;
    do {
      input = consoleInput.next();
      try {
        output = Integer.parseInt(input);
        invalidInput = false;
      } catch (NumberFormatException nfe) {
        System.out.println("Please input an int.");
        input = consoleInput.nextLine();
      }

    } while (invalidInput);
    return (output);
  }

  private String safelyGetCoordinates() {
    boolean invalidInput = true;
    String input = "";
    String output = "";
    boolean colValid = false;
    boolean rowValid = false;
    char col = 'z';
    char row = 'z';
    do {
      input = consoleInput.next();
      if (input.length() < 2) {
        System.out.println("Please input coordinates in the format: A1");
      } else {
        col = input.charAt(0);
        row = input.charAt(1);
        int temp;
        try {
          temp = letterToInt(col); // This will throw an IllegalArgumentException if the col letter is out of range
          colValid = true;
        } catch (IllegalArgumentException iae) {
          System.out.println(iae.getMessage());
          System.out.println("Please input coordinates within the range of A1 - I9");
          colValid = false;
        }
        try {
          temp = Integer.parseInt("" + row); // This will throw a NumberFormatException if row is not a number
          rowValid = true;
        } catch (NumberFormatException nfe) {
          System.out.println(row + " is not an int.");
          System.out.println("Please input coordinates in the format: A1.");
          rowValid = false;
        }
        if (colValid && rowValid) {
          output = "" + col + row;
          invalidInput = false; // This line won't be reached until there are no errors
        }
      }

    } while (invalidInput);
    return (output);
  }

  // main function
  public void run() {
    // SET-UP--------------------------------------------------------------------------------------------------------------------------------
    Board player1Board = new Board(9, 9, '~');
    Board player2Board = new Board(9, 9, '~');
    int numberOfShips = 0;
    char shipDirection;
    String input = "";
    // greetings
    System.out.println("Welcome to the game of Battleship!");
    System.out.println("How many ships (per person) would you like to play with (1-5)?");
    // INPUT taken from user: numberOfShips (1-5)

    do {
      numberOfShips = safelyGetIntInput();
    } while (validateShipNum(numberOfShips) == false);

    // There are numberOfShips ships to place for each player, each with ships sized
    // 1x(1->numberOfShips)
    System.out.println("Player 2, please look away from the screen while Player 1 places their ships.");
    int tempShipRow;
    // char tempShipRowChar;
    int tempShipCol;
    // char tempShipColChar;
    int tempShipSize;
    // for loop: Where does P1 want the tip of their boat (A1-I9)
    for (int i = 0; i < numberOfShips; i++) {
      boolean successfulPlacement = false;
      do {
        successfulPlacement = placeShip(player1Board, i);
      } while (!successfulPlacement);
    }
    // warn player 1 to now look away from the screen

    clearTerminal();

    System.out.println("It's now Player 1's turn to look away from the screen while Player 2 places their ships.");
    for (int i = 0; i < numberOfShips; i++) {
      System.out.println("Where do you want to place the tip of your ship? (A1-I9)? ");
      input = safelyGetCoordinates();
      tempShipCol = letterToInt(input.charAt(0));
      tempShipRow = Integer.parseInt("" + input.charAt(1));
      tempShipSize = i + 1;
      // tip must be in a valid spot
      // if length is >1, then there must be at least one possible placement to fit
      // the rest of the ship from the chosen spot for the ship's tip

      System.out.println(
          "Which direction do you want this ship to face ('N' for North, 'E' for East, 'S' for South, or 'W' for West)?");
      shipDirection = getValidShipDirection();
      // Check to see if the rest of the ship fits on the board
      // if not, inform user and ask for another direction

      // IMPORTANT
      // NEEDS IMPLEMENTATION--use shipDirection with tempShipRow & tempShipCol to
      // place ship, using i to check what size ship
      // IMPORTANT

    }

    // GAME
    // START--------------------------------------------------------------------------------------------------------------------------------
    boolean p1Win = false;
    boolean p2Win = false;
    int i = 0;
    int menuChoice;
    int attackCol;
    int attackRow;
    char attackColChar;
    char attackRowChar;

    do {
      if (i % 2 == 0)// player 1's turn
      {
        clearTerminal();
        System.out.println("It is now Player 1's turn.");
        // MENU:
        postMenu();
        menuChoice = safelyGetIntInput();
        // Type "1" to choose where to attack
        if (menuChoice == 1) {
          System.out.println("Where do you want to send your attack? (A1-I9)? ");
          input = safelyGetCoordinates();
          attackColChar = input.charAt(0);
          attackRowChar = input.charAt(1);
          // (y-axis) column char to int
          attackCol = letterToInt(attackColChar);
          // (x-axis) row char to int
          // only proceed if row is valid
          if (Character.getNumericValue(attackRowChar) >= 1 && Character.getNumericValue(attackRowChar) <= 9) {
            attackRow = Character.getNumericValue(attackRowChar) - 1;
          } else {
            break;
          }

          // IMPORTANT
          // NEEDS IMPLEMENTATION--Use attackCol and attackRow as x and y values
          // NEEDS IMPLEMENTATION--Change value of p1Win, if applicable
          // IMPORTANT

          i++;
        }
        // Type "2" to review your board
        else if (menuChoice == 2) {
          do {
            // Print player 2's board
            // does not end player's turn
            // type "Q" or "q" to display menu again

            // IMPORTANT
            // NEEDS IMPLEMENTATION--print current player (Player 1)'s board)
            // IMPORTANT

          } while (consoleInput.next().toLowerCase() != "q");
          postMenu();
          menuChoice = safelyGetIntInput();
        }
        // Type "3" to view your attack history
        else if (menuChoice == 3) {
          do {
            // Print Player 2's attack history board
            // does not end player's turn
            // type "Q" or "q" to display menu again

            // IMPORTANT
            // NEEDS IMPLEMENTATION--print current player (Player 1)'s attack history board)
            // IMPORTANT

          } while (consoleInput.next().toLowerCase() != "q");
          postMenu();
          menuChoice = safelyGetIntInput();
        }
        // Type "4" to forfeit match
        else if (menuChoice == 4) {
          // exit loop
          // player 2 declared winner & p1 as loser
          p1Win = false;
          p2Win = true;
          i++;
        }
        // if illegal input, print apology, then display menu choices again
        else {
          System.out.println("Sorry, that is not a valid menu option.");
          postMenu();
          menuChoice = safelyGetIntInput();
        }
      }

      // player2 turn
      else {
        clearTerminal();
        // player 2's turn
        System.out.println("It is now Player 2's turn.");
        // MENU:
        postMenu();
        menuChoice = safelyGetIntInput();
        // Type "1" to choose where to attack
        if (menuChoice == 1) {
          System.out.println("Where do you want to send your attack? (A1-I9)? ");
          input = safelyGetCoordinates();
          attackColChar = input.charAt(0);
          attackRowChar = input.charAt(1);
          // (y-axis) column char to int
          attackCol = letterToInt(attackColChar);
          // (x-axis) row char to int
          // only proceed if row is valid
          if (Character.getNumericValue(attackRowChar) >= 1 && Character.getNumericValue(attackRowChar) <= 9) {
            attackRow = Character.getNumericValue(attackRowChar) - 1;
          } else {
            break;
          }

          // IMPORTANT
          // NEEDS IMPLEMENTATION--Use attackCol and attackRow as x and y values
          // NEEDS IMPLEMENTATION--Change value of p2Win, if applicable
          // IMPORTANT

          i++;
        }

        // Type "2" to review your board
        else if (menuChoice == 2) {
          do {
            // Print player 2's board
            // does not end player's turn

            // IMPORTANT
            // NEEDS IMPLEMENTATION--print current player (Player 2)'s board
            // IMPORTANT

            // type "Q" or "q" to display menu again
          } while (consoleInput.next().toLowerCase() != "q");
          postMenu();
          menuChoice = safelyGetIntInput();
        }

        // Type "3" to view your attack history
        else if (menuChoice == 3) {
          do {
            // Print Player 2's attack history board
            // does not end player's turn

            // IMPORTANT
            // NEEDS IMPLEMENTATION--print current player (Player 2)'s attack history board)
            // IMPORTANT

            // type "Q" or "q" to display menu again
          } while (consoleInput.next().toLowerCase() != "q");
          postMenu();
          menuChoice = safelyGetIntInput();
        }
        // Type "4" to forfeit match
        else if (menuChoice == 4) {
          // exit loop
          // player 1 declared winner & p2 as loser
          System.out.println("");
          p1Win = true;
          p2Win = false;
          i++;
        }
        // if illegal input, print apology, then display menu choices again
        else {
          System.out.println("Sorry, that is not a valid menu option.");
          postMenu();
          menuChoice = safelyGetIntInput();
        }
      }

    } while (p1Win == false && p2Win == false);
    // GAME
    // END--------------------------------------------------------------------------------------------------------------------------------
    // Print Congratulations to winning player
    if (p1Win == true && p2Win == false) {
      System.out.println("Congratulations, Player 1!");
    } else if (p1Win == false && p2Win == true) {
      System.out.println("Congratulations, Player 2!");
    } else {
      System.out.println("Sorry, there was an error.");
    }
    // Thank you for playing
    System.out.println("Thank you for playing.");
    System.out.println(" ");

  }

  private boolean placeShip(Board board, int shipSize) {
    System.out.println("Where do you want to place the tip of your ship? (A1-I9)? ");
    String input = safelyGetCoordinates(); // This validates the user input
    int col = letterToInt(input.charAt(0));
    int row = Integer.parseInt("" + input.charAt(1));
    int size = shipSize + 1;

    try {
      if (CollisionHandler.check(board, 's', row, col)) {
        System.out.println("The space " + col + row + " is already occupied.");
        return (false);
      }
    } catch (IllegalArgumentException iae) {
      System.out.println(iae.getMessage());
      return (false);
    }

    int numOpenDirections = 4;
    try {
      if (CollisionHandler.check(board, 's', row + 1, col)) {
        numOpenDirections--;
      }
    } catch (IllegalArgumentException iae) {
      numOpenDirections--;
    }
    try {
      if (CollisionHandler.check(board, 's', row - 1, col)) {
        numOpenDirections--;
      }
    } catch (IllegalArgumentException iae) {
      numOpenDirections--;
    }
    try {
      if (CollisionHandler.check(board, 's', row, col + 1)) {
        numOpenDirections--;
      }
    } catch (IllegalArgumentException iae) {
      numOpenDirections--;
    }
    try {
      if (CollisionHandler.check(board, 's', row, col - 1)) {
        numOpenDirections--;
      }
    } catch (IllegalArgumentException iae) {
      numOpenDirections--;
    }

    if (numOpenDirections == 0) {
      return (false);
    }

    boolean directionSucceeded = false;
    char shipDirection = 'z';

    do {
      System.out.println(
          "Which direction do you want this ship to face ('N' for North, 'E' for East, 'S' for South, or 'W' for West)?");
      shipDirection = getValidShipDirection();

      switch (shipDirection) {
        case 'n':
          directionSucceeded = true;
          for (int z = 0; z < size; z++) {
            if (directionSucceeded) {
              try {
                if (CollisionHandler.check(board, 's', row + z, col)) {
                  int num = row + z;
                  System.out.println("The space " + col + num + " is already occupied. Please pick a new orientation.");
                  directionSucceeded = false;
                }
              } catch (IllegalArgumentException iae) {
                int num = row + z;
                System.out.println("The space " + col + num + " is out of bounds. Please pick a new orientation.");
                directionSucceeded = false;
              }
            }
            if (directionSucceeded) {
              shipDirection = 'n';
            }
          }
          break;
        case 's':
          directionSucceeded = true;
          for (int z = 0; z < size; z++) {
            if (directionSucceeded) {
              try {
                if (CollisionHandler.check(board, 's', row - z, col)) {
                  int num = row - z;
                  System.out.println("The space " + col + num + " is already occupied. Please pick a new orientation.");
                  directionSucceeded = false;
                }
              } catch (IllegalArgumentException iae) {
                int num = row - z;
                System.out.println("The space " + col + num + " is out of bounds. Please pick a new orientation.");
                directionSucceeded = false;
              }
            }
            if (directionSucceeded) {
              shipDirection = 's';
            }
          }
          break;
        case 'w':
          directionSucceeded = true;
          for (int z = 0; z < size; z++) {
            if (directionSucceeded) {
              try {
                if (CollisionHandler.check(board, 's', row, col - z)) {
                  char letter = coordinateLetters[col - z];
                  System.out
                      .println("The space " + letter + row + " is already occupied. Please pick a new orientation.");
                  directionSucceeded = false;
                }
              } catch (IllegalArgumentException iae) {
                char letter = coordinateLetters[col - z + 1];
                System.out.println(
                    "The space to the west of " + letter + row + " is out of bounds. Please pick a new orientation.");
                directionSucceeded = false;
              }
            }
            if (directionSucceeded) {
              shipDirection = 'w';
            }
          }
          break;
        case 'e':
          directionSucceeded = true;
          for (int z = 0; z < size; z++) {
            if (directionSucceeded) {
              try {
                if (CollisionHandler.check(board, 's', row, col + z)) {
                  char letter = coordinateLetters[col + z];
                  System.out
                      .println("The space " + letter + row + " is already occupied. Please pick a new orientation.");
                  directionSucceeded = false;
                }
              } catch (IllegalArgumentException iae) {
                char letter = coordinateLetters[col + z - 1];
                System.out.println(
                    "The space to the east of " + letter + row + " is out of bounds. Please pick a new orientation.");
                directionSucceeded = false;
              }
            }
            if (directionSucceeded) {
              shipDirection = 'e';
            }
          }
          break;

        default:
          break;
      }
    } while (!directionSucceeded);

    switch (shipDirection) {
      case 'n':
        for (int i = 0; i < size; i++) {
          board.addMarker('s', row+i, col);
        }
        break;
        case 's':
        for (int i = 0; i < size; i++) {
          board.addMarker('s', row-i, col);
        }
        break;
        case 'w':
        for (int i = 0; i < size; i++) {
          board.addMarker('s', row, col-i);
        }
        break;
        case 'e':
        for (int i = 0; i < size; i++) {
          board.addMarker('s', row, col+i);
        }
        break;
    
      default:
        break;
    }

    return(true);

  }



  private char getValidShipDirection() {
    String userInput = "";
    char dir = 'z';
    boolean dirInvalid = true;
    do {
      userInput = consoleInput.next();
      switch (userInput.toLowerCase()) {
        case "n":
          dir = 'n';
          dirInvalid = false;
          break;
        case "s":
          dir = 's';
          dirInvalid = false;
          break;

        case "e":
          dir = 'e';
          dirInvalid = false;
          break;

        case "w":
          dir = 'w';
          dirInvalid = false;
          break;

        default:
          System.out
              .println("Please provide valid input: ('N' for North, 'E' for East, 'S' for South, or 'W' for West)");
          break;
      }
    } while (dirInvalid);
    return (dir);
  }
}

// references:
// https://www.quora.com/What-function-do-we-use-in-Java-in-place-of-cin-in-C++
// ref: https://www.javatpoint.com/java-char-to-int
// ref: https://beginnersbook.com/2013/12/java-string-charat-method-example/
