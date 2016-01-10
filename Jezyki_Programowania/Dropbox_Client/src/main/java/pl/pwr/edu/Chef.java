package pl.pwr.edu;

import pl.pwr.edu.controller.AppController;
import pl.pwr.edu.observers.DirectoryObserver;
import pl.pwr.edu.service.DirContent;
import pl.pwr.edu.view.main.AppGUI;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by SQUIER on 2016-01-10.
 */
public class Chef {

    private AppGUI appGUI;
    private AppController appController;

    /*Managers*/
    private DirectoryObserver dirObserver;
    /*Workers*/
    private DirContent dirContent;

    public Chef(AppGUI appGUI) throws MalformedURLException {
        this.appGUI = appGUI;

        appGUI.init();
        appGUI.setStyle(new File("src/main/resources/style.css"));

        appController = new AppController(appGUI, this);
        appController.startAppController();

        Thread waitForWorker = new Thread(new WaitForDirContent());
        waitForWorker.start();

    }

    public void setDirContent(DirContent dirContent) {
        this.dirContent = dirContent;
    }

    public AppController getAppController() {
        return appController;
    }

    private void setDirObserver() {
        dirObserver = new DirectoryObserver(dirContent, this);
    }

    private class WaitForDirContent implements Runnable {

        @Override
        public void run() {
            while(dirContent == null) {/*wait for initialization*/}
            /* Start observing selected directory */
            setDirObserver();
            Thread observeDir = new Thread(dirObserver);
            observeDir.start();
        }
    }

}
