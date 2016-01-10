package pl.pwr.edu.controller;

import pl.pwr.edu.Chef;
import pl.pwr.edu.observers.DirectoryObserver;
import pl.pwr.edu.service.DirContent;
import pl.pwr.edu.view.controller.FoundFilesUpdater;
import pl.pwr.edu.view.controller.MovableWindowController;
import pl.pwr.edu.view.main.AppGUI;

import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class AppController {

    private AppGUI appGUI;
    private Chef chef;

    public AppController(AppGUI appGUI, Chef chef){
        this.appGUI = appGUI;
        this.chef = chef;
    }

    public void startAppController() {
        initMovableWindow();
        initControlButtons();
        initDirChooser();
    }

    public void updateFoundFiles(ArrayList<String> list) {
        FoundFilesUpdater.updateFoundFiles(appGUI.getFileList().getLeft(), list);
    }

    private void initMovableWindow() {
        new MovableWindowController(appGUI.getStage(), appGUI.getScene());
    }

    private void initControlButtons() {
        new ExitAndMinimizeController(appGUI.getControlButtons(), appGUI.getStage());
    }

    private void initDirChooser() {
        appGUI.getChooseDir().setOnMouseClicked(e -> {
                chef.setDirContent(new DirContent(new DirChooser(appGUI.getStage()).chooseDir()));
        });

    }
}
