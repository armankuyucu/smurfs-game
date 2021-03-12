package Game;

import Karakterler.GozlukluSirin;
import Karakterler.Oyuncu;

import java.awt.*;

public class GameState extends State{
    private Oyuncu oyuncu;
    public GameState(Game game){
        super(game);
        oyuncu = new Oyuncu(game,560,450, 1, "GozlukluSirin", "Oyuncu");
    }

    @Override
    public void update() {
        oyuncu.update();
    }

    @Override
    public void render(Graphics g) {
        oyuncu.render(g);
    }
}
