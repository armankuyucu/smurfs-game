package Game;
import Karakterler.Karakter;
import com.sun.security.auth.module.Krb5LoginModule;

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
            case KeyEvent.VK_UP -> Karakter.y -= 90;
            case KeyEvent.VK_DOWN -> Karakter.y += 90;
            case KeyEvent.VK_LEFT -> Karakter.x -= 90;
            case KeyEvent.VK_RIGHT -> Karakter.x += 90;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
