import java.io.*;
import java.util.*;

/**
 * =============================================================
 * CLASS - PersistenceService
 * =============================================================
 *
 * Use Case 12: Data Persistence & Recovery
 *
 * @version 12.0
 */
public class PersistenceService {

    private static final String FILE_NAME = "system_state.ser";

    /**
     * Save system state to file
     */
    public void saveState(RoomInventory inventory,
                          BookingHistory history) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory.getRoomAvailability());
            oos.writeObject(history.getAllBookings());

            System.out.println("System state saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }

    /**
     * Load system state from file
     */
    @SuppressWarnings("unchecked")
    public void loadState(RoomInventory inventory,
                          BookingHistory history) {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            Map<String, Integer> savedInventory =
                    (Map<String, Integer>) ois.readObject();

            List<Reservation> savedBookings =
                    (List<Reservation>) ois.readObject();

            // Restore inventory
            for (String key : savedInventory.keySet()) {
                inventory.updateAvailability(key, savedInventory.get(key));
            }

            // Restore booking history
            for (Reservation r : savedBookings) {
                history.addBooking(r);
            }

            System.out.println("System state restored successfully!");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading state: " + e.getMessage());
        }
    }
}