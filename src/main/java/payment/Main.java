package payment;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {		
		
		ReadFile employeesInFile= new ReadFile();
		
		ArrayList<String> formatedEmployees;
		//@INFO "employee-data.txt" should be inside project folder
		//if not write absolute path file
		
		formatedEmployees= employeesInFile.extractEmployeesFromFile("employee_data.txt");
		
		//verify format of input text
		for(String data: formatedEmployees) {
			if(!employeesInFile.verifyFormat(data)) {
				System.out.println("INFO: The employee in file has no right format.!!!");
				System.exit(1);
			}
		}
		//convert employees string from file into employee objects
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		for(String data: formatedEmployees) {
			employees.add(employeesInFile.toEmployee(data));
		}
		//Print employees' wages
		for(Employee employee: employees) {
			System.out.println(employee.calculateTotalWage());
		}
	}
}
