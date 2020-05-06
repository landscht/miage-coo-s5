package listeners;

import file.FileEvent;
import plugins.Plugin;
import plugins.PluginFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuToolListener extends JMenu implements FileListener {

    private List<JMenuItem> jMenuItemList = new ArrayList<>();
    private JTextArea jTextArea;

    public MenuToolListener(String nom, JTextArea jTextArea) {
        super(nom);
        this.jTextArea = jTextArea;
    }

    @Override
    public void fileAdded(FileEvent e) {
        String name = e.getSource().toString().substring(0, e.getSource().toString().length()-6);
        final Plugin plugin = PluginFactory.getInstance().buildPlugin("plugins."+name);
        JMenuItem jMenuItem = new JMenuItem(plugin.getLabel());
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jTextArea.setText(plugin.transform(jTextArea.getText()));
            }
        });
        jMenuItemList.add(jMenuItem);
        for(JMenuItem j : this.jMenuItemList) {
            this.add(j);
        }
    }

    @Override
    public void fileRemoved(FileEvent e) {
        String name = e.getSource().toString().substring(0, e.getSource().toString().length()-6);
        final Plugin plugin = PluginFactory.getInstance().buildPlugin("plugins."+name);
        int i = 0;
        for(JMenuItem j : jMenuItemList) {
            if(j.getText().equals(plugin.getLabel())) {
                jMenuItemList.remove(i);
                this.remove(i);
                break;
            }
            i++;
        }
    }
}
