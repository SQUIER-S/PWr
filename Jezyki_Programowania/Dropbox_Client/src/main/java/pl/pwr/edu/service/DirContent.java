package pl.pwr.edu.service;

import com.dropbox.core.DbxEntry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by SQUIER on 2016-01-10.
 */
public class DirContent {

    private ArrayList<File> dirContent;
    private String dir;

    public DirContent(String dir) {
        this.dir = dir;
    }

    public ArrayList<File> getDirContent() {
        return dirContent;
    }

    public ArrayList<File> dirContentToArray() throws IOException {
        dirContent = new ArrayList<>();
        Files.walk(Paths.get(dir)).forEach(filePath -> {
            if(Files.isRegularFile(filePath)) {
                dirContent.add(filePath.toFile());
            }
        });

        return dirContent;
    }

}
