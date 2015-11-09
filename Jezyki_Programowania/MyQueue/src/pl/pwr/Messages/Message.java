package pl.pwr.Messages;

/**
 * Created by SQUIER
 * on 2015-11-08.
 */
public class Message {

    private String title;
    private String content;
    private String recipient;

    public Message() {}

    public Message(String title, String content, String recipient) {

        this.title = title;
        this.content = content;
        this.recipient = recipient;

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

}
