package plugins;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Gabriel, Tony
 *
 * This class is a factory design pattern to easily create plugin Object
 *
 */

public class PluginFactory {

    private static PluginFactory plugin = null;

    private PluginFactory() {}

    /**
     * Singleton design pattern
     *
     * @return the only instance of the factory
     */

    public static PluginFactory getInstance() {
        if(plugin == null)
            plugin = new PluginFactory();
        return plugin;
    }

    /**
     *
     * @param plugName the name of the plugin class
     * @return an instance of plugin with the right type and the value of the plugin
     */

    public Plugin buildPlugin(String plugName) {
        Plugin plug = null;
        try {
            Class<?> c = Class.forName(plugName);
            Constructor<?> constructor = c.getConstructor();
            plug = (Plugin)constructor.newInstance();
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
        return plug;

    }

}
