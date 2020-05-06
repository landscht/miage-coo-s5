package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ToUpperCasePluginTest {
	
	private ToUpperCasePlugin plugin;

	@Before
	public void init() {
		this.plugin=new ToUpperCasePlugin();
	}
	
	@Test
	public void transformTest() {
		String msg = "bonjour monsieur ca va ?";
		assertEquals(plugin.transform(msg),msg.toUpperCase());
	}
	
	@Test
	public void getLabelTest() {
		assertEquals(plugin.getLabel(),"toUpperCase");
	}

}
