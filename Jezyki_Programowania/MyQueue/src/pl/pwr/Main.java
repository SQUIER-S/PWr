package pl.pwr;

import pl.pwr.Services.Worker;

import java.io.IOException;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public class Main {

    private static final String QUEUE_TYPE = "FIFO";

    public static void main(String[] args) {
        try {
            new Worker(QUEUE_TYPE).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
