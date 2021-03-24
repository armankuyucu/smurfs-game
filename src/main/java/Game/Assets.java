package Game;

import java.awt.image.BufferedImage;

public class Assets {
    //Characters
   public static BufferedImage GozlukluSirin;
   public static BufferedImage Sirine;
   public static BufferedImage TembelSirin;
   public static BufferedImage Gargamel;
   public static BufferedImage Azman;

    //Tiles
    public static BufferedImage GrayTile;
    public static BufferedImage BlueTile;
    public static BufferedImage PinkTileA;
    public static BufferedImage PinkTileB;
    public static BufferedImage PinkTileC;
    public static BufferedImage PinkTileD;

    public static BufferedImage WhiteTile;
    public static void init(){
        Sirine = ImageLoader.loadImage("/Sirine.png");
        GozlukluSirin = ImageLoader.loadImage("/GozlukluSirin.png");
        TembelSirin = ImageLoader.loadImage("/TembelSirin.png");
        Gargamel = ImageLoader.loadImage("/Gargamel.png");
        Azman = ImageLoader.loadImage("/Azman.png");

        GrayTile = ImageLoader.loadImage("/GrayTile.png");
        BlueTile = ImageLoader.loadImage("/BlueTile.png");
        PinkTileA = ImageLoader.loadImage("/PinkTileA.png");
        PinkTileB = ImageLoader.loadImage("/PinkTileB.png");
        PinkTileC = ImageLoader.loadImage("/PinkTileC.png");
        PinkTileD = ImageLoader.loadImage("/PinkTileD.png");

        WhiteTile = ImageLoader.loadImage("/WhiteTile.png");
    }
}
