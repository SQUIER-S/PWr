package pl.pwr.service;

import pl.pwr.data.Airport;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class CSVCreator {

    private int fileNumber = 0;
    private int rowsInFile = 0;
    private int rowsPerFile;

    public CSVCreator() {}

    public void createCSVFiles(List<Airport> data, String fileName, int rowsPerFile) {
        String suffix = "_" + Integer.toString(rowsPerFile) + "_";
        this.rowsPerFile = rowsPerFile;
        List< List<Airport> > splitData = FileDivider.divideFileIntoParts(data, rowsPerFile);

        splitData.stream()
                .forEach(list -> list.stream()
                        .forEach(element -> {
                            try {
                                Files.write(Paths.get(fileName + suffix + generateFileNumber() + ".csv"),
                                        (element.toString()+"\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }));


    }

    private int generateFileNumber() {
        if(++rowsInFile % rowsPerFile == 0) return fileNumber++;
        else return fileNumber;
    }


}


