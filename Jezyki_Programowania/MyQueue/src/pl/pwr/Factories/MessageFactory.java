package pl.pwr.Factories;

import pl.pwr.Messages.Message;

import java.util.Random;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public class MessageFactory {

    private static final String[] RECIPIENTS = "Phasellus dignissim, nulla quis luctus efficitur, nulla tortor vestibulum libero, sit amet tincidunt orci diam a massa. Sed gravida, justo vitae maximus mattis, orci nunc.".split(" ");
    private static final String[] TITLES = "Proin vel orci sed turpis cursus malesuada. Nunc hendrerit dapibus tincidunt. Etiam hendrerit felis eget iaculis semper. Fusce lorem tellus.".split(" ");
    private static final String MESSAGE_CONTENT = "Sed odio erat, convallis eget vulputate eu, molestie eu turpis. Proin mattis purus urna, feugiat hendrerit quam suscipit at. Curabitur eu egestas metus. Morbi at aliquam magna, sed porta libero. Praesent eget leo non orci pharetra tempus. Vivamus a nulla non sapien aliquam blandit. Nam hendrerit, turpis vitae pulvinar fringilla, risus est tincidunt magna, id euismod velit nisi ac sem. Suspendisse ac tellus non ante mollis semper. In turpis ligula, varius ac lacus in, gravida dictum lectus.";

    public static Message generateMessage() {

        return new Message(TITLES[new Random().nextInt(TITLES.length)],
                MESSAGE_CONTENT,
                RECIPIENTS[new Random().nextInt(RECIPIENTS.length)]);

    }

}
