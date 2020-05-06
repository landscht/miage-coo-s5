package main;

import java.io.IOException;
import javax.swing.*;
import questionnaire.Questionnaire;
import questionnaire.QuestionnaireFactory;

public class Main {
	public static void main(String[] args) throws IOException {

		Questionnaire questionnaire = QuestionnaireFactory.getInstance().createQuestionnaire("src/main/resources/questions/gotquizz.txt");

		// INTERFACE
		WindowQuestionnaire windowQuestionnaire = new WindowQuestionnaire(questionnaire);

		// TEXTUEL
		questionnaire.askAll();
	}
}
