package DynamicProxy;
public class ITEmployee implements IEmployee{
	
	private int id;
	private String name;
	private double salary;

	public void giveHike(double amount) {
		this.salary = this.salary + amount;
	}
	public void payCut(double amount) {
		this.salary = this.salary - amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
