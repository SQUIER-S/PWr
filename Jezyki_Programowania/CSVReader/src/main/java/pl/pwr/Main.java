package pl.pwr;

import pl.pwr.config.ConfigService;
import pl.pwr.factories.AirportFactory;
import pl.pwr.service.CSVCreator;
import pl.pwr.service.CSVLoader;
import pl.pwr.validators.DataValidator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by SQUIER on 2015-11-19.
 */
public class Main {

    private static final int PROPERTIES_FILE = 0;

    public static void main(String[] args) {

        ConfigService cf = new ConfigService(args[PROPERTIES_FILE]);

        DataValidator dataValidator = new DataValidator();
        AirportFactory airportFactory = new AirportFactory();

        try {
            dataValidator.validateData(CSVLoader.csvFileToStringArray(cf.getProperty("pathToCSVFile")));
            airportFactory.createAirports(dataValidator.getGoodData());
            CSVCreator csvCreator = new CSVCreator();
            csvCreator.createCSVFiles(airportFactory.getAirports(),
                    cf.getProperty("outputFileName"),
                    Integer.parseInt(cf.getProperty("rowsPerFile")));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
