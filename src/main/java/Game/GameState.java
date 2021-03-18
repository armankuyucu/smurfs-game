package Game;

import Karakterler.GozlukluSirin;
import Karakterler.Oyuncu;
import Karakterler.TembelSirin;

import java.awt.*;

public class GameState extends State{
    private Oyuncu oyuncu;
    public GameState(Game game){
        super(game);
        //oyuncu = new GozlukluSirin(game,560,450, 1, "GozlukluSirin", "Oyuncu");
        oyuncu = new TembelSirin(game,560,450, 1, "TembelSirin", "Oyuncu");
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
