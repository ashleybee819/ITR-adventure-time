import java.time.ZonedDateTime;

public class Chat extends Message {
    public String text;
    public ZonedDateTime chatTime;

    public Chat(String sender, String recipient) {
        super(sender, recipient);
    }

    public void chat(String text, ZonedDateTime chatTime) {
        this.text = text;
        this.chatTime = chatTime;
        this.send();
    }

    @Override
    public void send() {
        System.out.println("sending " + this.text);
    }
}
