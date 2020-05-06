package answer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * This class is a factory design pattern to easily create Answer panel object
 */
public class AnswerPanelFactory {

    private static AnswerPanelFactory answerPanelFactory = null;

    private AnswerPanelFactory() {}

    /**
     *
     * Singleton design pattern
     *
     * @return the single instance of the AnswerPanelFactory
     */
    public static AnswerPanelFactory getInstance() {
        if(answerPanelFactory == null)
            answerPanelFactory = new AnswerPanelFactory();
        return answerPanelFactory;
    }

    /**
     *
     * @param ansClassName the name of the answer class
     * @param ansText the value of the answer
     * @return an instance of answer with the right type and the value of the answer
     */
    public AnswerPanel<?> buildAnswerPanel(String ansClassName, String ansText) {
        AnswerPanel<?> ans = null;
        try {
            Class<?> c = Class.forName(ansClassName+"Panel");
            Constructor<?> constructor = c.getConstructor(String.class);
            ans = (AnswerPanel<?>)constructor.newInstance(ansText);
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
