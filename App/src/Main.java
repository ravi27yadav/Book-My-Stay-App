/**
 * =============================================================
 * MAIN CLASS - UseCase4RoomSearch
 * =============================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * @version 4.0
 */
public class Main {

    public static void main(String[] args) {

        // Room objects (UC2)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Inventory (UC3)
        RoomInventory inventory = new RoomInventory();

        // Search Service (NEW)
        RoomService searchService = new RoomService();

        // Perform search (READ-ONLY)
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}