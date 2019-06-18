package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("quater")
@RequestScoped
public class QuaterDao {
	private int quater; // quater of year
	private int year;
	private Long workingDays; //total working days
	private Long workingDaysHolidays; //number of days in month without holidays

	/**
	 * @return the quater
	 */
	public int getQuater() {
		return quater;
	}
	/**
	 * @param quater the quater to set
	 */
	public void setQuater(int quater) {
		this.quater = quater;
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
	public Long getWorkingDays() {
		return workingDays;
	}
	/**
	 * @param workingDays the workingDays to set
	 */
	public void setWorkingDays(Long workingDays) {
		this.workingDays = workingDays;
	}
	/**
	 * @return the workingDaysHolidays
	 */
	public Long getWorkingDaysHolidays() {
		return workingDaysHolidays;
	}
	/**
	 * @param workingDaysHolidays the workingDaysHolidays to set
	 */
	public void setWorkingDaysHolidays(Long workingDaysHolidays) {
		this.workingDaysHolidays = workingDaysHolidays;
	}
}
