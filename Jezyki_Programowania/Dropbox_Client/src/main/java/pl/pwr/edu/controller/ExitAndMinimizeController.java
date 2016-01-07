package pl.pwr.edu.controller;

import javafx.stage.Stage;
import pl.pwr.edu.view.main.ControlButtons;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class ExitAndMinimizeController {

    public ExitAndMinimizeController(ControlButtons buttons, Stage PRIMARY_STAGE) {
        buttons.getExit().setOnMouseClicked(e -> System.exit(0));
        buttons.getMinimize().setOnMouseClicked(e -> PRIMARY_STAGE.setIconified(true));
    }

}
