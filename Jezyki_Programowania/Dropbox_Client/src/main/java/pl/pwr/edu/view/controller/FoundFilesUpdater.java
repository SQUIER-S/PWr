package pl.pwr.edu.view.controller;

import javafx.scene.control.TextArea;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by SQUIER on 2016-01-10.
 */
public class FoundFilesUpdater {

    public static void updateFoundFiles(TextArea textArea, ArrayList<File> list) {
        textArea.setText("");
        list.forEach(element -> textArea.appendText(element.getName()+"\n"));

        textArea.setEditable(true);
        textArea.deletePreviousChar();
        textArea.positionCaret(0);
        textArea.setEditable(false);

    }

}
