public class Main {

    public static void main(String[] args) {

        ReservationManager manager = new ReservationManager(20);

        // Create at least 2 rooms
        Room room101 = new Room("Room 101", 4);
        Room room202 = new Room("Room 202", 6);

        // Create at least 5 reservations across different rooms and time slots
        manager.createReservation(room101, "Reece", new TimeSlot(9));   // ID 1
        manager.createReservation(room101, "Alex", new TimeSlot(10));  // ID 2
        manager.createReservation(room202, "Jordan", new TimeSlot(9)); // ID 3
        manager.createReservation(room202, "Taylor", new TimeSlot(13));// ID 4
        manager.createReservation(room101, "Morgan", new TimeSlot(14));// ID 5

        // Cancel at least 1 reservation
        manager.cancelReservation(2);

        // Check in at least 1 reservation
        manager.checkInReservation(4);

        // Print all reservations
        System.out.println("=== ALL RESERVATIONS ===");
        manager.printAllReservations();

        // Print reservations for one specific room
        System.out.println("\n=== RESERVATIONS FOR " + room101 + " ===");
        manager.printReservationsForRoom(room101);
    }
}