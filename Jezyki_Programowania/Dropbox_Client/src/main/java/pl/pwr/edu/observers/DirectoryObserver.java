package pl.pwr.edu.observers;

import pl.pwr.edu.Chef;
import pl.pwr.edu.service.DirContent;
import pl.pwr.edu.service.ListAlgorithms;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class DirectoryObserver implements Runnable {

    private ArrayList<String> files;

    /*Gets the directory content*/
    private DirContent dirContent;

    /*Communicating with Chef class*/
    private Chef chef;

    /*rather to stop observing*/
    private boolean observing = true;

    public DirectoryObserver(DirContent dirContent, Chef chef) {
        this.dirContent = dirContent;
        this.chef = chef;
    }

    public void setObserving(boolean value) { observing = value; }

    @Override
    public void run() {
        while (observing) {
            ArrayList<String> dirFiles = null;
            /* getting dir content */
            try {
                dirFiles = dirContent.dirContentToArray();
            } catch (IOException e) {
                e.printStackTrace();
            }

            updateView(dirFiles);

            /*get a rest*/
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateView(ArrayList<String> dirFiles) {
        if(files == null) {
            files = dirFiles;
            chef.getAppController().updateFoundFiles(dirFiles);
        } else if(!ListAlgorithms.compareLists(files, dirFiles)) {
            chef.getAppController().updateFoundFiles(dirFiles);
            files = dirFiles;
        }
    }
}
