package Files;

public class TimeSlot {

	private final int hour;
	
	public TimeSlot(int hour) {
		if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("Hour must be between 0 and 23.");
		}
		this.hour = hour;
	}

	public int getHour() {
		return hour;
	}

	@Override
	public String toString() {
		int displayHour = (hour == 0 || hour == 12) ? 12 : hour % 12;
        String ampm = (hour < 12) ? "AM" : "PM";
        return displayHour + ":00-" + (displayHour == 12 ? 1 : (displayHour + 1)) + ":00 " + ampm;
	}
	
	

}
