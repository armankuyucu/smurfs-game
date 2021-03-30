package Game.Karakterler;

import Game.Game;
import Game.Assets;
import Game.States.GameState;
import Game.Tiles.Tile;
import Game.Lokasyon;

import java.awt.*;

public class Gargamel extends Dusman{


    public Gargamel(Game game, float x, float y, int satir, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, ID, Ad, Tur);
        Lokasyon.gargamelSatir = satir;
        Lokasyon.gargamelSutun = sutun;
        dijkstra(AdjacencyMatrix, Lokasyon.path2,Lokasyon.gargamelSatir *13+Lokasyon.gargamelSutun,Oyuncu.satir *13+Oyuncu.sutun);
    }

    public Gargamel(){

    }

    @Override
    public void EnKisaYol() {
        Lokasyon.path2.clear();
        dijkstra(AdjacencyMatrix, Lokasyon.path2,Lokasyon.gargamelSatir *13+Lokasyon.gargamelSutun,Oyuncu.satir *13+Oyuncu.sutun);
        Lokasyon.path2.add(Oyuncu.satir *13+Oyuncu.sutun);
        try {
            if(!(Lokasyon.path2.isEmpty())) {
                if(Lokasyon.path2.size() == 2){
                    Lokasyon.gargamelSatir = Lokasyon.path2.get(1) / 13;
                    Lokasyon.gargamelSutun = Lokasyon.path2.get(1) % 13;
                }else{
                    Lokasyon.gargamelSatir = Lokasyon.path2.get(2) / 13;
                    Lokasyon.gargamelSutun = Lokasyon.path2.get(2) % 13;
                }
            }
            else{
                gargameliSifirla();
                dijkstra(AdjacencyMatrix, Lokasyon.path2,Lokasyon.gargamelSatir *13+ Lokasyon.gargamelSutun,Oyuncu.satir *13+Oyuncu.sutun);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        gargamelCollisionDetection();
    }

    public void gargamelCollisionDetection(){
        if(Lokasyon.gargamelSutun == Oyuncu.sutun && Lokasyon.gargamelSatir == Oyuncu.satir){
            Puan.Skor -=15;
            gargameliSifirla();
        }
    }

    public void gargameliSifirla(){
        if(GameState.dusman1[1].equals("Gargamel")){
            if(GameState.kapi1[1].equals("A")){
                Lokasyon.gargamelSatir = 0;
                Lokasyon.gargamelSutun = 3;
            }
            else if(GameState.kapi1[1].equals("B")){
                Lokasyon.gargamelSatir = 0;
                Lokasyon.gargamelSutun = 10;
            }
            else if(GameState.kapi1[1].equals("C")){
                Lokasyon.gargamelSatir = 5;
                Lokasyon.gargamelSutun = 0;

            }
            else if(GameState.kapi1[1].equals("D")){
                Lokasyon.gargamelSatir = 10;
                Lokasyon.gargamelSutun = 3;
            }
        }

    }

    @Override
    public void update() {
        if(pressed2){
            EnKisaYol();
            pressed2 = false;
        }
    }

    @Override
    public void render(Graphics g) {
        if(GameState.dusman1[1].equals("Gargamel") && GameState.dusman2[1].equals("Azman")){
            for(int i=2;i<Lokasyon.path.size()-1;i++){
                g.drawImage(Assets.GreenTile,(Lokasyon.path.get(i)%13)*Tile.TILEWIDTH,(Lokasyon.path.get(i)/13)*Tile.TILEHEIGHT,null);
            }

            for(int i = 2; i< Lokasyon.path2.size()-1; i++){
                g.drawImage(Assets.RedTile,(Lokasyon.path2.get(i)%13)* Tile.TILEWIDTH,(Lokasyon.path2.get(i)/13)*Tile.TILEHEIGHT,null);
            }

            g.drawImage(Assets.Gargamel,Lokasyon.gargamelSutun*Tile.TILEWIDTH, Lokasyon.gargamelSatir *Tile.TILEWIDTH,width,height,null);
        }
        else if(GameState.dusman1[1].equals("Gargamel")){
            for(int i = 2; i< Lokasyon.path2.size()-1; i++){
                g.drawImage(Assets.RedTile,(Lokasyon.path2.get(i)%13)* Tile.TILEWIDTH,(Lokasyon.path2.get(i)/13)*Tile.TILEHEIGHT,null);
            }

            g.drawImage(Assets.Gargamel,Lokasyon.gargamelSutun*Tile.TILEWIDTH, Lokasyon.gargamelSatir *Tile.TILEWIDTH,width,height,null);
        }

    }

}
