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
		weekdaySchedule = new WeekdaySchedule( startTime, endTime);
		
	}
	@Test
	public void givenWeekdayScheduleThenGetWorkedHours() {
		assertEquals(4,weekdaySchedule.getWorkedHours());
	}

	@Test
	public void givenWeekdayScheduleThenGetWagePerHour() {
		weekdaySchedule.getHourlyRateforWorkedSchedule();
		assertEquals(100, weekdaySchedule.getWagePerHour());
	}
}
