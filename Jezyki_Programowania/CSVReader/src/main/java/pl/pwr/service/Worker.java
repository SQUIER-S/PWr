package pl.pwr.service;

import pl.pwr.config.ConfigService;
import pl.pwr.factories.AirportFactory;
import pl.pwr.validators.DataValidator;

import java.io.IOException;

/**
 * Created by SQUIER on 2015-11-20.
 */
public class Worker {

    private DataValidator dataValidator;
    private AirportFactory airportFactory;
    private CSVWriter csvWriter;
    private DuplicatesRemover duplicatesRemover;
    private ConfigService config;

    public Worker(ConfigService config) {
        dataValidator = new DataValidator();
        airportFactory = new AirportFactory();
        csvWriter = new CSVWriter();
        duplicatesRemover = new DuplicatesRemover();
        this.config = config;
    }

    public void start() throws IOException {
        /*Validate input data*/
        dataValidator.validateData(CSVLoader.csvFileToStringArray(config.getProperty("pathToCSVFile")));

        /*Create objects from valid data*/
        airportFactory.createAirports(dataValidator.getGoodData());

        /*Remove duplicates*/
        duplicatesRemover.removeDuplicates(airportFactory.getAirports());

        /*Write new .csv files with good data*/
        csvWriter.createCSVFiles(duplicatesRemover.getDifferentAirports(),
                config.getProperty("outputFileName"),
                Integer.parseInt(config.getProperty("rowsPerFile")));

        /*Write errors*/
        ErrorFileWriter.writeErrors(dataValidator.getBadData(), config.getProperty("errors"));

    }

}
