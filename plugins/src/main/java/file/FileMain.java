package file;

import javax.swing.Timer;

import filters.FileClassFilter;
import listeners.DetectedListener;
import listeners.FileListener;

/**
 * 
 * @author Gabriel, Tony
 * 
 * First simulation ( EX3 Q6 )
 *
 */

public class FileMain {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		FileChecker check = new FileChecker("resources", new FileClassFilter());
		FileListener listener = new DetectedListener();
		check.addFileListener(listener);
		Timer t = new Timer(1000,check);
		t.start();
		while(true);
	}
}
