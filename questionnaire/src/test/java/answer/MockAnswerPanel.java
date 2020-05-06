package answer;

public class MockAnswerPanel extends AnswerPanel<String>{

	public MockAnswerPanel(String ans) {
		super(ans);
	}

	@Override
	public String getValue() {
		return "";
	}

	@Override
	public void setCorrection(boolean isCorrect) {

	}

	@Override
	public void reload() {

	}

}
