package Game;
import Game.Karakterler.Karakter;
import Game.Karakterler.Oyuncu;

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
        switch (keyCode) {
            case KeyEvent.VK_UP -> {
                Oyuncu.sira--;

                if((Oyuncu.sira >= 0 && Oyuncu.sira < 11) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                    Karakter.y -= 64;
                else
                    Oyuncu.sira++;;
            }
            case KeyEvent.VK_DOWN -> {
                Oyuncu.sira++;

                if((Oyuncu.sira >= 0 && Oyuncu.sira < 11) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                    Karakter.y += 64;
                else
                    Oyuncu.sira--;;
            }
            case KeyEvent.VK_LEFT -> {
                Oyuncu.sutun--;

                if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                    Karakter.x -= 64;
                else
                    Oyuncu.sutun++;
            }
            case KeyEvent.VK_RIGHT -> {
                Oyuncu.sutun++;
                if((Oyuncu.sutun >=0 && Oyuncu.sutun < 13) && GameState.matrix[Oyuncu.sira][Oyuncu.sutun] == 1)
                    Karakter.x += 64;
                else
                    Oyuncu.sutun--;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
