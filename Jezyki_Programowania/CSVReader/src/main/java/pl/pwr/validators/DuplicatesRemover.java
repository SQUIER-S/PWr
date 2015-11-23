package pl.pwr.validators;

import pl.pwr.data.Airport;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class DuplicatesRemover {

    private HashSet<Airport> differentAirports;

    public DuplicatesRemover() {
        differentAirports = new HashSet<>();
    }

    public HashSet<Airport> removeDuplicates(ArrayList<Airport> airports) {
        airports.forEach(airport -> differentAirports.add(airport));
        return differentAirports;
    }

    public HashSet<Airport> getDifferentAirports() {
        return differentAirports;
    }
}
