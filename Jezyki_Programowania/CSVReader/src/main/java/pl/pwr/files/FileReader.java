package pl.pwr.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by SQUIER on 2015-11-19.
 */
public class FileReader {

    public static List<String> fileToStringArray(String pathToFile) throws IOException {

        //return Files.lines(Paths.get(pathToFile)).collect(Collectors.toList());
        return Files.readAllLines(Paths.get(pathToFile));
    }

}
