package pl.pwr.Messages;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public enum Urgency {

    URGENT(1),
    NORMAL(2),
    LOW(3);

    int urgency;

    Urgency(int urgency) {
        this.urgency = urgency;
    }

}
