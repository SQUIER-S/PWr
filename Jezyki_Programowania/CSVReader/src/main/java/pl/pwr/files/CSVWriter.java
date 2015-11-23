package pl.pwr.files;

import pl.pwr.data.Airport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class CSVWriter {

    private int fileNumber = 1;
    private int rowsInFile = 0;
    private int linesToWrite;
    private int numberOfFiles = 0;
    private boolean last = false;

    public CSVWriter() {}

    public void createCSVFiles(HashSet<Airport> data, String fileName, int rowsPerFile) {


        List<Airport> listData = data.stream().collect(Collectors.toList());

        Collections.sort(listData);

        linesToWrite = listData.size();
        numberOfFiles =
                (listData.size() % rowsPerFile != 0) ? (listData.size()/rowsPerFile) + 1 : (listData.size()/rowsPerFile);

        listData.forEach(element -> {
            try {
                Files.write(Paths.get(fileName + generateSuffix(rowsPerFile)),
                        (element.toString()+"\n").getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private String generateSuffix(int rowsPerFile) {

        if(linesToWrite <= rowsPerFile && !last) {
            return "_" + linesToWrite + "_1.csv";

        } else if(rowsInFile == rowsPerFile && !last) {
            fileNumber++;
            rowsInFile = 1;
            if(numberOfFiles == fileNumber) {
                last = true;
                return "_" + (linesToWrite - (fileNumber-1)*rowsPerFile) + "_" + fileNumber + ".csv";
            }
            return "_" + rowsPerFile + "_" + fileNumber + ".csv";

        } else if (rowsInFile < rowsPerFile && !last) {
            rowsInFile++;
            return "_" + rowsPerFile + "_" + fileNumber + ".csv";

        }
        return "_" + (linesToWrite - (fileNumber-1)*rowsPerFile) + "_" + fileNumber + ".csv";
    }

}


