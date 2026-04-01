/**
 * =============================================================
 * MAIN CLASS - UseCase11ConcurrentBookingSimulation
 * =============================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * @version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation\n");

        // Shared resources
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();
        RoomAllocationService allocationService =
                new RoomAllocationService();

        // Add booking requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Ravi", "Single"));
        queue.addRequest(new Reservation("Kiran", "Suite"));
        queue.addRequest(new Reservation("Meena", "Suite"));

        // Create threads
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(queue, inventory, allocationService));

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(queue, inventory, allocationService));

        Thread t3 = new Thread(
                new ConcurrentBookingProcessor(queue, inventory, allocationService));

        // Start threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll bookings processed safely!");
    }
}