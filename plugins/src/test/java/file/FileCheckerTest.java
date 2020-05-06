package file;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import filters.MockFilter;
import listeners.MockListener;

public class FileCheckerTest {
	
	private FileChecker checker;
	
	@Before
	public void init() {
		checker = new FileChecker("resources", new MockFilter());
	}

	@Test
	public void addListenerTest() {
		int nbListenersBefore = checker.getListeners().size();
		checker.addFileListener(new MockListener());
		assertEquals(nbListenersBefore+1, checker.getListeners().size());
	}
	
	@Test
	public void removeListenerTest() {
		MockListener listener = new MockListener();
		checker.addFileListener(listener);
		int nbListenersBefore = checker.getListeners().size();
		checker.removeFileListener(listener);
		assertEquals(nbListenersBefore-1, checker.getListeners().size());
	}
	
	@Test
	public void fireFileAddedTest() {
		MockListener listener = new MockListener();
		checker.addFileListener(listener);
		Random r = new Random();
		int nb = r.nextInt(5)+1;
		for(int i=0;i<nb;i++) {
			checker.fireFileAdded("test");
		}
		assertEquals(listener.getCptAdded(),nb);
	}
	
	@Test
	public void fireFileRemovedTest() {
		MockListener listener = new MockListener();
		checker.addFileListener(listener);
		Random r = new Random();
		int nb = r.nextInt(5)+1;
		for(int i=0;i<nb;i++) {
			checker.fireFileRemoved("test");
		}
		assertEquals(listener.getCptRemoved(),nb);
	}
	
	@Test
	public void checkTest() {
		MockFileChecker mockChecker = new MockFileChecker();
		int nbCalledCheck = mockChecker.getCptCheck();
		mockChecker.check();
		assertEquals(nbCalledCheck+1,mockChecker.getCptCheck());
	}

}
