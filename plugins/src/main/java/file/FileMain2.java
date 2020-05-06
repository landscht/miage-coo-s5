package file;

import javax.swing.Timer;

import filters.PluginFilter;
import listeners.FileListener;
import listeners.SimplePluginObserver;
import ui.FrameApplication;

/**
 * 
 * @author Gabriel, Tony
 * 
 * Second simulation ( EX4 Q4 )
 *
 */

public class FileMain2 {
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		FileChecker check = new FileChecker("extensions/plugins",new PluginFilter());
		FileListener listener = new SimplePluginObserver();
		check.addFileListener(listener);
		FrameApplication frame = new FrameApplication(check);
		Timer t = new Timer(1000,check);
		t.start();
		while(true);
	}

}
