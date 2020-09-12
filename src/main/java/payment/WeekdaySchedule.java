package payment;

import java.time.LocalTime;
import java.util.ArrayList;

public class WeekdaySchedule extends Schedule {

	public WeekdaySchedule(LocalTime startTime, LocalTime endTime, int hourlyRate) {
		super(startTime, endTime, hourlyRate);
	}
	

	public WeekdaySchedule(LocalTime startTime, LocalTime endTime) {
		super(startTime, endTime);
	}


	public static ArrayList<WeekdaySchedule> mockWeekDaySchedules(){
		ArrayList<WeekdaySchedule> weekdaySchedule = new ArrayList<WeekdaySchedule>();
		weekdaySchedule.add(new WeekdaySchedule(LocalTime.parse("00:01"), LocalTime.parse("09:00"),25));
		weekdaySchedule.add(new WeekdaySchedule(LocalTime.parse("09:01"), LocalTime.parse("18:00"),15));
		weekdaySchedule.add(new WeekdaySchedule(LocalTime.parse("18:01"), LocalTime.parse("23:59"),20));
		return weekdaySchedule;
	}

	@Override
	public int getWorkedHours() {
		if(getEndTime().getHour() == 0) {
			return 24 - getStartTime().getHour();
		}
		return getEndTime().getHour()-getStartTime().getHour();
	}

	@Override
	public int getWagePerHour() {
		return getWorkedHours()* getHourlyRate();
	}


	@Override
	public void getHourlyRateforWorkedSchedule() {
		for (WeekdaySchedule salaryTable : mockWeekDaySchedules()) {
			if (getStartTime().isAfter(salaryTable.getStartTime())
				&& getStartTime().isBefore(salaryTable.getEndTime())) {
				setHourlyRate(salaryTable.getHourlyRate());
				break; //exit when hourly rate is found
			}
		}
	}	
}