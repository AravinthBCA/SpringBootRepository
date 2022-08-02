package DynamicProxy;

public class Client {

	public static void main(String[] args) {
		ITEmployee itEmployee = new ITEmployee();
		itEmployee.setId(101);
		itEmployee.setName("Aravinth");
		itEmployee.setSalary(50000);
		
		EmployeeSalaryInvocationHandler empHandler = new EmployeeSalaryInvocationHandler(itEmployee);
		
		IEmployee iEmployee = empHandler.createProxy(empHandler);
				
		iEmployee.giveHike(6000);
		System.out.println(iEmployee.getSalary());
	}
	
}
