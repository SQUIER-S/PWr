package pl.pwr.edu.controller;

import pl.pwr.edu.Chef;
import pl.pwr.edu.service.Statistics;

/**
 * Created by SQUIER on 2016-01-21.
 */
public class StatsController implements Runnable{

    private Chef chef;

    public StatsController(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void run() {

        while (true) {

            String filesSend = "Files send:\n" + Statistics.FILES_SEND;
            String filesPerSec = "Files per second:\n" + Statistics.FILES_PER_SEC;
            String filesLastTenMinutes = "Files send in last ten minutes:\n" + Statistics.FILES_SEND_IN_TEN_MINUTES;

            chef.getAppGUI().getFileList().getRight().setText(filesSend+"\n\n"
                    + filesPerSec+"\n\n" + filesLastTenMinutes);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
