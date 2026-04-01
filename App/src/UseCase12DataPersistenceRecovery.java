/**
 * =============================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * =============================================================
 *
 * Use Case 12: Data Persistence & Recovery
 *
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("Data Persistence & Recovery\n");

        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();
        PersistenceService persistence = new PersistenceService();

        // 🔄 Load previous state (if exists)
        persistence.loadState(inventory, history);

        // Simulate new bookings
        history.addBooking(new Reservation("Abhi", "Single"));
        history.addBooking(new Reservation("Ravi", "Suite"));

        // Save state before exit
        persistence.saveState(inventory, history);

        System.out.println("Current bookings stored.");
    }
}