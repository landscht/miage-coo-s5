package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RemoveVowelsPluginTest {

	private RemoveVowelsPlugin plugin;

	@Before
	public void init() {
		this.plugin=new RemoveVowelsPlugin();
	}
	
	@Test
	public void transformTest() {
		String msg = "bonjour monsieur ca va ?";
		assertEquals(plugin.transform(msg),"bnjr mnsr c v ?");
		assertEquals(plugin.transform(msg),msg.replaceAll("[a|e|i|o|u|y|A|E|I|O|U|Y]", ""));
	}
	
	@Test
	public void getLabelTest() {
		assertEquals(plugin.getLabel(),"removeVowels");
	}

}
