package pl.pwr.edu.controller;

import pl.pwr.edu.view.controller.MovableWindowController;
import pl.pwr.edu.view.main.AppGUI;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class AppController {

    private AppGUI appGUI;

    public AppController(AppGUI appGUI){
        this.appGUI = appGUI;
    }

    public void startAppController() {
        initMovableWindow();
        initControlButtons();
        initDirChooser();
    }

    private void initMovableWindow() {
        new MovableWindowController(appGUI.getStage(), appGUI.getScene());
    }

    private void initControlButtons() {
        new ExitAndMinimizeController(appGUI.getControlButtons(), appGUI.getStage());
    }

    private void initDirChooser() {
        appGUI.getChooseDir().setOnMouseClicked(e -> new DirChooser(appGUI.getStage()).chooseDir());
    }
}
