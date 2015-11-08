package pl.pwr.Messages;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public class UrgencyMessage {

    private Message message;
    private Urgency urgency;
    private int messageId;

    public UrgencyMessage(Message m, Urgency u, int mId) {
        message = m;
        urgency = u;
        messageId = mId;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public Message getMessage() {
        return message;
    }

    public int getMessageId() {
        return messageId;
    }




}
