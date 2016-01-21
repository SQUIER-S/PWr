package pl.pwr.edu.service;

import com.dropbox.core.DbxWriteMode;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Callable;

/**
 * Created by SQUIER on 2016-01-17.
 */
public class FileSender implements Callable<Void> {

    private File file;
    private FileInputStream fis;

    public FileSender(File toUpload) {
        file = toUpload;
    }

    @Override
    public Void call() throws Exception {

        try {
            fis = new FileInputStream(file);
            TheRockBoxClient.CLIENT.uploadFile("/" + file.getName(), DbxWriteMode.add(), file.length(), fis);

        } finally {
            fis.close();
            Statistics.FILES_SEND++;
            Statistics.FILES_SEND_IN_TEN_MINUTES++;
        }

        return null;
    }
}
