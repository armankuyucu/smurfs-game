package Game.Karakterler;

import Game.Game;
import Game.Assets;
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
        if(azmanSayac != 0){
            if(path.get(1) - path.get(0) == 1){
                azmanSutun++;
                System.out.println("sutun++");
            }
            else if(path.get(1) - path.get(0) == -1){
                azmanSutun--;
                System.out.println("sutun--");
            }
            else if(path.get(1) - path.get(0) == 13){
                azmanSira++;
                System.out.println("sira++");
            }
            else if(path.get(1) - path.get(0) == -13){
                azmanSira--;
                System.out.println("sira--");
            }
        }

        dijkstra(AdjacencyMatrix,azmanSira*13+azmanSutun,Oyuncu.sira*13+Oyuncu.sutun);
        for(int i : path){
            System.out.print(i + " ");
        }

        azmanSayac = 1;

        path.remove(0);

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

    }
}
