package Sirinler;

import java.awt.*;

public class GameState extends State{
    public GameState(){

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Arkaplan,0,0,null);
        g.drawImage(Assets.GozlukluSirin,560,450,null);
    }
}
