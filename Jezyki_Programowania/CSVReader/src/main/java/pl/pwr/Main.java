package pl.pwr;

import pl.pwr.config.ConfigService;
import pl.pwr.factories.AirportFactory;
import pl.pwr.service.CSVWriter;
import pl.pwr.service.CSVLoader;
import pl.pwr.service.DuplicatesRemover;
import pl.pwr.service.ErrorFileWriter;
import pl.pwr.validators.DataValidator;

import java.io.IOException;

/**
 * Created by SQUIER on 2015-11-19.
 */
public class Main {

    private static final int PROPERTIES_FILE = 0;

    public static void main(String[] args) {

        ConfigService cf = new ConfigService(args[PROPERTIES_FILE]);

        DataValidator dataValidator = new DataValidator();
        AirportFactory airportFactory = new AirportFactory();
        CSVWriter csvWriter = new CSVWriter();
        DuplicatesRemover duplicatesRemover = new DuplicatesRemover();

        try {
            dataValidator.validateData(CSVLoader.csvFileToStringArray(cf.getProperty("pathToCSVFile")));
            airportFactory.createAirports(dataValidator.getGoodData());
            duplicatesRemover.removeDuplicates(airportFactory.getAirports());
            csvWriter.createCSVFiles(duplicatesRemover.getDifferentAirports(),
                    cf.getProperty("outputFileName"),
                    Integer.parseInt(cf.getProperty("rowsPerFile")));

            ErrorFileWriter.writeErrors(dataValidator.getBadData(), cf.getProperty("errors"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
