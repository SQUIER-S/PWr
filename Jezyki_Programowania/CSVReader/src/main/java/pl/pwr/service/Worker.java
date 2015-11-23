package pl.pwr.service;

import pl.pwr.config.ConfigService;
import pl.pwr.data.AirportFactory;
import pl.pwr.files.CSVWriter;
import pl.pwr.files.ErrorFileWriter;
import pl.pwr.files.FileReader;
import pl.pwr.validators.DataValidator;
import pl.pwr.validators.DuplicatesRemover;

import java.io.IOException;

import static pl.pwr.config.Keys.*;

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
        dataValidator.validateData(FileReader.fileToStringArray(config.getProperty(PATH_TO_FILE)));

        /*Create objects from valid data*/
        airportFactory.createAirports(dataValidator.getGoodData());

        /*Remove duplicates*/
        duplicatesRemover.removeDuplicates(airportFactory.getAirports());

        /*Write new .csv files with good data*/
        csvWriter.createCSVFiles(duplicatesRemover.getDifferentAirports(),
                config.getProperty(OUTPUT_FILENAME),
                Integer.parseInt(config.getProperty(ROWS_PER_FILE)));

        /*Write errors*/
        ErrorFileWriter.writeErrors(dataValidator.getBadData(), config.getProperty(ERRORS_FILENAME));

    }

}
