package listeners;

import file.FileEvent;

public class MockListener implements FileListener{
	
	private int cptAdded=0;
	private int cptRemoved=0;

	@Override
	public void fileAdded(FileEvent e) {
		cptAdded++;
		
	}

	@Override
	public void fileRemoved(FileEvent e) {
		cptRemoved++;
	}
	
	public int getCptAdded() {
		return cptAdded;
	}
	
	public int getCptRemoved() {
		return cptRemoved;
	}

}
