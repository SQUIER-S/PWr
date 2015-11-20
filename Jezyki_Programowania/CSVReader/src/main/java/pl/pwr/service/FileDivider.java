package pl.pwr.service;

import pl.pwr.data.Airport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class FileDivider {

    public static List<List<Airport>> divideFileIntoParts(HashSet<Airport> rawData, int rowsPerFile) {

        List<List<Airport>> splitData = new ArrayList<>();

        List<Airport> data = rawData.stream().collect(Collectors.toList());

        int numOfFiles =
                (data.size() % rowsPerFile != 0) ? (data.size()/rowsPerFile) + 1 : (data.size()/rowsPerFile);

        int begin = 0;
        int end = rowsPerFile;
        for (int i = 0; i < numOfFiles; i++) {
            splitData.add(data.subList(begin, end));
            begin = end;
            end = checkEnd(data, rowsPerFile, end);
        }

        return splitData;

    }

    private static int checkEnd(List<Airport> data, int rowsPerFile, int end) {
        if(end + rowsPerFile < data.size()) end += rowsPerFile;
        else end = data.size();
        return end;
    }

}
