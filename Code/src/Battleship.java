//If classes come from files in the same folder, you don't have to import them :)
//You can compile this program in the terminal with "javac Battleship.java" and run it with "java Battleship"

public class Battleship {
    public static void main(String[] args) {
        //This the the program's main
        executive gameHandler = new executive();
        gameHandler.run();
    }
}