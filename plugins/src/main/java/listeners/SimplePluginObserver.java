package listeners;

import file.FileEvent;

/**
 * 
 * @author Gabriel, Tony
 * 
 * Listener which notice if there is a new plugin or if there is a deleted plugin
 *
 */

public class SimplePluginObserver implements FileListener{

	@Override
	public void fileAdded(FileEvent e) {
		System.out.println("Plugin ajouté : "+e.getSource());
		
	}

	@Override
	public void fileRemoved(FileEvent e) {
		System.out.println("Plugin supprimé : "+e.getSource());
		
	}

}
