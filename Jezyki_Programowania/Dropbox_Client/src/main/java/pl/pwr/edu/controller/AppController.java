package pl.pwr.edu.controller;

import pl.pwr.edu.Chef;
import pl.pwr.edu.service.DirChooser;
import pl.pwr.edu.service.DirContent;
import pl.pwr.edu.service.LoginToDB;
import pl.pwr.edu.service.WaitForDirContent;
import pl.pwr.edu.view.controller.FoundFilesUpdater;
import pl.pwr.edu.view.controller.MovableWindowController;
import pl.pwr.edu.view.main.AppGUI;

import java.net.MalformedURLException;
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
        initWaitThread();
        initLogInButton();
    }

    public void updateFoundFiles(ArrayList<String> list) {
        FoundFilesUpdater.updateFoundFiles(appGUI.getFileList().getLeft(), list);
    }

    public void observeDirectory() {
        chef.setDirObserver();
        chef.setObserveDir(new Thread(chef.getDirObserver()));
        chef.getObserveDir().start();
    }

    private void initWaitThread() {
        Thread waitForDirContent = new Thread(new WaitForDirContent(chef));
        waitForDirContent.start();
    }

    private void initMovableWindow() {
        new MovableWindowController(appGUI.getStage(), appGUI.getScene());
    }

    private void initControlButtons() {
        new ExitAndMinimizeController(appGUI.getControlButtons(), appGUI.getStage());
    }

    private void initDirChooser() {
        appGUI.getChooseDir().setOnMouseClicked(e -> {
                if(chef.getDirObserver() == null) {
                    chef.setDirContent(new DirContent(new DirChooser(appGUI.getStage()).chooseDir()));
                    /*Another thread waits to initialize dirContent object, when it happens, thread calls appController
                        that it can start observing directory for changes*/
                } else if(chef.getDirObserver() != null) {
                    chef.getDirObserver().setObserving(false);
                    chef.setDirContent(new DirContent(new DirChooser(appGUI.getStage()).chooseDir()));
                    observeDirectory();
                }
        });

    }

    private void initLogInButton() {
        appGUI.getLogIn().setOnMouseClicked(e -> {
            try {
                new LoginFormController(LoginToDB.getWebAuth()).startAuthorization();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        });
    }
}
