import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingSystem {
    private int availableSeats;
    private final Lock lock = new ReentrantLock();

    public TicketBookingSystem(int seats) {
        this.availableSeats = seats;
    }
    public boolean bookTicket(String user) {
        lock.lock();
        try {
            if (availableSeats > 0) {
                System.out.println(user + " booked a seat.");
                availableSeats--;
                return true;
            } else {
                System.out.println("No seats available for " + user);
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(4);
        Runnable booker = () -> {
            String user = Thread.currentThread().getName();
            system.bookTicket(user);
        };
        Thread user1 = new Thread(booker, "sarbajeet");
        Thread user2 = new Thread(booker, "om");
        Thread user3 = new Thread(booker, "ram");
        Thread user4 = new Thread(booker, "laxman");
        Thread user5 = new Thread(booker, "ravi");
        Thread user6 = new Thread(booker, "ayush");
        Thread user7 = new Thread(booker, "piyush");
        Thread user8 = new Thread(booker, "sharim");
        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();
        user6.start();
        user7.start();
        user8.start();





    }
}
