
public class Student implements DailySession{

	private Attendance attendance;
	
	public Student(Attendance attendance) {
		this.attendance = attendance;
	}
	
	@Override
	public void attendSession() {
		System.out.println("Attending Session...");
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

}
