/**
 * =============================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * =============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Booking History & Report\n");

        // Booking history
        BookingHistory history = new BookingHistory();

        // Simulate confirmed bookings (from UC6)
        history.addBooking(new Reservation("Abhi", "Single"));
        history.addBooking(new Reservation("Subha", "Single"));
        history.addBooking(new Reservation("Vanmathi", "Suite"));

        // Report service
        BookingReportService reportService = new BookingReportService();

        // Display bookings
        reportService.displayAllBookings(history);

        // Generate summary
        reportService.generateSummaryReport(history);
    }
}