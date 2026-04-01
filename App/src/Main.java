/**
 * =============================================================
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * =============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * @version 9.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Error Handling & Validation\n");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Validator
        BookingValidator validator = new BookingValidator();

        // Test cases (valid + invalid)
        Reservation r1 = new Reservation("Abhi", "Single");   // valid
        Reservation r2 = new Reservation("", "Double");       // invalid name
        Reservation r3 = new Reservation("Ravi", "Deluxe");   // invalid type

        processBooking(r1, inventory, validator);
        processBooking(r2, inventory, validator);
        processBooking(r3, inventory, validator);
    }

    /**
     * Process booking with validation
     */
    public static void processBooking(Reservation r,
                                      RoomInventory inventory,
                                      BookingValidator validator) {

        try {
            validator.validate(r, inventory);
            System.out.println("Booking valid for Guest: "
                    + r.getGuestName()
                    + ", Room Type: " + r.getRoomType());

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}