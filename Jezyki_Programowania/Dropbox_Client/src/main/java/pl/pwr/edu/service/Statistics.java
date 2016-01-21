package pl.pwr.edu.service;

import pl.pwr.edu.observers.ProgramTime;

/**
 * Created by SQUIER on 2016-01-21.
 */
public class Statistics implements Runnable{

    public static float FILES_SEND = 0;
    public static float FILES_PER_SEC = 0;
    public static int FILES_SEND_IN_TEN_MINUTES = 0;

    private ProgramTime time = new ProgramTime();

    public Statistics() {
        Thread timer = new Thread(time);
        timer.start();
    }


    @Override
    public void run() {
        while(true) {
            if(FILES_SEND != 0) { FILES_PER_SEC = (FILES_SEND/time.getProgramSecs()); }

            if(time.getProgramSecs() >= 600) FILES_SEND_IN_TEN_MINUTES = 0;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
