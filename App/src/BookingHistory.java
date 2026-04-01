import java.util.*;

/**
 * =============================================================
 * CLASS - BookingHistory
 * =============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class BookingHistory {

    /** Stores confirmed reservations in order */
    private List<Reservation> bookingList;

    /** Constructor */
    public BookingHistory() {
        bookingList = new ArrayList<>();
    }

    /** Add confirmed booking */
    public void addBooking(Reservation reservation) {
        bookingList.add(reservation);
    }

    /** Get all bookings */
    public List<Reservation> getAllBookings() {
        return bookingList;
    }
}