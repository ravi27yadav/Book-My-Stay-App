import java.util.*;

/**
 * =============================================================
 * CLASS - BookingReportService
 * =============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class BookingReportService {

    /** Display all bookings */
    public void displayAllBookings(BookingHistory history) {

        System.out.println("Booking History:");

        for (Reservation r : history.getAllBookings()) {
            System.out.println("Guest: " + r.getGuestName()
                    + ", Room Type: " + r.getRoomType());
        }
    }

    /** Generate summary report */
    public void generateSummaryReport(BookingHistory history) {

        Map<String, Integer> summary = new HashMap<>();

        for (Reservation r : history.getAllBookings()) {
            String type = r.getRoomType();
            summary.put(type, summary.getOrDefault(type, 0) + 1);
        }

        System.out.println("\nBooking Summary:");

        for (String type : summary.keySet()) {
            System.out.println(type + " Rooms Booked: " + summary.get(type));
        }
    }
}