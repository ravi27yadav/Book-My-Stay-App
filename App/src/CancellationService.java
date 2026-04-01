import java.util.*;

/**
 * =============================================================
 * CLASS - CancellationService
 * =============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * @version 10.0
 */
public class CancellationService {

    /** Stack to track released room IDs (LIFO rollback) */
    private Stack<String> cancelledRoomStack;

    /** Track active reservations */
    private Set<String> activeReservations;

    /** Constructor */
    public CancellationService() {
        cancelledRoomStack = new Stack<>();
        activeReservations = new HashSet<>();
    }

    /** Register confirmed booking */
    public void registerReservation(String reservationId) {
        activeReservations.add(reservationId);
    }

    /**
     * Cancel booking and rollback inventory
     */
    public void cancelReservation(String reservationId,
                                  RoomInventory inventory) {

        // Validate reservation exists
        if (!activeReservations.contains(reservationId)) {
            System.out.println("Cancellation failed: Invalid reservation ID "
                    + reservationId);
            return;
        }

        // Extract room type (Single-1 → Single)
        String roomType = reservationId.split("-")[0];

        // Push to stack (rollback tracking)
        cancelledRoomStack.push(reservationId);

        // Restore inventory
        Map<String, Integer> availability = inventory.getRoomAvailability();
        inventory.updateAvailability(roomType,
                availability.get(roomType) + 1);

        // Remove from active reservations
        activeReservations.remove(reservationId);

        System.out.println("Booking cancelled: " + reservationId);
    }

    /** Show rollback stack */
    public void showCancelledHistory() {
        System.out.println("\nCancelled Room IDs (LIFO Order): " + cancelledRoomStack);
    }
}