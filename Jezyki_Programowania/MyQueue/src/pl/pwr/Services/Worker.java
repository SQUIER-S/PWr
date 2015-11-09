package pl.pwr.Services;

import pl.pwr.Factories.MessageFactory;
import pl.pwr.Messages.Message;
import pl.pwr.Messages.Urgency;
import pl.pwr.Messages.UrgencyMessage;
import pl.pwr.queue.AbstractQueue;
import pl.pwr.queue.FIFOQueue;
import pl.pwr.queue.LIFOQueue;

import java.io.IOException;
import java.util.Random;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public class Worker {

    private SendingMessageService sms;

    public Worker(String queueType) {

        sms = new SendingMessageService(initializeQueue(queueType));

    }

    private AbstractQueue<Message> initializeQueue(String queueType) {

        AbstractQueue<Message> q;

        switch (queueType) {
            case "FIFO": {
                q = new FIFOQueue<>();
                break;
            }
            case "LIFO": {
                q = new LIFOQueue<>();
                break;
            }
            default:
                throw new IllegalArgumentException("Argument: " + queueType + ". Allowed arguments: LIFO or FIFO");
        }

        return q;
    }

    public void start() throws IOException {

        while(true) {
            System.out.println("\n\nWhat you want to do now:\n" +
                    "\t[1] - Send new message\n" +
                    "\t[2] - Receive message\n" +
                    "\t[3] - EXIT\n\n" +
                    "Messages in queue: " + sms.numberOfMessages());

            char choice = (char) System.in.read();
            System.in.read();

            if(choice == '1') {
                Urgency[] values = Urgency.values();
                try {
                    UrgencyMessage ums = sms.sendMessage(values[new Random().nextInt(values.length)]);
                    System.out.println("TITLE: " + ums.getMessage().getTitle() + "\nRECIPIENT: " +
                            ums.getMessage().getRecipient() + "\nURGENCY: " +
                            ums.getUrgency().toString() + "\nID: " +
                            ums.getMessageId() + "\n\nCONTENT: " +
                            ums.getMessage().getContent().substring(0, 50) + "...");
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            } else if(choice == '2') {
                sms.receiveMessage(MessageFactory.generateMessage());
            } else if(choice == '3') {
                System.exit(0);
            }

        }

    }

}
