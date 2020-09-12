package payment;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {		
		
		ReadFile employeesInFile= new ReadFile();
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		//convert employees string from file into employee objects
		for(String data: employeesInFile.extractEmployeesFromFile()) {
			employees.add(employeesInFile.toEmployee(data));
		}
		//Print employees' wages
		for(Employee employee: employees) {
			System.out.println(employee.calculateTotalWage());
		}
	}
}
