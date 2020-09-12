package payment;


import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class WeekdayScheduleTest {
	private WeekdaySchedule weekdaySchedule;

	@Before
	public void shouldInstantiateObject() {
		LocalTime startTime =LocalTime.parse("04:00");
		LocalTime endTime =LocalTime.parse("08:00");
		int hourlyRate = 25;
		weekdaySchedule = new WeekdaySchedule( startTime, endTime, hourlyRate);
		
	}
	@Test
	public void testGetWorkedHours() {
		assertEquals(4,weekdaySchedule.getWorkedHours());
	}

	@Test
	public void testGetWagePerHour() {
		assertEquals(100, weekdaySchedule.getWagePerHour());
	}

	@Test
	public void testGetHourlyRateforWorkedSchedule() {
		//fail("Not yet implemented");
	}

}
