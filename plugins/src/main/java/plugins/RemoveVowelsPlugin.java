package plugins;

/**
 * 
 * @author Gabriel, Tony
 *
 * This class represents a plugin which removes all the vowels of a String
 */

public class RemoveVowelsPlugin implements Plugin{
	
	public String label;
	
	public RemoveVowelsPlugin(){
		label = "removeVowels";
	}

	@Override
	public String transform(String s) {
		return s.replaceAll("[a|e|i|o|u|y|A|E|I|O|U|Y]", "");
		/*String res = "";
		
		for(int i=0;i<s.length();i++){
			if(!s.charAt(i).isVowels()){
				res+=s.charAt(i);
			}
		}
		return res;*/
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String helpMessage() {
		return "Remove all the vowels of the text";	
	}
}
