/**
 * 
 */
package present;

import java.util.regex.Pattern;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.tinylog.Logger;

/**
 * @author pavel
 *
 */
public class ValidationServices implements IValidationServices {

	public int validateYearAndConvert(String yearInput) throws ServletException {
		int yearInputInt = 0;
		int yearOut = 0	;
		String er = "Zadejte celé èíslo do kolonky rok - napø. 2020.";
		
			try {
				//validations
				validateNotEmptyString(yearInput, er);
				validateRegex(yearInput, false, er);
				
				//format
				yearInput = yearInput.replaceAll("\\s+","");
				
				//convert to int
				yearInputInt = Integer.valueOf(yearInput);
				
				//business validation
				if (yearInputInt > 2019 && yearInputInt < 2050) {
					yearOut = yearInputInt;
				}
				else {
					throw new ServletException("Rok musí být v rozmezí 2019-2050.");
				}
			} catch (ServletException e) {
				Logger.error("Year validation failed." + e.getMessage().toString());
				throw new ServletException(e.getMessage());
			}
			return yearOut;
	}

	public double validateHoursAndConvert(String hoursInput) throws ServletException {
		String er = "Zadejte do kolonky hodiny èíslo s des. teèkou (\"4.0\") nebo celé èíslo (\"8\")."; 
		Double hoursOut;
			try {
				validateNotEmptyString(hoursInput, er);
				validateRegex(hoursInput, true, er);
				
				//format
				hoursInput = hoursInput.replaceAll("\\s+","");
				boolean containsComma = hoursInput.contains(",");
				if (containsComma) {
					hoursInput.replace(",", ".");
					}
				hoursOut = Double.parseDouble(hoursInput);
			} catch (ServletException e) {
				Logger.error("Hour validation failed." + e.getMessage().toString());
				throw new ServletException(e.getMessage());
			}
			return hoursOut;
		}
	
	public int validateMonthAndConvert(String monthInput) throws ServletException {
			String er = "Zadejte celé èíslo do kolonky mìsíc - napø. 5.";
			int monthOut = 0;
			try {
				validateNotEmptyString(monthInput, er);
				validateRegex(monthInput, false, er);
				
				//format
				monthInput = monthInput.replaceAll("\\s+","");
				int monthInt = Integer.valueOf(monthInput);
				if(monthInt <= 12 && monthInt > 0) {
					monthOut = monthInt; 
				}
				else {
					throw new ServletException("Mìsíc mùže být maximálnì 12.");
				}
				return monthOut;
			} catch (ServletException e) {
				Logger.error("Month validation failed." + e.getMessage().toString());
				throw new ServletException(e.getMessage());
			}
	}
	
	public double checkHoursNoLongerDay(Double hours) throws ServletException {
		if (hours <= 24 && hours > 0) {
			return hours;
		} 
		else {
			throw new ServletException("Zadali jste více hodin než má 1 den.");
		}
	}
	
	public void validateNotEmptyString(String input, String errorMsg) throws ServletException {
		if (StringUtils.isEmpty(input) || input == null || input.equals("")) {
			throw new ServletException(errorMsg);
		}
	}
	
	public void validateRegex(String input, boolean hoursBoolean, String errorMsg) throws ServletException {
		final Pattern regex = Pattern.compile("\\d*");
		final Pattern hoursRegex = Pattern.compile("\\d*[.,]\\d{0,2}|\\d*");
		boolean result;
		input = input.replaceAll("\\s+","");
			if(hoursBoolean) {
				result = hoursRegex.matcher(input).matches();
			}
			else {
				result = regex.matcher(input).matches();
			}
		if(!result) {
			throw new ServletException(errorMsg);
		}
	}
}