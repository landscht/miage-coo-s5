package file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MockFileChecker implements ActionListener{
	
	private int cptCheck = 0;
	
	public void check() {
		cptCheck++;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		check();
	}
	
	public int getCptCheck() {
		return cptCheck;
	}

}
