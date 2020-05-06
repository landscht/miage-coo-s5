package listeners;

import java.util.EventListener;

import file.FileEvent;

/**
 * 
 * @author Gabriel, Tony
 *
 */

public interface FileListener extends EventListener{
	
	/**
	 * The action when there is a new file
	 * 
	 * @param e the event
	 */
	
	public void fileAdded(FileEvent e);
	
	/**
	 * The action when there is a deleted file
	 * 
	 * @param e the event
	 */
	
	public void fileRemoved(FileEvent e);

}
