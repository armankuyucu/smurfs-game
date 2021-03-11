package Sirinler;

/**
 *
 * @author arman
 */
public class Launcher {
    Display display;
    public static void main(String[] args) {
        Game game = new Game("Sirinler",1170, 990);
        game.start();
    }
}
