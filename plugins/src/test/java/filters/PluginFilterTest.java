package filters;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class PluginFilterTest {
	
	private PluginFilter filter;
	
	@Before
	public void init(){
		this.filter = new PluginFilter();
	}

	@Test
	public void acceptTest() {
		assertFalse(filter.accept(new File("extensions/plugins"), "test.class"));
		assertFalse(filter.accept(new File("extensions/plugins"), "MockListener.class"));
		assertFalse(filter.accept(new File("extensions/plugins"), "RemoveVowelsPlugi.class"));
		assertTrue(filter.accept(new File("extensions/plugins"), "RemoveVowelsPlugin.class"));
		assertTrue(filter.accept(new File("extensions/plugins"), "ToUpperCasePlugin.class"));
	}
}
