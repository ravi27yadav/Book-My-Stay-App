import java.util.*;

/**
 * =============================================================
 * CLASS - AddOnServiceManager
 * =============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * @version 7.0
 */
public class AddOnServiceManager {

    /**
     * Key   -> Reservation ID
     * Value -> List of services
     */
    private Map<String, List<AddOnService>> servicesByReservation;

    /** Constructor */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /** Add service to reservation */
    public void addService(String reservationId, AddOnService service) {

        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    /** Calculate total cost */
    public double calculateTotalServiceCost(String reservationId) {

        List<AddOnService> services =
                servicesByReservation.getOrDefault(reservationId, new ArrayList<>());

        double total = 0;

        for (AddOnService s : services) {
            total += s.getCost();
        }

        return total;
    }
}