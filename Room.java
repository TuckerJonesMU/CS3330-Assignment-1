package Files;

public class Room {

	private final String roomName;
	private final int capacity;
	
	public Room(String roomName, int capacity) {
		if( roomName == null || roomName.isBlank()) {
			throw new IllegalArgumentException("Room name cannot be null or blank, Please provide a name.");
		}
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be a positive number.");
		}
		this.roomName = roomName;
		this.capacity = capacity;
	}

	public String getRoomName() {
		return roomName;
	}

	public int getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return roomName + " (cap " + capacity + ")";
	}
	
	

}
