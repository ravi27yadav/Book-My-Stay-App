import java.util.*;

/**
 * =============================================================
 * CLASS - RoomAllocationService
 * =============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */
public class RoomAllocationService {

    /** Stores all allocated room IDs */
    private Set<String> allocatedRoomIds;

    /** Stores assigned room IDs by room type */
    private Map<String, Set<String>> assignedRoomsByType;

    /** Constructor */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Allocates room and confirms booking
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check availability
        if (availability.get(roomType) > 0) {

            // Generate unique room ID
            String roomId = generateRoomId(roomType);

            // Store globally (no duplicates)
            allocatedRoomIds.add(roomId);

            // Store per type
            assignedRoomsByType
                    .computeIfAbsent(roomType, k -> new HashSet<>())
                    .add(roomId);

            // Update inventory
            inventory.updateAvailability(roomType,
                    availability.get(roomType) - 1);

            // Confirm booking
            System.out.println("Booking confirmed for Guest: "
                    + reservation.getGuestName()
                    + ", Room ID: " + roomId);

        } else {
            System.out.println("No rooms available for Guest: "
                    + reservation.getGuestName()
                    + ", Room Type: " + roomType);
        }
    }

    /**
     * Generate unique room ID
     */
    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        return roomType + "-" + count;
    }
}