package pl.pwr.service;

import pl.pwr.data.Airport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class FileDivider {

    public static List<List<Airport>> divideFileIntoParts(List<Airport> data, int rowsPerFile) {

        List<List<Airport>> splitData = new ArrayList<>();

        int numOfFiles =
                (data.size() % rowsPerFile != 0) ? (data.size()/rowsPerFile) + 1 : (data.size()/rowsPerFile);

        divideData(data, rowsPerFile, splitData, numOfFiles);


        return splitData;
    }

    private static void divideData(List<Airport> data, int rowsPerFile, List<List<Airport>> splitData, int numOfFiles) {
        int begin = 0;
        int end = rowsPerFile;
        for (int i = 0; i < numOfFiles; i++) {
            splitData.add(data.subList(begin, end));
            begin = end;
            end = checkEnd(data, rowsPerFile, end);
        }
    }

    private static int checkEnd(List<Airport> data, int rowsPerFile, int end) {
        if(end + rowsPerFile < data.size()) end += rowsPerFile;
        else end = data.size();
        return end;
    }

}
