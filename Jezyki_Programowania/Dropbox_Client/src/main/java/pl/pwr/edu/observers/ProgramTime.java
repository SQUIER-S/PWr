package pl.pwr.edu.observers;

/**
 * Created by SQUIER on 2016-01-21.
 */
public class ProgramTime implements Runnable{

    private float programSecs = 0;

    public float getProgramSecs() {
        return programSecs;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(500);
                programSecs += 1/2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
