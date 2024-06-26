package btck.com;

import btck.com.common.Constants;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		config.setResizable(false);
		config.setTitle("Not \"Mobs, Inc\"");
		config.setWindowIcon(Files.FileType.Internal, "icon.png");
		new Lwjgl3Application(new MyGdxGame(), config);
	}
}
