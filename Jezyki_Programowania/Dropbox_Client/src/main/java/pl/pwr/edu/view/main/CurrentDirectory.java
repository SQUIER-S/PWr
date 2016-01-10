package pl.pwr.edu.view.main;

import javafx.scene.control.Label;

/**
 * Created by SQUIER on 2016-01-10.
 */
public class CurrentDirectory {

    private String dirPath;
    private Label dirLabel;

    public CurrentDirectory() {
        dirLabel = new Label();
    }

    public void setDirLabel(String dirPath) {
        this.dirPath = dirPath;
        dirLabel.setText(this.dirPath);
    }

    public String getDirPath() {
        return dirPath;
    }

    public Label getDirLabel() {
        return dirLabel;
    }
}
