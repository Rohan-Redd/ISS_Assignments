package javamultithreading;

class TicketBookingSystem {
    private int availableTickets;
    private volatile boolean bookingEnabled;

    public TicketBookingSystem(int totalTickets) {
        this.availableTickets = totalTickets;
        this.bookingEnabled = true;
    }

    // Thread-safe method for checking and booking tickets
    public synchronized void bookTickets(int numTickets, String passengerName) {
        if (bookingEnabled && numTickets > 0 && numTickets <= availableTickets) {
            System.out.println(passengerName + " booked " + numTickets + " tickets.");
            availableTickets -= numTickets;
        } else {
            System.out.println("Sorry, " + passengerName + ". Tickets not available.");
        }
    }

    // Thread-safe block for enabling/disabling booking
    public void toggleBookingStatus() {
        synchronized (this) {
            bookingEnabled = !bookingEnabled;
            System.out.println("Booking is now " + (bookingEnabled ? "enabled" : "disabled"));
        }
    }

    // Thread-safe method for checking available tickets
    public synchronized void checkAvailableTickets() {
        System.out.println("Available tickets: " + availableTickets);
    }
}