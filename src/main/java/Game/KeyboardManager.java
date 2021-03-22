package Game;
import Game.Karakterler.Karakter;

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
            case KeyEvent.VK_UP -> Karakter.y -= 64;
            case KeyEvent.VK_DOWN -> Karakter.y += 64;
            case KeyEvent.VK_LEFT -> Karakter.x -= 64;
            case KeyEvent.VK_RIGHT -> Karakter.x += 64;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
