package Game.States;

import Game.Game;
import Game.Karakterler.*;
import Game.Objeler.Altin;
import Game.Objeler.Mantar;
import Game.Tiles.Tile;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameState extends State{
    private Oyuncu oyuncu;
    private Dusman gargamel;
    private Dusman azman;
    public static Altin[] AltinListesi = new Altin[5];
    public static Mantar mantar;

    public static int[][] map;
    public static String line1, line2;
    public static String[] column1,column2,dusman1,dusman2,kapi1,kapi2;

    public GameState(Game game){
        super(game);
        readFileIntoArray();
        //Polymorphism ornegi
        if(MenuState.ButtonID == 1){
            oyuncu = new GozlukluSirin(game,395,320, 5,6,1, "GozlukluSirin", "Oyuncu");
        }
        if(MenuState.ButtonID == 2){
            oyuncu = new TembelSirin(game,395,320, 5,6,2, "TembelSirin", "Oyuncu");
        }
        if(GameState.dusman1[1].equals("Gargamel")){
            if(GameState.kapi1[1].equals("A"))
                gargamel = new Gargamel(game, 3 * Tile.TILEWIDTH , 5, 0, 3, 0, "Gargamel", "Dusman");
            else if(GameState.kapi1[1].equals("B"))
                gargamel = new Gargamel(game,10*Tile.TILEWIDTH,5,0,10,0,"Gargamel","Dusman");
            else if(GameState.kapi1[1].equals("C"))
                gargamel = new Gargamel(game,0,5*Tile.TILEWIDTH,5,0,0,"Gargamel","Dusman");
            else if(GameState.kapi1[1].equals("D"))
                gargamel = new Gargamel(game,3*Tile.TILEWIDTH,10*Tile.TILEWIDTH+5,10,3,0,"Gargamel","Dusman");
        }
        if(GameState.dusman2[1].equals("Azman")){
            if(GameState.kapi2[1].equals("A"))
                azman = new Azman(game,3*Tile.TILEWIDTH+20,0,0,3,0,"Azman","Dusman");
            else if(GameState.kapi2[1].equals("B"))
                azman = new Azman(game,10*Tile.TILEWIDTH+20,0,0,10,0,"Azman","Dusman");
            else if(GameState.kapi2[1].equals("C"))
                azman = new Azman(game,20,5*Tile.TILEWIDTH+20,5,0,0,"Azman","Dusman");
            else if(GameState.kapi2[1].equals("D"))
                azman = new Azman(game,3*Tile.TILEWIDTH+20,10*Tile.TILEWIDTH,10,3,0,"Azman","Dusman");
        }

        mantar = new Mantar(14,-100,-100,false);
        Mantar.RastgeleMantarOlusturma();
        ilkKezAltinOlusturma();
    }

    public void ilkKezAltinOlusturma(){
        for(int i=0;i<5;i++){
            AltinListesi[i] = new Altin(10,-100,-100,false);
        }
        Altin.RastgeleAltinOlusturma();
    }

    @Override
    public void update() {
        oyuncu.update();
        if(GameState.dusman1[1].equals("Gargamel"))
            gargamel.update();
        if(GameState.dusman2[1].equals("Azman"))
            azman.update();
    }

    @Override
    public void render(Graphics g) {

        //Haritayi Cizme
        for(int y=0;y<11;y++){
            for(int x=0;x<13;x++){
                if(map[y][x] == 1){
                    //C Kapisi
                    if(y==5 && x==0){
                        Tile.tiles[5].render(g,0,5*Tile.TILEWIDTH);
                    }
                    //A Kapisi
                    else if(x==3 && y==0){
                        Tile.tiles[3].render(g,3*Tile.TILEWIDTH,0);
                    }
                    //D Kapisi
                    else if(x==3 && y==10){
                        Tile.tiles[6].render(g,3*Tile.TILEWIDTH,10*Tile.TILEWIDTH);
                    }
                    //B Kapisi
                    else if(x==10 && y==0){
                        Tile.tiles[4].render(g,10*Tile.TILEWIDTH,0);
                    }

                    //Baslangic Noktasi
                    else if(x==6 && y==5){
                        Tile.tiles[2].render(g,6*Tile.TILEWIDTH,5*Tile.TILEWIDTH);
                    }
                    //Bosluklar
                    else{
                        Tile.tiles[1].render(g,x*Tile.TILEWIDTH,y*Tile.TILEWIDTH);
                    }
                }
                else if(map[y][x] == 0){
                    Tile.tiles[0].render(g,x*Tile.TILEWIDTH,y*Tile.TILEWIDTH);
                }

            }
        }


        if(GameState.dusman1[1].equals("Gargamel"))
            gargamel.render(g);
        if(GameState.dusman2[1].equals("Azman"))
            azman.render(g);


        for(int y=0;y<11;y++){
            for(int x=0;x<13;x++) {
                g.setColor(Color.BLACK);
                g.drawLine(0,y*Tile.TILEWIDTH,832,y*Tile.TILEWIDTH); // x ekseni
                g.drawLine(x*Tile.TILEWIDTH,0,x*Tile.TILEWIDTH,704);  // y ekseni
            }
        }

        oyuncu.render(g);

        //Altinlar
        for(int i=0;i<5;i++)
            AltinListesi[i].render(g);

        //Mantar
        mantar.render(g);

        //Skor
        g.setColor(Color.RED);
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,45));
        g.drawString(String.format("Skor: %d",Puan.Skor),615,690);
    }


    //Txt dosyasini okuma
    public void readFileIntoArray() {
        map = new int[11][13];
        //Read harita.txt

        /*Hatirlamak icin notlar
        dusman1[1] ilk dusman
        dusman2[1] ikinci dusman
        kapi1[1] ilk dusmanin kapisi
        kapi2[1] ikinci dusmanin kapisi
        */

        try {
            Scanner sc = new Scanner(new File("res/harita.txt"));
            line1 = sc.nextLine();
            line2 = sc.nextLine();

            //virgullere gore ayirir
            column1 = line1.split("\\s*,\\s*",0);
            column2 = line2.split("\\s*,\\s*",0);

            //':' karakterine gore ayirir
            dusman1 = column1[0].split("\\s*:\\s*",0);
            kapi1 = column1[1].split("\\s*:\\s*",0);
            dusman2 = column2[0].split("\\s*:\\s*",0);
            kapi2 = column2[1].split("\\s*:\\s*",0);

            for(int i=0;i<11;i++){
                for(int j=0;j<13;j++){
                    map[i][j] = sc.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
