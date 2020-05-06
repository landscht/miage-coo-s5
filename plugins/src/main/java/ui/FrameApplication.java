package ui;

import file.FileChecker;
import listeners.MenuHelpListener;
import listeners.MenuToolListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameApplication extends JFrame {

    JTextArea jTextArea = new JTextArea();
    FileChecker fileChecker;

    public FrameApplication(FileChecker fileChecker) {
        this.fileChecker = fileChecker;
        this.setContentPane(buildWindow());
        this.pack();
        this.setJMenuBar(buildMenu());
        this.setVisible(true);
    }

    private JPanel buildWindow() {
        JPanel jPanelMain = new JPanel();
        jPanelMain.setLayout(new FlowLayout());
        jTextArea.setPreferredSize(new Dimension(1000, 500));
        jPanelMain.add(jTextArea);
        return jPanelMain;
    }

    private JMenuBar buildMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem fileOpen = new JMenuItem(new FileChooserAction("Open", jTextArea));
        JMenuItem fileNew = new JMenuItem("New");
        fileNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jTextArea.setText("");
            }
        });
        menuFile.add(fileNew);
        menuFile.add(fileOpen);
        menuBar.add(menuFile);
        MenuToolListener menuUIObserver = new MenuToolListener("Tools", jTextArea);
        MenuHelpListener menuHelpListener = new MenuHelpListener("Help");
        fileChecker.addFileListener(menuUIObserver);
        fileChecker.addFileListener(menuHelpListener);
        menuBar.add(menuUIObserver);
        menuBar.add(menuHelpListener);
        return menuBar;
    }
}
