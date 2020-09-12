package payment;

import java.time.LocalTime;

public abstract class Schedule {
	private LocalTime startTime;
	private LocalTime endTime;
	private int hourlyRate;	
	
	public Schedule(LocalTime startTime, LocalTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Schedule(LocalTime startTime, LocalTime endTime, int hourlyRate) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.hourlyRate = hourlyRate;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	//methods to override
	public abstract int getWorkedHours();
	
	public abstract int getWagePerHour();

	public abstract void getHourlyRateforWorkedSchedule();
	
	// end methods to override
	
	@Override
	public String toString() {
		return "["+startTime+","+endTime+ ", price=" + hourlyRate + "]";
		
	}	
	
	
}

