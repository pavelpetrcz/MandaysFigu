/**
 * 
 */
package present;

import javax.servlet.ServletException;

/**
 * 
 * @author Pavel Petr
 *
 */

interface IValidationServices {
	
	/**
	 * Check of month
	 * @return validated value
	 * @param monthInput - string with month
	 * @throws ServletException
	 * 
	 * */
	int validateMonthAndConvert(String monthInput) throws ServletException;
	
	/**
	 * @return validated value
	 * @param hoursInput - string with hours
	 * @throws ServletException
	 * 
	 * */
	double validateHoursAndConvert(String hoursInput) throws ServletException;
	
	/**
	 * Check of month
	 * @return validated value
	 * @param yearInput - string with year
	 * @throws ServletException
	 * 
	 * */
	int validateYearAndConvert(String yearInput) throws ServletException;
	
	/**
	 * @param input
	 * @param errorMsg
	 * @throws ServletException
	 */
	void validateNotEmptyString(String input, String errorMsg) throws ServletException;
	
	/**
	 * @return void
	 * @param input
	 * @param hourBoolean - if it is hours or different number
	 * @param errorMsg
	 * @throws ServletException
	 *
	 */
	void validateRegex(String input, boolean hoursBoolean, String errorMsg) throws ServletException;
	
	/**
	 * we do not allow 0 or more than 24 hours
	 * @return validated value
	 * @param hours - string with hours as double
	 * @throws ServletException
	 * 
	 * */
	double checkHoursNoLongerDay(Double hours) throws ServletException;
}
