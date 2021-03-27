package Game.States;

import Game.Game;
import Game.Assets;
import java.awt.*;

public class MenuState extends State {
    public static int ButtonID;

    public MenuState(Game game){
        super(game);
    }

    @Override
    public void update() {
        if(game.getMouseManager().getMouseX()>150 && game.getMouseManager().getMouseX()<300 &&
            game.getMouseManager().getMouseY()>250 && game.getMouseManager().getMouseY()<510 &&
            game.getMouseManager().isLeftPressed())
        {
            ButtonID = 1; // Gozluklu Sirinin ID'si
            game.gameState = new GameState(game);
            State.setState(game.gameState);
        }
        else if(game.getMouseManager().getMouseX()>400 && game.getMouseManager().getMouseX()<650 &&
                game.getMouseManager().getMouseY()>250 && game.getMouseManager().getMouseY()<500 &&
                game.getMouseManager().isLeftPressed())
        {
            ButtonID = 2; // Tembel Sirinin ID'si
            game.gameState = new GameState(game);
            State.setState(game.gameState);
        }
    }

    @Override
    public void render(Graphics g) {
        g.create(0,0,832,704);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 75));
        g.drawString("Karakterinizi Seciniz",100,100);

        g.setColor(Color.BLUE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString("Gozluklu Sirin",150,200);
        g.drawString("Tembel Sirin",500,200);
        g.drawImage(Assets.GozlukluSirin,150,250,150,260,null);
        g.drawImage(Assets.TembelSirin,500,250,150,250,null);

    }
}
