package dcman58.DcmanEngine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {

	boolean goLeft = false;
	boolean goForward = false;
	boolean goBackward = false;
	boolean goRight = false;

	public void pollInput() {
		if (Mouse.isButtonDown(0)) {
			int x = Mouse.getX();
			int y = Mouse.getY();}

		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_A)
					goLeft = true;
				if (Keyboard.getEventKey() == Keyboard.KEY_D)
					goRight = true;
				if (Keyboard.getEventKey() == Keyboard.KEY_W)
					goForward = true;
				if (Keyboard.getEventKey() == Keyboard.KEY_S)
					goBackward = true;
			}else{
				if (Keyboard.getEventKey() == Keyboard.KEY_A)
					goLeft = false;
				if (Keyboard.getEventKey() == Keyboard.KEY_D)
					goRight = false;
				if (Keyboard.getEventKey() == Keyboard.KEY_W)
					goForward = false;
				if (Keyboard.getEventKey() == Keyboard.KEY_S)
					goBackward = false;
			}
		}
	}
}
