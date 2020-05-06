package filters;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class FileClassFilterTest {
	
	private FileClassFilter filter;
	
	@Before
	public void init() {
		filter = new FileClassFilter();
	}

	@Test
	public void acceptTest() {
		assertFalse(filter.accept(new File("resources"), "test.clas"));
		assertFalse(filter.accept(new File("resources"), "testclass"));
		assertFalse(filter.accept(new File("resources"), "test.clasS"));
		assertTrue(filter.accept(new File("resources"), "test.class"));
	}

}
