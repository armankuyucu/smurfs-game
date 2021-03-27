package Game.Objeler;

import Game.Assets;
import Game.Game;
import Game.GameState;
import Game.Karakterler.Oyuncu;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.GameState.AltinListesi;

public class Altin extends Obje{


    Timer timer = new Timer();

    public Altin(int deger, int olusmaSuresi, int satir, int sutun) {
        super(deger, olusmaSuresi, satir, sutun);
        update();
    }

    public void update(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int lower = 1;

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
        }, olusmaSuresi*1000, olusmaSuresi*1000);

    }

    public void render(Graphics g){

        for(int i=0;i<5;i++){
            g.drawImage(Assets.Altin, AltinListesi[i].satir *64,
                        AltinListesi[i].sutun*64,width,height,null);
        }
    }
}
