//If classes come from files in the same folder, you don't have to import them :)
//You can compile this program in the terminal with "javac Battleship.java" and run it with "java Battleship"

/**
 * 
 * This is the program's main entry point.
 * 
 *
 * @author: Sean Cunningham
 * @KUID: 2935773
 * @Email: s096c429@ku.edu
 * 
 */
public class Battleship {
    public static void main(String[] args) {
        //This the the program's main
        executive gameHandler = new executive();
        gameHandler.run();
    }
}