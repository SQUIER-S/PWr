package pl.pwr.edu.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-01-10.
 */
public class DirContent {

    private ArrayList<String> dirContent;
    private String dir;

    public DirContent(String dir) {
        this.dir = dir;
    }

    public ArrayList<String> getDirContent() {
        return dirContent;
    }

    public ArrayList<String> dirContentToArray() throws IOException {
        dirContent = new ArrayList<>();
        Files.walk(Paths.get(dir)).forEach(filePath -> {
            if(Files.isRegularFile(filePath)) {
                dirContent.add(filePath.getFileName().toString());
            }
        });

        return dirContent;
    }

}
