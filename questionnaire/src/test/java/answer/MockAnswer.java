package answer;
import static org.junit.Assert.*;

public class MockAnswer extends Answer<String>{
	
	private int nbCalledIsCorrect=0;

	public MockAnswer(String value) {
		super(value);
	}

	@Override
	public String instruction() {
		return "";
	}

	@Override
	public boolean accept(String value) {
		return true;
	}
	
	public int getNbCalledIsCorrect(){
		return nbCalledIsCorrect;
	}
	
	public boolean isCorrect(String value){
		nbCalledIsCorrect++;
		return true;
	}

}
