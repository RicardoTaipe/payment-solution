package payment;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class WeekendScheduleTest {
	private WeekendSchedule weekendSchedule;

	@Before
	public void shouldInstantiateObject() {
		LocalTime startTime =LocalTime.parse("11:00");
		LocalTime endTime =LocalTime.parse("15:00");
		weekendSchedule = new WeekendSchedule( startTime, endTime);
		
	}
	@Test
	public void givenWeekendScheduleThenGetWorkedHours() {
		assertEquals(4,weekendSchedule.getWorkedHours());
	}
	
	
	@Test
	public void givenWeekendScheduleThenGetWagePerHour() {
		weekendSchedule.getHourlyRateforWorkedSchedule();
		assertEquals(80, weekendSchedule.getWagePerHour());
	}

	
}
