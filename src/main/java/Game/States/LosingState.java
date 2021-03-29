package Game.States;

import Game.Game;
import Game.Karakterler.Puan;

import java.awt.*;

public class LosingState extends State {
    public LosingState(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.create(0, 0, 832, 704);
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 100));
        g.drawString("Kaybettiniz! ", 175, 250);

    }
}