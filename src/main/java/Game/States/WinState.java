package Game.States;

import Game.Game;
import Game.Karakterler.Oyuncu;
import Game.Karakterler.Puan;

import java.awt.*;

public class WinState extends State{
    public WinState(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.create(0,0,832,704);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 100));
        g.drawString("Kazandiniz! ",175,250);

        g.setColor(Color.GREEN);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 75));
        g.drawString("Skorunuz: " + Puan.Skor,200,400);
    }
}
