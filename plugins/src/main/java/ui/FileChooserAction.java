package ui;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.*;

public class FileChooserAction extends AbstractAction {

    JTextArea jTextArea;

    public FileChooserAction(String text, JTextArea textArea) {
        super(text);
        jTextArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.dir"));
        int returnValue = jFileChooser.showOpenDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
            String txt = "";
            File fileSelected = jFileChooser.getSelectedFile();
            try {
                FileReader fileReader = new FileReader(fileSelected.getPath());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while((line = bufferedReader.readLine())!=null){
                    txt += line + "\n";
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e1){
                e1.printStackTrace();
            }
            System.out.println(fileSelected.getAbsolutePath());
            jTextArea.setText(txt);
        }
    }
}
