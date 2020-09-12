package payment;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
	private ArrayList<String> employeesInFile = new ArrayList<String>();
	
	public ArrayList<String> extractEmployeesFromFile(){
		try {
			File file = new File("employee_data.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				employeesInFile.add(reader.nextLine());
			}
			reader.close();		
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file...");
			System.exit(1);
		}
		return employeesInFile;
	}
	//convert employee data string to employee object
	public Employee toEmployee(String infoEmployee){
		//extract name
		String name= infoEmployee.split("=")[0];
		//extract schedules
		String schedules = infoEmployee.split("=")[1];
		
		ArrayList<Schedule> workedSchedule = toSchedules(schedules);
		Employee employee = new Employee();
		employee.setName(name);
		employee.setSchedule(workedSchedule);
		return employee;
	}
	
	//convert string to schedules - weekday or weekend schedules
	public ArrayList<Schedule> toSchedules(String schedules){
		//local variable declarations
		String [] day_schedules = schedules.split(",");
		ArrayList<Schedule> workedHours = new ArrayList<Schedule>();
		ArrayList<LocalTime> times;
		int startTime=0, endTime=1;
		String regexForWeekdaySchedule= "(MO|TU|WE|TH|FR)\\d{2}:\\d{2}-\\d{2}:\\d{2}"; //e.g MO12:00-13:00
		String regexForWeekendSchedule= "(SA|SU)\\d{2}:\\d{2}-\\d{2}:\\d{2}"; //e.g SU12:00-13:00
		
		//extract schedules from provided string
		for(String workedSchedule: day_schedules) {
			
			//Is a weekday schedule?
			if(workedSchedule.matches(regexForWeekdaySchedule)) {
				times = extractHours(workedSchedule);
				WeekdaySchedule weekdaySchedule = new WeekdaySchedule(times.get(startTime), times.get(endTime));
				weekdaySchedule.getHourlyRateforWorkedSchedule();;
				workedHours.add(weekdaySchedule);
				continue;
			}
			//Is a weekend schedule?
			if(workedSchedule.matches(regexForWeekendSchedule)) {
				times = extractHours(workedSchedule);		
				WeekendSchedule weekendSchedule = new WeekendSchedule(times.get(startTime), times.get(endTime));
				weekendSchedule.getHourlyRateforWorkedSchedule();
				workedHours.add(weekendSchedule);
				continue;
			}
		}
		return workedHours;
				
	}
	//extract hours from string e.g 12:00
	public ArrayList<LocalTime> extractHours(String workedHours){
		ArrayList<LocalTime> times = new ArrayList<LocalTime>();
		Matcher matcher = Pattern.compile("\\d{2}:\\d{2}").matcher(workedHours);
		while (matcher.find()) {
			times.add(LocalTime.parse(matcher.group()));
		}
		return times;
	}
}
