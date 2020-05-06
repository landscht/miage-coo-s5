package filters;

import java.io.File;
import java.io.FilenameFilter;

public class MockFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		return false;
	}

}
