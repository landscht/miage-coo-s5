package listeners;

import file.FileEvent;

/**
 * 
 * @author Gabriel, Tony
 * 
 * Listener which notice if there is a new .class or if there is a deleted .class
 *
 */

public class DetectedListener implements FileListener{

	@Override
	public void fileAdded(FileEvent e) {
		System.out.println("Nouveau .class : "+e.getSource());
		
	}

	@Override
	public void fileRemoved(FileEvent e) {
		System.out.println(".class retiré : "+e.getSource());
		
	}

}
