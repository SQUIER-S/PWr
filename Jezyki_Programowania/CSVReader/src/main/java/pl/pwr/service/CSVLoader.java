package pl.pwr.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER on 2015-11-19.
 */
public class CSVLoader {

    public static List<String> csvFileToStringArray(String pathToFile) throws IOException {

        return Files.lines(Paths.get(pathToFile)).collect(Collectors.toList());

    }

}
