public class ReservationBook {
    private Reservation[] reservations; //normal array
    private int count; //how many res made thus far
    public ReservationBook(int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("There cannot be a non positive number capacity.");
        }
        this.reservations = new Reservation[maxCapacity];
        this.count = 0;
    }
    public void add(Reservation r) {
        if (count<reservations.length) {
            reservations[count] = r;
            count++;
        } else {
            throw new IllegalStateException("The Reservation Book is unfortunately full"); // the exception where full
        }
    }
    public Reservation findById(int id) {
        for (int i = 0; i < count; i++) {
            if (reservations[i].getId() == id) {
                return reservations[i];
            }
        }
        return null;
    }
    public void printAll() {
        System.out.println(" ||||All of the Reservations|||| ");
        for (int i = 0; i < count; i++) {
            System.out.println(reservations[i].toString());
        }
    }
    public void printForRoom(Room room) {
        System.out.println(" || The reservations for" + room.toString() + " || ");
        for (int i = 0; i < count; i++) {
            if (reservations[i].getRoom() == room) { //compare
                System.out.println(reservations[i].toString());
            }
        }
    }
}
