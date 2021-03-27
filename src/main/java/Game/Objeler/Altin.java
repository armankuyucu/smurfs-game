package Game.Objeler;

import Game.Assets;
import Game.States.GameState;
import Game.Karakterler.Oyuncu;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.States.GameState.AltinListesi;
import static Game.Karakterler.Puan.Skor;

public class Altin extends Obje{


    public Altin(int olusmaSuresi, int satir, int sutun,boolean used) {
        super(olusmaSuresi, satir, sutun,used);
        update();
    }

    public static void AltinCollisionDetection(){
        for(int i=0;i<5;i++){
            if((AltinListesi[i].sutun == Oyuncu.sira) && (AltinListesi[i].satir == Oyuncu.sutun) )
            {
                AltinListesi[i].used = true;
                AltinListesi[i].satir = 0;
                Skor += 5;
            }
        }
    }

    public static void RastgeleAltinOlusturma(){
        int lower = 1;
        for(int i=0;i<5;i++){
            AltinListesi[i].used = false;
        }

        //Might break the program
        while(true){
            AltinListesi[0].satir = (int)(Math.random() * (12-lower)) + lower;
            AltinListesi[0].sutun = (int)(Math.random() * (10-lower)) + lower;

            AltinListesi[1].satir = (int)(Math.random() * (12-lower)) + lower;
            AltinListesi[1].sutun = (int)(Math.random() * (10-lower)) + lower;

            AltinListesi[2].satir = (int)(Math.random() * (12-lower)) + lower;
            AltinListesi[2].sutun = (int)(Math.random() * (10-lower)) + lower;

            AltinListesi[3].satir = (int)(Math.random() * (12-lower)) + lower;
            AltinListesi[3].sutun = (int)(Math.random() * (10-lower)) + lower;

            AltinListesi[4].satir = (int)(Math.random() * (12-lower)) + lower;
            AltinListesi[4].sutun = (int)(Math.random() * (10-lower)) + lower;
            if(GameState.map[AltinListesi[0].sutun][AltinListesi[0].satir] != 0 &&
                    GameState.map[AltinListesi[1].sutun][AltinListesi[1].satir] != 0 &&
                    GameState.map[AltinListesi[2].sutun][AltinListesi[2].satir] != 0 &&
                    GameState.map[AltinListesi[3].sutun][AltinListesi[3].satir] != 0 &&
                    GameState.map[AltinListesi[4].sutun][AltinListesi[4].satir] != 0)
                break;
        }

    }

    public static void AltinSilme(){
        for(int i=0;i<5;i++){
            AltinListesi[i].used = true;
            AltinListesi[i].satir = 0;
        }
    }
    public void update(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                RastgeleAltinOlusturma();
            }
        }, olusmaSuresi*1000, olusmaSuresi*1000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                AltinSilme();
            }
        }, 5*1000, 5*1000);

    }

    public void render(Graphics g){

        for(int i=0;i<5;i++){
            if(AltinListesi[i].used == false){
                g.drawImage(Assets.Altin, AltinListesi[i].satir *64,
                        AltinListesi[i].sutun*64,width,height,null);
            }
        }
    }
}
