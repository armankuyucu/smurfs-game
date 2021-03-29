package Game.Karakterler;

import Game.Game;
import Game.Assets;
import Game.States.GameState;
import Game.Tiles.Tile;

import java.awt.*;

public class Azman extends Dusman{

    public static int azmanSatir,azmanSutun;
    public boolean ilkKez = false;
    int azmanSayac = 0;

    public Azman(Game game, float x, float y, int sira, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, ID, Ad, Tur);
        azmanSutun = sutun;
        azmanSatir = sira;
        dijkstra(AdjacencyMatrix, azmanSatir *13+azmanSutun,Oyuncu.sira*13+Oyuncu.sutun);
    }

    public Azman(){

    }

    @Override
    public void EnKisaYol() {
        path.clear();
        dijkstra(AdjacencyMatrix, azmanSatir *13+azmanSutun,Oyuncu.sira*13+Oyuncu.sutun);
        path.add(Oyuncu.sira*13+Oyuncu.sutun);
        try {
            if(!(path.isEmpty())) {
                azmanSatir = path.get(1) / 13;
                azmanSutun = path.get(1) % 13;
            }else{
               // System.out.println("Girdi");
                azmaniSifirla();
                dijkstra(AdjacencyMatrix, azmanSatir *13+azmanSutun,Oyuncu.sira*13+Oyuncu.sutun);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for (Integer integer : path) {
            System.out.print(integer + " ");
        }
        azmanCollisionDetection();
    }

    public void azmanCollisionDetection(){
        if(azmanSutun == Oyuncu.sutun && azmanSatir == Oyuncu.sira){
            Puan.Skor -=5;
            azmaniSifirla();
        }
    }

    public void azmaniSifirla(){
        if(GameState.dusman2[1].equals("Azman")){
            if(GameState.kapi2[1].equals("A")){
                System.out.println("Girdi");
                azmanSatir = 0;
                azmanSutun = 3;
            }
            else if(GameState.kapi2[1].equals("B")){
                azmanSatir = 0;
                azmanSutun = 10;
            }
            else if(GameState.kapi2[1].equals("C")){
                azmanSatir = 5;
                azmanSutun = 0;

            }
            else if(GameState.kapi2[1].equals("D")){
                azmanSatir = 11;
                azmanSutun = 3;
            }
        }

    }

    @Override
    public void update() {
        if(pressed){
            EnKisaYol();
            pressed = false;
        }
    }

    @Override
    public void render(Graphics g) {
        for(int i=1;i<path.size();i++){
            g.drawImage(Assets.GreenTile,(path.get(i)%13)*Tile.TILEWIDTH,(path.get(i)/13)*Tile.TILEHEIGHT,null);
        }

        g.drawImage(Assets.Azman,azmanSutun*Tile.TILEWIDTH, azmanSatir *Tile.TILEWIDTH,width,height,null);
    }
}
