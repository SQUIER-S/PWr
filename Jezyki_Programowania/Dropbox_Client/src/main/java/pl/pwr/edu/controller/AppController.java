package pl.pwr.edu.controller;

import pl.pwr.edu.Chef;
import pl.pwr.edu.service.DirChooser;
import pl.pwr.edu.service.DirContent;
import pl.pwr.edu.service.Executors;
import pl.pwr.edu.service.WaitForDirContent;
import pl.pwr.edu.view.controller.FoundFilesUpdater;
import pl.pwr.edu.view.controller.MovableWindowController;
import pl.pwr.edu.view.main.AppGUI;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

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
    }

    public void updateFoundFiles(ArrayList<File> list) {
        FoundFilesUpdater.updateFoundFiles(appGUI.getFileList().getLeft(), list);
    }

    public void uploadFiles(ArrayList<File> list, HashSet<File> uploaded) {
        HashSet<File> upload = new HashSet<>();
        upload.addAll(list.stream().collect(Collectors.toList()));

        upload.removeAll(uploaded);

        if(upload.size() > 0) {
            new Executors((upload.stream().collect(Collectors.toList()))).start();
            uploaded.addAll(upload);
        }
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
                    String dir = new DirChooser(appGUI.getStage()).chooseDir();
                    chef.setDirContent(new DirContent(dir));
                    /*Another thread waits to initialize dirContent object, when it happens, thread calls appController
                        that it can start observing directory for changes*/
                    appGUI.getCurrentDirectory().setDirLabel(dir);
                } else if(chef.getDirObserver() != null) {
                    chef.getDirObserver().setObserving(false);
                    String dir = new DirChooser(appGUI.getStage()).chooseDir();
                    chef.setDirContent(new DirContent(dir));
                    appGUI.getCurrentDirectory().setDirLabel(dir);
                    observeDirectory();
                }
        });

    }
}
