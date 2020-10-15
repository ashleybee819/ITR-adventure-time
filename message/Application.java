import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Message> messages = new ArrayList<Message>();

        Chat chat1 = new Chat("sender 1", "recipient 1");
        Arrival arrival1 = new Arrival("sender 2", "recipient 2");
        Message message1 = new Message("sender 3", "recipient 3");

        messages.add(chat1);
        messages.add(arrival1);
        messages.add(message1);

        for (Message m : messages) {
            if (m instanceof Chat) {
                Chat c = (Chat)m;
                c.chat("Some text", ZonedDateTime.now());
            } else if (m instanceof Arrival) {
                ((Arrival) m).arrive("Some place", ZonedDateTime.now());
            } else {
                m.send();
            }
        }
    }
}
