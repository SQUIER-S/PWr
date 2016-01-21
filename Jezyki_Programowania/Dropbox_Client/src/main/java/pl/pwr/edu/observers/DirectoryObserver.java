package pl.pwr.edu.observers;

import pl.pwr.edu.Chef;
import pl.pwr.edu.service.DirContent;
import pl.pwr.edu.service.Executors;
import pl.pwr.edu.view.controller.View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Created by SQUIER on 2016-01-07.
 */
public class DirectoryObserver implements Runnable {

    private ArrayList<File> files;
    private HashSet<File> uploaded;

    /*Gets the directory content*/
    private DirContent dirContent;

    /*Communicating with Chef class*/
    private Chef chef;

    /*rather to stop observing*/
    private boolean observing = true;

    public DirectoryObserver(DirContent dirContent, Chef chef) {
        this.dirContent = dirContent;
        this.chef = chef;
        files = new ArrayList<>();
        uploaded = new HashSet<>();
    }

    public void setObserving(boolean value) { observing = value; }

    @Override
    public void run() {
        while (observing) {
            ArrayList<File> dirFiles = new ArrayList<>();
            /* getting dir content */
            try {
                dirFiles = dirContent.dirContentToArray();
            } catch (IOException e) {
                e.printStackTrace();
            }

            /* This is ugly!! */
            if (View.updateView(files, dirFiles, chef) != 1) {
                files.clear();
                files.addAll(dirFiles.stream().collect(Collectors.toList()));
            }

            chef.getAppController().uploadFiles(dirFiles, uploaded);

            /* no need to check for files more frequently */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
