package javamultithreading;
import java.util.concurrent.*;

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem ticketSystem = new TicketBookingSystem(10);

        // Creating a thread pool executor
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Runnable task to book tickets
        Runnable bookTicketsTask = () -> {
            for (int i = 1; i <= 5; i++) {
                ticketSystem.bookTickets(2, "Passenger " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Runnable task to check available tickets
        Runnable checkTicketsTask = () -> {
            for (int i = 1; i <= 3; i++) {
                ticketSystem.checkAvailableTickets();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Submitting tasks to the thread pool
        executorService.submit(bookTicketsTask);
        executorService.submit(checkTicketsTask);

        // Shutting down the executor service
        executorService.shutdown();
    }
}