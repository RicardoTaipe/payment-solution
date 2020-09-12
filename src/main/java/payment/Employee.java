package payment;

import java.util.ArrayList;

public class Employee {
	private String name;
	private ArrayList<Schedule> schedule;
	private int wages;
	
	public Employee(String name, ArrayList<Schedule> schedule) {
		super();
		this.name = name;
		this.schedule = schedule;
	}

	public Employee() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Schedule> schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", schedule=" + schedule + ", salary=" + wages + "]";
	}
	
	//calculate wage from a list of worked schedules
	public String calculateTotalWage() {
		wages = 0;
		for(Schedule schedule: this.schedule) {
			wages+=schedule.getWagePerHour();
		}
		return "The amount to pay "+ getName()+" is: "+ wages+ " USD";
	}
}
