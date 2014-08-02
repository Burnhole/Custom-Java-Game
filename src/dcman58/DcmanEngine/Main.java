package dcman58.DcmanEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main implements Runnable {
	
	//Resolution Stuff
	boolean isFullscreen = false;
	
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
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.setFullscreen(isFullscreen);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.out.println("Had Trouble Creating and/or Presenting the Display");
		}

		while (running) {
			input.pollInput();
			Display.update();
			if (Display.isCloseRequested())
				running = false;
		}
		Display.destroy();

	}
	
	public void ObtainDisplayRatio() throws LWJGLException{
		DisplayMode[] modes = Display.getAvailableDisplayModes();

		for (int i=0;i<modes.length;i++) {
		    DisplayMode current = modes[i];
		    System.out.println(current.getWidth() + "x" + current.getHeight() + "x" +
		                        current.getBitsPerPixel() + " " + current.getFrequency() + "Hz");
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}

}
