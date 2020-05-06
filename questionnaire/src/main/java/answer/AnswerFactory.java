package answer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class is a factory design pattern to easily create Answer Object 
 *
 */

public class AnswerFactory {

	private static final String MULTIANSWER_SEPARATOR = ";";
    private static AnswerFactory answerFactory = null;

    private AnswerFactory() {}
    
    /**
     * Singleton design pattern
     * 
     * @return the only instance of the factory
     */

    public static AnswerFactory getInstance() {
        if(answerFactory == null)
            answerFactory = new AnswerFactory();
        return answerFactory;
    }
    
    /**
     * 
     * @param ansClassName the name of the answer class
     * @param ansText the value of the answer
     * @return an instance of answer with the right type and the value of the answer
     */

	public Answer<?> buildAnswer(String ansClassName, String ansText) {
		Answer<?> ans = null;
		try {
			Class<?> c = Class.forName(ansClassName);
			Constructor<?> constructor = c.getConstructor(String.class);
			ans = (Answer<?>)constructor.newInstance(ansText);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return ans;
		
	}

}
