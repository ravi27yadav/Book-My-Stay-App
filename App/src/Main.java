/**
 * =============================================================
 * MAIN CLASS - UseCase6RoomAllocation
 * =============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        // Inventory (UC3)
        RoomInventory inventory = new RoomInventory();

        // Queue (UC5)
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Allocation service
        RoomAllocationService allocationService =
                new RoomAllocationService();

        // Process queue (FIFO)
        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            allocationService.allocateRoom(r, inventory);
        }
    }
}