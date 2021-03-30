package Game;

import java.awt.event.*;

public class KeyboardManager implements KeyListener{

    public KeyboardManager() {

    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        int siraTemp;
        int sutunTemp;
        switch (keyCode) {

            case KeyEvent.VK_UP -> {
                Dusman.pressed = true;
                Gargamel.pressed2 = true;

                if(MenuState.ButtonID == 2){
                    Oyuncu.satir--;

                    if((Oyuncu.satir >= 0 && Oyuncu.satir < 11) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                        Oyuncu.y -= 64;
                    else
                        Oyuncu.satir++;
                }
                else if(MenuState.ButtonID == 1){
                    siraTemp = Oyuncu.satir - 2;
                    sutunTemp = Oyuncu.sutun;
                    if(siraTemp == -1)
                        siraTemp = 0;

                    if(GameState.map[siraTemp][sutunTemp] == 1 && (siraTemp > 0 && sutunTemp < 11)){
                        Oyuncu.satir--;
                        if((Oyuncu.satir >= 0 && Oyuncu.satir < 11) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                            Oyuncu.y -= 64;
                        else
                            Oyuncu.satir++;

                        Altin.AltinCollisionDetection();
                        Mantar.MantarCollisionDetection();

                        Oyuncu.satir--;
                        if((Oyuncu.satir >= 0 && Oyuncu.satir < 11) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                            Oyuncu.y -= 64;
                        else
                            Oyuncu.satir++;
                    }
                }
            }

            case KeyEvent.VK_DOWN -> {
                Dusman.pressed = true;
                Gargamel.pressed2 = true;

                siraTemp = Oyuncu.satir + 2;
                sutunTemp = Oyuncu.sutun;
                if(siraTemp == 11){ // Matrix out of bounds hatasini vermemesi icin
                    siraTemp = 10;
                }

                if(MenuState.ButtonID == 2){
                    Oyuncu.satir++;

                    if((Oyuncu.satir >= 0 && Oyuncu.satir < 11) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                        Oyuncu.y += 64;
                    else
                        Oyuncu.satir--;
                }

                else if(MenuState.ButtonID == 1){
                    if(GameState.map[siraTemp][sutunTemp] == 1){
                        Oyuncu.satir++;
                        if((Oyuncu.satir >= 0 && Oyuncu.satir < 11) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                            Oyuncu.y += 64;
                        else
                            Oyuncu.satir--;

                        Altin.AltinCollisionDetection();
                        Mantar.MantarCollisionDetection();

                        Oyuncu.satir++;
                        if((Oyuncu.satir >= 0 && Oyuncu.satir < 11) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                            Oyuncu.y += 64;
                        else
                            Oyuncu.satir--;
                    }

                }

            }

            case KeyEvent.VK_LEFT -> {
                Dusman.pressed = true;
                Gargamel.pressed2 = true;

                siraTemp = Oyuncu.satir;
                sutunTemp = Oyuncu.sutun-2;
                if(sutunTemp == -1){
                    sutunTemp = 0;
                }

                    if(MenuState.ButtonID == 2){
                        Oyuncu.sutun--;

                        if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                            Oyuncu.x -= 64;
                        else
                            Oyuncu.sutun++;
                    }

                    else if(MenuState.ButtonID == 1){
                        if(GameState.map[siraTemp][sutunTemp] == 1){
                            Oyuncu.sutun--;
                            if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                                Oyuncu.x -= 64;
                            else
                                Oyuncu.sutun++;

                            Altin.AltinCollisionDetection();
                            Mantar.MantarCollisionDetection();

                            Oyuncu.sutun--;
                            if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                                Oyuncu.x -= 64;
                            else
                                Oyuncu.sutun++;
                        }

                    }
            }

            case KeyEvent.VK_RIGHT -> {
                Dusman.pressed = true;
                Gargamel.pressed2 = true;

                siraTemp = Oyuncu.satir;
                sutunTemp = Oyuncu.sutun + 2;
                if(sutunTemp == 14 || sutunTemp == 13){
                    sutunTemp = 12;
                }

                    if(MenuState.ButtonID == 2){
                        Oyuncu.sutun++;
                        if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                            Oyuncu.x += 64;
                        else
                            Oyuncu.sutun--;
                    }
                    else if(MenuState.ButtonID == 1){
                        if(GameState.map[siraTemp][sutunTemp] == 1){
                            Oyuncu.sutun++;
                            if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                                Oyuncu.x += 64;
                            else
                                Oyuncu.sutun--;

                            Altin.AltinCollisionDetection();
                            Mantar.MantarCollisionDetection();

                            Oyuncu.sutun++;
                            if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.map[Oyuncu.satir][Oyuncu.sutun] == 1)
                                Oyuncu.x += 64;
                            else
                                Oyuncu.sutun--;
                        }
                    }

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}