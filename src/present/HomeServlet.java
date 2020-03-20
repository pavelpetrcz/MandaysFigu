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
	private CalcMonthFlow calcMonthFlow;
    
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
			hoursD = checkHoursNoLongerDay(validateHoursAndConvert(hoursInput)) ;
			yearInt = validateYear(yearInput);
			
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
	private void validate(String input, boolean hoursBoolean) {
		final Pattern regex = Pattern.compile("\\d");
		final Pattern hoursRegex = Pattern.compile("\\d[.,]\\d{0,2}");
		input.trim();
		if(hoursBoolean) {
			hoursRegex.matcher(input).matches();
		}
		else {
			regex.matcher(input).matches();
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
			int monthInt = Integer.valueOf(monthInput);
			if(monthInt <= 12 && monthInt > 0) {
				validate(monthInput, false);
			}
			else {
				throw new ServletException("Mìsíc mùže být maximálnì 12.");
			}
			return monthInt;
		}
	}
	
	/*
	 * year validation
	 * */
	private int validateYear(String yearInput) throws ServletException {
		if (yearInput == null || yearInput.equals("") || Integer.valueOf(yearInput) == 0) {
			throw new ServletException("Zadejte celé èíslo do kolonky rok.");
		}
		else {
			validate(yearInput, false);
			return Integer.valueOf(yearInput);
		}
	}
	
	/*
	 * validation of hours and replacing decimal comma with dot
	 * */
	private double validateHoursAndConvert(String hoursInput) throws ServletException {
		if (!StringUtils.isEmpty(hoursInput)) {
			validate(hoursInput, true);
			//použití èárky místo desetinné teèky
			boolean containsComma = hoursInput.contains(",");
			if (containsComma) {
				hoursInput.replace(",", ".");
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