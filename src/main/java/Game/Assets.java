package Game;

import java.awt.image.BufferedImage;

public class Assets {
    //Characters
   public static BufferedImage GozlukluSirin;
   public static BufferedImage Sirine;
   public static BufferedImage TembelSirin;
   //Tiles
    public static BufferedImage GrayTile;
    public static BufferedImage BlueTile;
    public static BufferedImage PinkTile;
    public static BufferedImage WhiteTile;
    public static void init(){
        Sirine = ImageLoader.loadImage("/Sirine.png");
        GozlukluSirin = ImageLoader.loadImage("/GozlukluSirin.png");
        TembelSirin = ImageLoader.loadImage("/TembelSirin.png");
        GrayTile = ImageLoader.loadImage("/GrayTile.png");
        BlueTile = ImageLoader.loadImage("/BlueTile.png");
        PinkTile = ImageLoader.loadImage("/PinkTile.png");
        WhiteTile = ImageLoader.loadImage("/WhiteTile.png");
    }
}
