package pl.pwr.edu;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.pwr.edu.controller.AppController;
import pl.pwr.edu.view.main.AppGUI;

import java.io.File;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class DropboxClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        AppGUI appGUI = new AppGUI(stage);
        appGUI.init();
        appGUI.setStyle(new File("src/main/resources/style.css"));

        AppController appController = new AppController(appGUI);
        appController.startAppController();
    }
}
