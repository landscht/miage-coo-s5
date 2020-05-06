package filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents the ".class" filter 
 *
 */

public class FileClassFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".class"))
			return true;
		return false;
	}

}
