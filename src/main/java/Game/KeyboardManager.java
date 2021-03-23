package Game;
import Game.Karakterler.Karakter;
import Game.Karakterler.Oyuncu;

import java.awt.*;
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
                if(MenuState.ButtonID == 2){
                    Oyuncu.sira--;

                    if((Oyuncu.sira >= 0 && Oyuncu.sira < 11) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                        Karakter.y -= 64;
                    else
                        Oyuncu.sira++;;
                }
                else if(MenuState.ButtonID == 1){
                    siraTemp = Oyuncu.sira - 2;
                    sutunTemp = Oyuncu.sutun;
                    if(siraTemp == -1)
                        siraTemp = 0;

                    if(GameState.matrix[siraTemp][sutunTemp] == 1 && (siraTemp > 0 && sutunTemp < 11)){
                        Oyuncu.sira--;
                        if((Oyuncu.sira >= 0 && Oyuncu.sira < 11) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                            Karakter.y -= 64;
                        else
                            Oyuncu.sira++;
                        Oyuncu.sira--;
                        if((Oyuncu.sira >= 0 && Oyuncu.sira < 11) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                            Karakter.y -= 64;
                        else
                            Oyuncu.sira++;;
                    }
                }
            }

            case KeyEvent.VK_DOWN -> {
                siraTemp = Oyuncu.sira + 2;
                sutunTemp = Oyuncu.sutun;
                if(siraTemp == 11){ // Matrix out of bounds hatasini vermemesi icin
                    siraTemp = 10;
                }

                if(MenuState.ButtonID == 2){
                    Oyuncu.sira++;

                    if((Oyuncu.sira >= 0 && Oyuncu.sira < 11) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                        Karakter.y += 64;
                    else
                        Oyuncu.sira--;;
                }

                else if(MenuState.ButtonID == 1){
                    if(GameState.matrix[siraTemp][sutunTemp] == 1){
                        Oyuncu.sira++;
                        if((Oyuncu.sira >= 0 && Oyuncu.sira < 11) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                            Karakter.y += 64;
                        else
                            Oyuncu.sira--;
                        Oyuncu.sira++;
                        if((Oyuncu.sira >= 0 && Oyuncu.sira < 11) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                            Karakter.y += 64;
                        else
                            Oyuncu.sira--;;
                    }

                }

            }

            case KeyEvent.VK_LEFT -> {
                siraTemp = Oyuncu.sira;
                sutunTemp = Oyuncu.sutun-2;
                if(sutunTemp == -1){
                    sutunTemp = 0;
                }

                    if(MenuState.ButtonID == 2){
                        Oyuncu.sutun--;

                        if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                            Karakter.x -= 64;
                        else
                            Oyuncu.sutun++;
                    }

                    else if(MenuState.ButtonID == 1){
                        if(GameState.matrix[siraTemp][sutunTemp] == 1){
                            Oyuncu.sutun--;
                            if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                                Karakter.x -= 64;
                            else
                                Oyuncu.sutun++;

                            Oyuncu.sutun--;
                            if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                                Karakter.x -= 64;
                            else
                                Oyuncu.sutun++;
                        }

                    }
            }

            case KeyEvent.VK_RIGHT -> {
                siraTemp = Oyuncu.sira;
                sutunTemp = Oyuncu.sutun + 2;
                if(sutunTemp == 14 || sutunTemp == 13){
                    sutunTemp = 12;
                }

                    if(MenuState.ButtonID == 2){
                        Oyuncu.sutun++;
                        if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                            Karakter.x += 64;
                        else
                            Oyuncu.sutun--;
                    }
                    else if(MenuState.ButtonID == 1){
                        if(GameState.matrix[siraTemp][sutunTemp] == 1){
                            Oyuncu.sutun++;
                            if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                                Karakter.x += 64;
                            else
                                Oyuncu.sutun--;

                            Oyuncu.sutun++;
                            if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                                Karakter.x += 64;
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
