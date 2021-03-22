package Game;

/**
 *
 * @author arman
 */
public class Launcher {
    Display display;
    public static void main(String[] args) {
        Game game = new Game("Game",832, 704);
        game.start();
    }
}
