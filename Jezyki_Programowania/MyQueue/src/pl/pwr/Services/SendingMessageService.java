package pl.pwr.Services;

import pl.pwr.Messages.Message;
import pl.pwr.Messages.Urgency;
import pl.pwr.Messages.UrgencyMessage;
import pl.pwr.queue.AbstractQueue;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public class SendingMessageService {

    private AbstractQueue<Message> messageQueue;
    private static int MESSAGE_ID = 0;

    public SendingMessageService(AbstractQueue<Message> queue) {
        messageQueue = queue;
    }


    public void receiveMessage(Message m) {
        messageQueue.add(m);
    }

    public UrgencyMessage sendMessage(Urgency u) throws ArrayIndexOutOfBoundsException{
        return new UrgencyMessage(messageQueue.pop(), u, MESSAGE_ID++);
    }

    public int numberOfMessages() {
        return messageQueue.size();
    }

}
