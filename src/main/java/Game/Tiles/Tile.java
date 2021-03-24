package Game.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    //Static Variables
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    public static Tile[] tiles = new Tile[144];
    public static Tile grayTile = new GrayTile(0);
    public static Tile whiteTile = new WhiteTile(1);
    public static Tile blueTile = new BlueTile(2);
    public static Tile pinkTileA = new PinkTileA(3);
    public static Tile pinkTileB = new PinkTileB(4);
    public static Tile pinkTileC = new PinkTileC(5);
    public static Tile pinkTileD = new PinkTileD(6);


    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }

    public void update(){

    }

    public void render(Graphics g, int x,int y){
        g.drawImage(texture,x, y, TILEWIDTH, TILEHEIGHT, null);
    }
}
