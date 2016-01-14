package pl.pwr.edu.view.main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class AppGUI {

    private Stage stage;
    private Scene scene;
    private VBox main;

    private ControlButtons controlButtons;
    private CurrentDirectory currentDirectory;
    private MultipleTextArea fileList;
    private Button chooseDir;
    private Button logIn;

    public AppGUI(Stage stage) {
        this.stage = stage;
    }

    public void init() {
        main = new VBox();
        main.setPadding(new Insets(15));
        scene = new Scene(main, 400, 300);

        controlButtons = new ControlButtons();

        currentDirectory = new CurrentDirectory();
        currentDirectory.setDirLabel("Log in to your dropbox account");
        currentDirectory.getDirLabel().setStyle("-fx-font-size: 18px");

        fileList = new MultipleTextArea("Files found", "Statistics");
        fileList.initMultipleTextArea();

        chooseDir = new Button("Choose directory");
        chooseDir.setDisable(true);
        logIn = new Button("Log In");

        HBox buttons = new HBox(215);
        buttons.getChildren().addAll(chooseDir, logIn);

        main.getChildren().addAll(controlButtons.getControlButtons(), currentDirectory.getDirLabel(),
                fileList.getMultipleTextArea(), buttons);
        VBox.setMargin(controlButtons.getControlButtons(), new Insets(-15, -15, 0, 0));
        VBox.setMargin(fileList.getMultipleTextArea(), new Insets(15, 25, 25, 25));

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public void setStyle(File cssFile) throws MalformedURLException {
        scene.getStylesheets().clear();
        scene.getStylesheets().add(cssFile.toURI().toURL().toExternalForm());
    }

    public VBox getMain() {
        return main;
    }

    public ControlButtons getControlButtons() {
        return controlButtons;
    }

    public Button getChooseDir() {
        return chooseDir;
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }

    public MultipleTextArea getFileList() {
        return fileList;
    }

    public CurrentDirectory getCurrentDirectory() {
        return currentDirectory;
    }

    public Button getLogIn() { return logIn; }
}
