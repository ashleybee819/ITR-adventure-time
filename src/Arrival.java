import java.time.ZonedDateTime;

public class Arrival extends Message {
    public String location;
    public ZonedDateTime arrivalTime;

    public Arrival(String sender, String recipient) {
        super(sender, recipient);
    }

    public void arrive(String location, ZonedDateTime arrivalTime) {
        this.location = location;
        this.arrivalTime = arrivalTime;
        this.send();
    }

    @Override
    public void send() {
        System.out.println("arrived at " + this.location);
    }
}
