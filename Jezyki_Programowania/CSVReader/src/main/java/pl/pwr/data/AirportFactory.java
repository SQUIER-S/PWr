package pl.pwr.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class AirportFactory {

    private ArrayList<Airport> airports;

    public AirportFactory() {
        airports = new ArrayList<>();
    }

    public ArrayList<Airport> createAirports(List<String[]> rawData) {

        airports.addAll(rawData.stream()
                .map(element -> new Airport(element[0], element[1]))
                .collect(Collectors.toList()));

        return airports;
    }

    public ArrayList<Airport> getAirports() {
        return airports;
    }
}
