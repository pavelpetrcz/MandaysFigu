package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("month")
@RequestScoped
public class MonthDao {
	private int month; // month of year
	private int year;
	private int workingDays; //total working days
	private int workingDaysHolidays; //number of days in month without holidays
	private Long workingHours; // total number of working hours
	private Long workingHoursWithoutHolidays; //total number of working hours without holidays
	/**
	 * @return the workingHours
	 */
	public Long getWorkingHours() {
		return workingHours;
	}
	/**
	 * @param workingHours the workingHours to set
	 */
	public void setWorkingHours(Long workingHours) {
		this.workingHours = workingHours;
	}
	/**
	 * @return the workingHoursWithoutHolidays
	 */
	public Long getWorkingHoursWithoutHolidays() {
		return workingHoursWithoutHolidays;
	}
	/**
	 * @param workingHoursWithoutHolidays the workingHoursWithoutHolidays to set
	 */
	public void setWorkingHoursWithoutHolidays(Long workingHoursWithoutHolidays) {
		this.workingHoursWithoutHolidays = workingHoursWithoutHolidays;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the workingDays
	 */
	public int getWorkingDays() {
		return workingDays;
	}
	/**
	 * @param workingDays the workingDays to set
	 */
	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}
	/**
	 * @return the workingDaysHolidays
	 */
	public int getWorkingDaysHolidays() {
		return workingDaysHolidays;
	}
	/**
	 * @param workingDaysHolidays the workingDaysHolidays to set
	 */
	public void setWorkingDaysHolidays(int workingDaysHolidays) {
		this.workingDaysHolidays = workingDaysHolidays;
	}
}