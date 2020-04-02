package dao;

import javax.servlet.http.HttpSession;

public class RequestDao {
	private int month;
	private int quarter;
	private double hoursPerDay; // represents number of hours in day
	
	/**
	 * @return the quater
	 */
	public int getQuarter() {
		return quarter;
	}
	/**
	 * @param quater the quarter to set
	 */
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	private int year;
	
	/**
	 * @return the hoursPerDay
	 */
	public double getHoursPerDay() {
		return hoursPerDay;
	}
	/**
	 * @param hoursPerDay the hoursPerDay to set
	 */
	public void setHoursPerDay(double hoursPerDay) {
		this.hoursPerDay = hoursPerDay;
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
	public HttpSession getSession() {
		return null;
	}
}
