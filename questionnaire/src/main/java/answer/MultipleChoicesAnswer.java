package answer;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextArea;

public class MultipleChoicesAnswer extends Answer<String>{
	
	private List<Answer<String>> list;

	public MultipleChoicesAnswer(String value) {
		super((value.split("/"))[0]);
		list = new ArrayList<>();
		String[] ansTab = value.split("/");
		for(int i=0;i<ansTab.length;i++) {
			list.add(new TextAnswer(ansTab[i]));
		}
	}

	@Override
	public String instruction() {
		Collections.shuffle(list);
		String s = "(";
		for(int i=0;i<list.size();i++){
			s+=list.get(i).getValue()+" ";
		}
		s=s.substring(0,s.length()-1)+") ";
		return s;
	}

	@Override
	public boolean accept(String value) {
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getValue());
			if(list.get(i).getValue().equalsIgnoreCase(value)){
				return true;
			}
		}
		return false;
	}

}
