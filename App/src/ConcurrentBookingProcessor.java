/**
 * =============================================================
 * CLASS - ConcurrentBookingProcessor
 * =============================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * @version 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue queue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue queue,
                                      RoomInventory inventory,
                                      RoomAllocationService allocationService) {
        this.queue = queue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            // 🔒 Critical section (Queue access)
            synchronized (queue) {
                if (!queue.hasPendingRequests()) {
                    break;
                }
                reservation = queue.getNextRequest();
            }

            // 🔒 Critical section (Allocation + Inventory)
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}