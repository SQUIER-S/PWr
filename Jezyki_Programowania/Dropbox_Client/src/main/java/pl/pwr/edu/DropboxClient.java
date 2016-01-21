package pl.pwr.edu;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.pwr.edu.controller.StatsController;
import pl.pwr.edu.service.Statistics;
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

        Thread statController = new Thread(new StatsController(new Chef(new AppGUI(stage))));
        statController.start();
        Thread stats = new Thread(new Statistics());
        stats.start();
    }


}
