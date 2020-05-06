package plugins;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a plugin
 *
 */

public interface Plugin {
	
	/**
	 * 
	 * @param s the String that will be transformed
	 * @return the transformed String
	 */
	
	public String transform(String s) ;
	
	/**
	 * 
	 * @return label of the plugin
	 */
	
	public String getLabel() ;
	
	/**
	 * 
	 * @return the help message
	 */
	
	public String helpMessage() ;

}
