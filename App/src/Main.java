/**
 * =============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * =============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * @version 7.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        // Example reservation ID (from UC6)
        String reservationId = "Single-1";

        // Service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService spa = new AddOnService("Spa", 1000.0);

        // Add services
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);

        // Calculate cost
        double totalCost = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}