package pl.pwr.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class DataValidator {

    private ArrayList<String[]> goodData;
    private ArrayList<String> badData;

    public DataValidator() {
        goodData = new ArrayList<>();
        badData = new ArrayList<>();
    }

    public int validateData(List<String> airports) {

        List<String[]> validation = new ArrayList<>();


        validation.addAll(airports.stream()
                .map(airport -> airport.split(","))
                .collect(Collectors.toList()));


        goodData.addAll(
                validation.stream()
                        .filter(element -> element.length == 2)
                        .filter(element -> element[0].length() == 3)
                        .collect(Collectors.toList())
        );


        badData.addAll(
                validation.stream()
                        .filter(element -> element[0].length() != 3 || element.length != 2)
                        .collect(Collectors.toList())
                        .stream()
                        .map(element -> {

                            String newString = "";
                            for (String anElement : element) {
                                newString += anElement + ",";
                            }
                            return newString.substring(0, newString.length() - 1);
                        })
                        .collect(Collectors.toList())
        );


        return badData.size();
    }

    public ArrayList<String[]> getGoodData() {
        return goodData;
    }

    public ArrayList<String> getBadData() {
        return badData;
    }
}
