package Game;

import java.awt.image.BufferedImage;

public class Assets {
   public static BufferedImage Arkaplan;
    public static BufferedImage GozlukluSirin;

    public static void init(){
        Arkaplan = ImageLoader.loadImage("/Arkaplan.png");
        GozlukluSirin = ImageLoader.loadImage("/GozlukluSirin.png");
    }
}
