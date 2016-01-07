package pl.pwr.edu.controller;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class DirChooser {

    private DirectoryChooser chooser;
    private Stage ownerWindow;

    public DirChooser(Stage stage) {
        chooser = new DirectoryChooser();
        ownerWindow = stage;
    }

    public String chooseDir() {
        File chosenDir = chooser.showDialog(ownerWindow);
        return chosenDir != null ? chosenDir.getAbsolutePath() : null;
    }

}
