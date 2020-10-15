import java.time.ZonedDateTime;

public class Message {
    public String sender;
    public String recipient;
    public ZonedDateTime createTime;

    public Message() {}

    public Message(String sender, String recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.createTime = ZonedDateTime.now();
    }

    public void send() {
        System.out.println("Sending...");
    }
}