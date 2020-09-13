package payment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	private Employee employee;
	private ReadFile readFile;


	@Before
	public void shouldInstantiateObject() {
		employee = new Employee();
		readFile= new ReadFile();		
	}
	
	@Test
	public void givenAstridEmployeeThenCalculateTotalWages() {
		String formatedEmployee="ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00";
		employee = readFile.toEmployee(formatedEmployee);
		String expected= "The amount to pay ASTRID is: 85 USD";		
		assertEquals(expected, employee.calculateTotalWage());		
	}
	
	@Test
	public void givenReneEmployeeThenCalculateTotalWages() {
		String formatedEmployee="RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00";
		employee = readFile.toEmployee(formatedEmployee);
		String expected= "The amount to pay RENE is: 215 USD";		
		assertEquals(expected, employee.calculateTotalWage());		
	}

}
