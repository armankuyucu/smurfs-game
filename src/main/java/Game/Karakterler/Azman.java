package Game.Karakterler;

import Game.Game;
import Game.Assets;
import Game.States.GameState;
import Game.Tiles.Tile;
import Game.Lokasyon;

import java.awt.*;

public class Azman extends Dusman{


    public Azman(Game game, float x, float y, int satir, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, ID, Ad, Tur);
        Lokasyon.azmanSutun = sutun;
        Lokasyon.azmanSatir = satir;
        dijkstra(AdjacencyMatrix,Lokasyon.path, Lokasyon.azmanSatir *13+Lokasyon.azmanSutun,Oyuncu.sira*13+Oyuncu.sutun);
    }

    public Azman(){

    }

    @Override
    public void EnKisaYol() {
        Lokasyon.path.clear();
        dijkstra(AdjacencyMatrix, Lokasyon.path,Lokasyon.azmanSatir *13+Lokasyon.azmanSutun,Oyuncu.sira*13+Oyuncu.sutun);
        Lokasyon.path.add(Oyuncu.sira*13+Oyuncu.sutun);
        try {
            if(!(Lokasyon.path.isEmpty())) {
                Lokasyon.azmanSatir = Lokasyon.path.get(1) / 13;
                Lokasyon.azmanSutun = Lokasyon.path.get(1) % 13;
            }else{
               // System.out.println("Girdi");
                azmaniSifirla();
                dijkstra(AdjacencyMatrix, Lokasyon.path,Lokasyon.azmanSatir *13+Lokasyon.azmanSutun,Oyuncu.sira*13+Oyuncu.sutun);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for (Integer integer : Lokasyon.path) {
            System.out.print(integer + " ");
        }
        azmanCollisionDetection();
    }

    public void azmanCollisionDetection(){
        if(Lokasyon.azmanSutun == Oyuncu.sutun && Lokasyon.azmanSatir == Oyuncu.sira){
            Puan.Skor -=5;
            azmaniSifirla();
        }
    }

    public void azmaniSifirla(){
        if(GameState.dusman2[1].equals("Azman")){
            if(GameState.kapi2[1].equals("A")){
                System.out.println("Girdi");
                Lokasyon.azmanSatir = 0;
                Lokasyon.azmanSutun = 3;
            }
            else if(GameState.kapi2[1].equals("B")){
                Lokasyon.azmanSatir = 0;
                Lokasyon.azmanSutun = 10;
            }
            else if(GameState.kapi2[1].equals("C")){
                Lokasyon.azmanSatir = 5;
                Lokasyon.azmanSutun = 0;

            }
            else if(GameState.kapi2[1].equals("D")){
                Lokasyon.azmanSatir = 10;
                Lokasyon.azmanSutun = 3;
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
        if((!GameState.dusman1[1].equals("Gargamel")) && (GameState.dusman2[1].equals("Azman"))){
            for(int i=2;i<Lokasyon.path.size()-1;i++){
                g.drawImage(Assets.GreenTile,(Lokasyon.path.get(i)%13)*Tile.TILEWIDTH,(Lokasyon.path.get(i)/13)*Tile.TILEHEIGHT,null);
            }
        }
        g.drawImage(Assets.Azman,Lokasyon.azmanSutun*Tile.TILEWIDTH, Lokasyon.azmanSatir *Tile.TILEWIDTH,width,height,null);
    }
}
