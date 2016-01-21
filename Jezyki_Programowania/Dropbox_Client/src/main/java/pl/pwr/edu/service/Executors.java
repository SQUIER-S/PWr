package pl.pwr.edu.service;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by SQUIER on 2016-01-17.
 */
public class Executors {

    private ExecutorService executors = java.util.concurrent.Executors.newFixedThreadPool(10);
    private List<File> files;

    public Executors(List<File> files) {
        this.files = files;
    }

    public void start() {
        if (files.size() > 0) {
            for (File file : files) {
                executors.submit(new FileSender(file));
            }
        }
    }
}
