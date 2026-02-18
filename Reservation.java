public class Reservation {

    private final int id;
    private final Room room;
    private final String studentName;
    private final TimeSlot timeSlot;

    private boolean canceled;
    private boolean checkedIn;

    public Reservation(int id, Room room, String studentName, TimeSlot timeSlot) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }

        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null.");
        }

        if (timeSlot == null) {
            throw new IllegalArgumentException("TimeSlot cannot be null.");
        }

        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be null or blank.");
        }

        this.id = id;
        this.room = room;
        this.studentName = studentName.trim();
        this.timeSlot = timeSlot;

        this.canceled = false;
        this.checkedIn = false;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public boolean isActive() {
        return !canceled;
    }

    public boolean canCancel() {
        return !canceled && !checkedIn;
    }

    public boolean canCheckIn() {
        return !checkedIn && !canceled;
    }

    // Rule:
    // - If canceled, cannot check in later
    // - If checked in, cannot cancel later

    public void cancel() {
        if (checkedIn) {
            throw new IllegalStateException("Cannot cancel after check in.");
        }
        if (canceled) {
            throw new IllegalStateException("Already canceled.");
        }
        canceled = true;
    }

    public void checkIn() {
        if (canceled) {
            throw new IllegalStateException("Cannot check in after cancel.");
        }
        if (checkedIn) {
            throw new IllegalStateException("Already checked in.");
        }
        checkedIn = true;
    }

    @Override
    public String toString() {

        String status;

        if (canceled) {
            status = "CANCELED";
        } else if (checkedIn) {
            status = "CHECKED-IN";
        } else {
            status = "ACTIVE";
        }

        return "ID: " + id
                + " | Student: " + studentName
                + " | Room: " + room
                + " | Time: " + timeSlot
                + " | Status: " + status;
    }
}