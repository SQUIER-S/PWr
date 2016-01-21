package pl.pwr.edu.view.controller;

import pl.pwr.edu.Chef;
import pl.pwr.edu.service.ListAlgorithms;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-01-21.
 */
public class View {

    /**
     * Updates view depending on arrays, and send information about states of those arrays
     * @param files pre data
     * @param dirFiles  new data
     * @param chef chef
     * @return 0 if no pre data; -1 if new data is different than pre data; 1 if equal
     */
    public static int updateView(ArrayList<File> files, ArrayList<File> dirFiles, Chef chef) {
        if(files == null) {
            chef.getAppController().updateFoundFiles(dirFiles);
            return 0;
        } else if(!ListAlgorithms.compareLists(files, dirFiles)) {
            chef.getAppController().updateFoundFiles(dirFiles);
            return -1;
        }
        return 1;
    }

}
