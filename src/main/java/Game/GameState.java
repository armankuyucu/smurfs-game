package Game;

import Game.Karakterler.GozlukluSirin;
import Game.Karakterler.Oyuncu;
import Game.Karakterler.TembelSirin;
import Game.Tiles.Tile;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameState extends State{
    private Oyuncu oyuncu;
    public static int[][] matrix;

    public GameState(Game game){
        super(game);
        //oyuncu = new GozlukluSirin(game,395,320, 0, "GozlukluSirin", "Oyuncu");
        oyuncu = new TembelSirin(game,390,315, 5,6,1, "TembelSirin", "Oyuncu");
        readFileIntoArray();
    }

    @Override
    public void update() {
        oyuncu.update();
    }

    @Override
    public void render(Graphics g) {
        //Haritayi Cizme
        for(int y=0;y<11;y++){
            for(int x=0;x<13;x++){
                if(matrix[y][x] == 1){
                    //Kapilar
                    if(y==5 && x==0 || x==3 && y==0 || x==3 && y==10 || x==10 && y==0){
                        Tile.tiles[2].render(g,0,5*Tile.TILEWIDTH);
                        Tile.tiles[2].render(g,3*Tile.TILEWIDTH,0);
                        Tile.tiles[2].render(g,3*Tile.TILEWIDTH,10*Tile.TILEWIDTH);
                        Tile.tiles[2].render(g,10*Tile.TILEWIDTH,0);
                    }
                    //Baslangic Noktasi
                    else if(x==6 && y==5){
                        Tile.tiles[3].render(g,6*Tile.TILEWIDTH,5*Tile.TILEWIDTH);
                    }
                    //Bosluklar
                    else{
                        Tile.tiles[1].render(g,x*Tile.TILEWIDTH,y*Tile.TILEWIDTH);
                    }
                }
                else if(matrix[y][x] == 0){
                    Tile.tiles[0].render(g,x*Tile.TILEWIDTH,y*Tile.TILEWIDTH);
                }
                g.setColor(Color.BLACK);
                g.drawLine(0,y*Tile.TILEWIDTH,832,y*Tile.TILEWIDTH); // x ekseni
                g.drawLine(x*Tile.TILEWIDTH,0,x*Tile.TILEWIDTH,704);  // y ekseni
            }
        }
        oyuncu.render(g);
    }
    //Txt dosyasindan 2D diziye aktarma
    public void readFileIntoArray() {
        matrix = new int[11][13];

        try {
            Scanner sc = new Scanner(new File("res/harita.txt"));
            sc.nextLine();
            sc.nextLine();
            for(int i=0;i<11;i++){
                for(int j=0;j<13;j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
