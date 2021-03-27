package Game.Objeler;

import Game.Assets;
import Game.States.GameState;
import Game.Karakterler.Oyuncu;
import Game.Karakterler.Puan;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.States.GameState.mantar;

public class Mantar extends Obje{
    Timer timer2 = new Timer();

    public Mantar(int olusmaSuresi, int satir, int sutun,boolean used) {
        super(olusmaSuresi, satir, sutun,used);
        update();
    }

    public static void RastgeleMantarOlusturma(){
        mantar.used = false;
        int lower = 1;

        //Might break the program
        while(true){
            mantar.satir = (int)(Math.random() * (12-lower)) + lower;
            mantar.sutun = (int)(Math.random() * (10-lower)) + lower;

            if(GameState.map[mantar.sutun][mantar.satir] != 0)
                break;
        }
    }

    public static void MantarCollisionDetection(){
        if((mantar.sutun == Oyuncu.sira) && (mantar.satir == Oyuncu.sutun)){
            Puan.Skor += 50;
            mantar.used = true;
            mantar.satir = 0;
        }
    }

    public static void MantarSilme(){
        mantar.used = true;
        mantar.satir = 0;
    }

    public void update(){
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                RastgeleMantarOlusturma();
            }
        }, olusmaSuresi*1000, olusmaSuresi*1000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                MantarSilme();
            }
        }, 7*1000, 7*1000);

    }

    public void render(Graphics g){
        if(mantar.used == false)
            g.drawImage(Assets.Mantar,satir*64,sutun*64,width,height,null);
    }
}
