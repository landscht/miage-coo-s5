package filters;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import plugins.Plugin;

/**
 * 
 * @author Gabriel, Tony
 *
 * This class represents the plugin filter
 */

public class PluginFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".class")){
			name=name.substring(0,name.length()-6);
			try {
				Class<?> c = Class.forName("plugins."+name);
				Constructor<?> constructor = c.getConstructor();
				if(Plugin.class.isAssignableFrom(c)){
					return true;
				}
			} catch (ClassNotFoundException e) {
				return false;
			} catch (NoSuchMethodException e) {
				return false;
			}
		}
		return false;
			
	}

}
