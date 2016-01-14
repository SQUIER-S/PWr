package pl.pwr.edu;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.pwr.edu.view.login.LoginForm;
import pl.pwr.edu.view.main.AppGUI;


/**
 * Created by SQUIER on 2016-01-07.
 */
public class DropboxClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new Chef(new AppGUI(stage));
        new LoginForm();
    }


}
