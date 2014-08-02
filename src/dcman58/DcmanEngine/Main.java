package dcman58.DcmanEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import dcman58.DcmanEngine.Graphics.DisplayManager;

public class Main implements Runnable {
	//Running Stuff
	public Thread thread;
	public boolean running = false;
	public static int width = 800, height = 600;
	public static String title = "DcEngine -- To Be Changed Later";

	//INIT STUFF
	Input input;

	public void start() {
		running = true;
		input = new Input();
		thread = new Thread(this, "Display");
		thread.start();
	}

	public void run() {
		try {
			//			Display.setDisplayMode(new DisplayMode(width, height));
			new DisplayManager().setDisplayMode(width, height, new Input().isFullscreen);
			Display.setTitle(title);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.out.println("Had Trouble Creating and/or Presenting the Display");
		}

		while (running) {
			if(new Input().isFullscreen){
				try {
					Display.setFullscreen(new Input().isFullscreen);
				} catch (LWJGLException e) {
					e.printStackTrace();
				}
			}
			
			input.pollInput();
			Display.update();
			if (Display.isCloseRequested())
				running = false;
		}
		Display.destroy();

	}

	public static void main(String[] args) {
		new Main().start();
	}

}
