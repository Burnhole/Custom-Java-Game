package dcman58.Engine;

import org.lwjgl.input.Keyboard;

public class Game {
	public Game() {

	}

	public void input() {
		if (Input.getMouseDown(1))
			System.out.println("We Right Clicked @ "+ Input.getMousePosition().toString());
		if (Input.getMouseUp(1))
			System.out.println("Mouse Released");
	}

	public void update() {

	}

	public void render() {

	}
}
