package pl.pwr.edu;

import pl.pwr.edu.controller.AppController;
import pl.pwr.edu.observers.DirectoryObserver;
import pl.pwr.edu.service.DirContent;
import pl.pwr.edu.service.WaitForDirContent;
import pl.pwr.edu.view.login.LoginForm;
import pl.pwr.edu.view.main.AppGUI;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by SQUIER on 2016-01-10.
 */
public class Chef {

    private AppGUI appGUI;
    private LoginForm loginForm = new LoginForm();
    private AppController appController;

    /*Managers*/
    private DirectoryObserver dirObserver = null;
    private Thread observeDir;
    /*Workers*/
    private DirContent dirContent;

    public Chef(AppGUI appGUI) throws MalformedURLException {
        this.appGUI = appGUI;

        appGUI.init();
        appGUI.setStyle(new File("src/main/resources/style.css"));

        appController = new AppController(appGUI, this);
        appController.startAppController();


    }

    public void setDirContent(DirContent dirContent) {
        this.dirContent = dirContent;
    }

    public DirContent getDirContent() { return dirContent; }

    public AppController getAppController() {
        return appController;
    }

    public void setDirObserver() { dirObserver = new DirectoryObserver(dirContent, this); }

    public DirectoryObserver getDirObserver() { return dirObserver; }

    public void setObserveDir(Thread thread) { observeDir = thread;}

    public Thread getObserveDir() { return observeDir; }

}
