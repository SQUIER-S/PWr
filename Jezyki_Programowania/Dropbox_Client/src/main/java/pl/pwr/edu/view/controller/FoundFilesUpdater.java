package pl.pwr.edu.view.controller;

import javafx.scene.control.TextArea;

import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-01-10.
 */
public class FoundFilesUpdater {

    public static void updateFoundFiles(TextArea textArea, ArrayList<String> list) {
        textArea.setText("");
        list.forEach(element -> textArea.appendText(element+"\n"));

        textArea.setEditable(true);
        textArea.deletePreviousChar();
        textArea.positionCaret(0);
        textArea.setEditable(false);

    }

}
