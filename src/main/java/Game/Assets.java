package Game;

import java.awt.image.BufferedImage;

public class Assets {
   public static BufferedImage GozlukluSirin;
   public static BufferedImage Sirine;
   public static BufferedImage TembelSirin;
    public static void init(){
        Sirine = ImageLoader.loadImage("/Sirine.png");
        GozlukluSirin = ImageLoader.loadImage("/GozlukluSirin.png");
        TembelSirin = ImageLoader.loadImage("/TembelSirin.png");
    }
}
