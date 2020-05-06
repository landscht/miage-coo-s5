package file;

import java.util.EventObject;

/**
 * 
 * @author Gabriel, Tony
 *
 */

public class FileEvent extends EventObject{
	
	/**
	 * 
	 * @param source the source of the event
	 */

	public FileEvent(String source) {
		super(source);
	}

}
