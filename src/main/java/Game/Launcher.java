package Game;

/**
 *
 * @author arman
 */
public class Launcher {
    Display display;
    public static void main(String[] args) {
        Game game = new Game("Game",1170, 990);
        game.start();
    }
}
