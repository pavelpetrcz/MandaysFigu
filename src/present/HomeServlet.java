package present;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import dao.RequestDao;
import dao.ResultDao;
import logic.CalcMonthFlow;

/**
 * @author pavel
 *
 */

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDao req = new RequestDao();
	ResultDao res = new ResultDao();
	/**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}
	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
    
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response); 
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get inputs from request
		String monthInput = request.getParameter("month");
		String yearInput = request.getParameter("year");
		String hoursInput = request.getParameter("hours");
		
		ServletContext sc = getServletContext();
		
		int monthInt = 0;
		int yearInt = 0;
		double hoursD = 0.0;
		
		try {
			//validation of inputs
			monthInt = validateMonth(monthInput);
			yearInt = validateYear(yearInput);
			hoursD = checkHoursNoLongerDay(validateHoursAndConvert(hoursInput)) ;
			
			
			//set request to calculate with
			req.setMonth(monthInt);
			req.setYear(yearInt);
			req.setHoursPerDay(hoursD);
			
			try {
				//calculation with inputs
				CalcMonthFlow calculation = new CalcMonthFlow();
				calculation.execute(req, res);
				
				//setting result data
				
				sc.setAttribute("month", res.getMonthData().getMonth());
				sc.setAttribute("year", res.getMonthData().getYear());
				sc.setAttribute("workingDays", res.getMonthData().getWorkingDays());
				sc.setAttribute("workingDaysWithoutHolidays", res.getMonthData().getWorkingDaysHolidays());
				sc.setAttribute("workingHours", res.getMonthData().getWorkingHours());
				sc.setAttribute("workingHoursWithoutHOlidays", res.getMonthData().getWorkingHoursWithoutHolidays());
				
				//open result page
				RequestDispatcher rd = sc.getRequestDispatcher("/jsp/Result.jsp");
				rd.forward(request, response);
			} catch (URISyntaxException e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		catch (ServletException ex) {
			sc.setAttribute("errorMessage", ex.getMessage());
			RequestDispatcher rd = sc.getRequestDispatcher("/jsp/Error.jsp");
			rd.forward(request, response);
		}
	}
	
	/* 	
	 * validate input according to regex
	 * */
	private void validate(String input, boolean hoursBoolean) throws ServletException {
		final Pattern regex = Pattern.compile("\\d*");
		final Pattern hoursRegex = Pattern.compile("\\d*[.,]\\d{0,2}");
		boolean result;
		input = input.replaceAll("\\s+","");
			if(hoursBoolean) {
				result = hoursRegex.matcher(input).matches();
			}
			else {
				result = regex.matcher(input).matches();
			}
			if(!result) {
				throw new ServletException("Špatný formát.");
			}
	}
	
	/*
	 * month validation
	 * */
	private int validateMonth(String monthInput) throws ServletException {
		if (monthInput == null || monthInput.equals("")) {
			throw new ServletException("Nezadali jste mìsíc.");
		} 
		else {
			try {
				monthInput = monthInput.replaceAll("\\s+","");
				int monthInt = Integer.valueOf(monthInput);
				if(monthInt <= 12 && monthInt > 0) {
					validate(monthInput, false); 
				}
				return monthInt;
			} catch (Exception e) {
				throw new ServletException("Mìsíc mùže být maximálnì 12.");
			}
		}
	}
	
	/*
	 * year validation
	 * */
	private int validateYear(String yearInput) throws ServletException {
		int yearInputInt;
		int yearOut = 0	;
		if (yearInput == null || yearInput.equals("") || Integer.valueOf(yearInput) == 0) {
			throw new ServletException("Zadejte celé èíslo do kolonky rok - napø. 2020.");
		}
		else {
			try {
				yearInput = yearInput.replaceAll("\\s+","");
				validate(yearInput, false);
				yearInputInt = Integer.valueOf(yearInput);
				if (yearInputInt > 2019 && yearInputInt < 2050) {
					yearOut = yearInputInt;
				}
			} catch (Exception e) {
				throw new ServletException("Rok musí být v rozmezí 2019-2050.");
			}
		}
		
			return yearOut;
		
	}
	
	/*
	 * validation of hours and replacing decimal comma with dot
	 * */
	private double validateHoursAndConvert(String hoursInput) throws ServletException {
		if (!StringUtils.isEmpty(hoursInput)) {
			try {
				validate(hoursInput, true);
				hoursInput = hoursInput.replaceAll("\\s+","");
				boolean containsComma = hoursInput.contains(",");
				if (containsComma) {
					hoursInput.replace(",", ".");
					}
			} catch (ServletException e) {
				throw new ServletException("Špatný formát hodin. \"Zadejte hodiny ve tvaru \"4.0\".");
			}
			catch (NumberFormatException e) {
				throw new NumberFormatException("Zadejte èísla místo písmen.");
			}
			
			return Double.parseDouble(hoursInput);
		}
		else {
			throw new ServletException("Zadejte hodiny ve tvaru \"4.0\". Tedy s desetinnou teèkou.");
		}
	}
	
	/*
	 * we do not allow 0 or more than 24 hours
	 * */
	private double checkHoursNoLongerDay(Double hours) throws ServletException {
		if (hours <= 24 && hours > 0) {
			return hours;
		} 
		else {
			throw new ServletException("Zadali jste více hodin než má 1 den.");
		}
	}
}