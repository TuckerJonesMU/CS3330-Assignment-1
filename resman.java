
public class ReservationManager {
    private ReservationBook book;
    private int nextId;
    //id generate
    public ReservationManager(int maxCapacity) {
        this.book = new ReservationBook(maxCapacity);
        this.nextId = 1; //pos id only
    }
    public void createReservation(Room room, String studentName, TimeSlot slot) {
        int id = nextId++; // new id then increment
        Reservation newRes = new Reservation(id, room, studentName, slot); //reservation made
        book.add(newRes);//store
    }
    public void cancelReservation(int id) {
        Reservation res = book.findById(id);
        if (res != null) {
            res.cancel(); // LOD cancel
        } else {
            System.out.println("The Reservation ID of " + id + "was not found.");
        }
    }
    public void checkInReservation(int id) {
        Reservation res = book.findById(id);
        if (res != null) {
            res.checkIn();
        } else {
            System.out.println("The Reservation ID of " + id + "was not found.");
        }
    }
    public void printAllReservations() {
        book.printAll();
    }
    public void printReservationsForRoom(Room room) {
        book.printForRoom(room);
    }
}