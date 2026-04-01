/**
 * =============================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * =============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation & Rollback\n");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Cancellation service
        CancellationService cancellationService = new CancellationService();

        // Simulate confirmed bookings (from UC6)
        String r1 = "Single-1";
        String r2 = "Single-2";
        String r3 = "Suite-1";

        // Register active bookings
        cancellationService.registerReservation(r1);
        cancellationService.registerReservation(r2);
        cancellationService.registerReservation(r3);

        // Cancel bookings
        cancellationService.cancelReservation(r2, inventory);
        cancellationService.cancelReservation(r1, inventory);

        // Try invalid cancellation
        cancellationService.cancelReservation("Double-5", inventory);

        // Show rollback history
        cancellationService.showCancelledHistory();
    }
}