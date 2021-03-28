package Game.Karakterler;

import Game.Game;
import Game.Assets;
import Game.States.GameState;
import Game.Tiles.Tile;

import java.awt.*;

public class Azman extends Dusman{

    public static int azmanSira,azmanSutun;
    public boolean ilkKez = false;
    int azmanSayac = 0;

    public Azman(Game game, float x, float y, int sira, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, ID, Ad, Tur);
        System.out.println("sira: " + sira);
        azmanSutun = sutun;
        azmanSira = sira;
        EnKisaYol();
        System.out.println("Azmansira: " + azmanSira);
        System.out.println("AzmanSutun: " + azmanSutun);
    }

    public Azman(){

    }

    @Override
    public void EnKisaYol() {

        dijkstra(AdjacencyMatrix,azmanSira*13+azmanSutun,Oyuncu.sira*13+Oyuncu.sutun);
        for (Integer integer : path) {
            System.out.print(integer + " ");
        }
            System.out.println("path 0 " + path.get(0));
            azmanSira = path.get(0)/13;
            azmanSutun = path.get(0) % 13;
            /*
            if(path.get(1) - path.get(0) == 1 && (GameState.map[azmanSira][azmanSutun+1] == 1)){
                azmanSutun++;
                System.out.println("sutun++");
            }
            if(path.get(1) - path.get(0) == -1 && (GameState.map[azmanSira][azmanSutun-1] == 1)){
                azmanSutun--;
                System.out.println("sutun--");
            }
            else if(path.get(1) - path.get(0) == 13  && (GameState.map[azmanSira+1][azmanSutun] == 1)){
                azmanSira++;
                System.out.println("sira++");
            }
            else if(path.get(1) - path.get(0) == -13 && (GameState.map[azmanSira-1][azmanSutun] == 1)){
                azmanSira--;
                System.out.println("sira--");
            }
            else{
                System.out.println("Hicbiri " + (path.get(1)-path.get(0)) + " ");
            }*/


        azmanSayac = 1;

        path.clear();

    }

    @Override
    public void update() {
        if(pressed){
            pressed = false;
            EnKisaYol();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Azman,azmanSutun*Tile.TILEWIDTH,azmanSira*Tile.TILEWIDTH,width,height,null);
    }
}
