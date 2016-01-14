package pl.pwr.edu.service;

import pl.pwr.edu.Chef;

/**
 * Created by SQUIER on 2016-01-14.
 */
public class WaitForDirContent implements Runnable {

    private Chef chef;

    public WaitForDirContent(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void run() {
        while(chef.getDirContent() == null) {/*wait for initialization*/}

        /*call appController*/
        chef.getAppController().observeDirectory();
    }
}
