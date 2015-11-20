package pl.pwr.service;

import pl.pwr.data.Airport;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class CSVWriter {

    private int fileNumber = 0;
    private int rowsInFile = 0;

    public CSVWriter() {}

    public void createCSVFiles(HashSet<Airport> data, String fileName, int rowsPerFile) {
        String suffix = "_" + Integer.toString(rowsPerFile) + "_";
        List< List<Airport> > splitData = FileDivider.divideFileIntoParts(data, rowsPerFile);

        splitData.forEach(Collections::sort);

        splitData.stream()
                .forEach(list -> list.stream()
                        .forEach(element -> {
                            try {
                                Files.write(Paths.get(fileName + suffix + generateFileNumber(rowsPerFile) + ".csv"),
                                        (element.toString()+"\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }));


    }

    private int generateFileNumber(int rowsPerFile) {
        if(++rowsInFile % rowsPerFile == 0) return fileNumber++;
        else return fileNumber;
    }


}


