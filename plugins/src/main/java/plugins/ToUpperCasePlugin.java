package plugins;

/**
 * 
 * @author Gabriel, Tony
 *
 * This class represents a plugin which puts all the letters in capital
 */

public class ToUpperCasePlugin implements Plugin{
	
	public String label;
	
	public ToUpperCasePlugin() {
		label = "toUpperCase";
	}

	@Override
	public String transform(String s) {
		return s.toUpperCase();
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String helpMessage() {
		return "This plugin puts to upper case the all text";
	}

}
