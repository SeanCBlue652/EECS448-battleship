//If classes come from files in the same folder, you don't have to import them :)

public class Battleship {
    public static void main(String[] args) {
        //This the the program's main
        executive gameHandler = new executive(); // This is me instantiating an executive class, which comes from the other file in the same folder.
        System.out.println(gameHandler.helloWorld()); //You can compile this program in the terminal with "javac Battleship.java" and run it with "java Battleship"
        
    }
}