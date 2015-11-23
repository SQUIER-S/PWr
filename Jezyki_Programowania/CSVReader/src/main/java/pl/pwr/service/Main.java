package pl.pwr.service;

import pl.pwr.config.ConfigService;

import java.io.IOException;

/**
 * Created by SQUIER on 2015-11-19.
 */
public class Main {

    private static final int PROPERTIES_FILE = 0;

    public static void main(String[] args) {

        ConfigService cf = new ConfigService(args[PROPERTIES_FILE]);
        Worker worker = new Worker(cf);

        try {
            worker.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
