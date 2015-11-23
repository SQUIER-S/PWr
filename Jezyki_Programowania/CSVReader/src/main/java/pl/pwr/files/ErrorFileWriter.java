package pl.pwr.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class ErrorFileWriter {

    public static void writeErrors(ArrayList<String> errors, String fileName) {

        errors.forEach(error -> {
            try {
                Files.write(Paths.get(fileName), (error+"\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
