package payment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ReadFileTest {
	
	private ReadFile readFile;
	
	@Before
	public void shouldInstantiateObject() {
		readFile = new ReadFile();		
	}

	@Test
	public void shouldExtractEmployeesFromFile() {
		ArrayList<String> employees;
		employees= readFile.extractEmployeesFromFile("employee_data.txt");
		assertTrue(employees.size() > 0);
	}

	@Test
	public void givenStringEmployeeThenConvertToEmployeeObject() {
		String formatedEmployee= "ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00";
		Employee convertedEmployee = readFile.toEmployee(formatedEmployee);
		assertEquals("ASTRID",convertedEmployee.getName());
		assertEquals(3,convertedEmployee.getSchedule().size());
	}
}
