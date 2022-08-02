
public class Student implements DailySession{

	private Attendance attendance;
	
	public Student() {}
	
	public Student(Attendance attendance) {
		this.attendance = attendance;
	}
	
	@Override
	public void attendSession() {
		System.out.println("Attending Session...");
	}
	
	public void attendSession(Integer id) {
		System.out.println("Student id : "+id+" Attending Session...");
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

}
