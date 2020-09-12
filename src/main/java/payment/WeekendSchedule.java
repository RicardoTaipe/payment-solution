package payment;

import java.time.LocalTime;
import java.util.ArrayList;

public class WeekendSchedule extends Schedule {

	public WeekendSchedule(LocalTime startTime, LocalTime endTime, int hourlyRate) {
		super(startTime, endTime, hourlyRate);
	}	
	
	public WeekendSchedule(LocalTime startTime, LocalTime endTime) {
		super(startTime, endTime);
	}

	public static ArrayList<WeekendSchedule> mockWeekendSchedules(){
		ArrayList<WeekendSchedule> weekendSchedule = new ArrayList<>();
		weekendSchedule.add(new WeekendSchedule(LocalTime.parse("00:01"), LocalTime.parse("09:00"),30));
		weekendSchedule.add(new WeekendSchedule(LocalTime.parse("09:01"), LocalTime.parse("18:00"),20));
		weekendSchedule.add(new WeekendSchedule(LocalTime.parse("18:01"), LocalTime.parse("23:59"),25));
		return weekendSchedule;
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
	public void getHourlyRateforWorkedSchedule(){
		for (WeekendSchedule salaryTable : mockWeekendSchedules()) {
			if (getStartTime().isAfter(salaryTable.getStartTime())
				&& getStartTime().isBefore(salaryTable.getEndTime())) {
				setHourlyRate(salaryTable.getHourlyRate());
				break;//exit when hourly rate is found
			}
		}	
	}
}
