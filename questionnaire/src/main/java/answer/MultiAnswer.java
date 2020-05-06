package answer;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class MultiAnswer extends Answer<String>{
	
	private List<Answer<String>> list;

	public MultiAnswer(String value) {
		super(value);
		list = new ArrayList<>();
		String[] ansTab = value.split(";");
		for(int i=0;i<ansTab.length;i++) {
			list.add(new TextAnswer(ansTab[i]));
		}
	}

	public String instruction() {
		return "("+list.size()+" possible answers) ";
	}

	public boolean accept(String value) {
		return true;
	}
	
	public boolean isCorrect(String value) {
		for(int i=0;i<this.list.size();i++) {
			if(this.list.get(i).isCorrect(value)) {
				return true;
			}
		}
		return false;
	}

}
