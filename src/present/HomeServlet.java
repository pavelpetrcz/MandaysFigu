package present;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	int month = 0;
	int year = 0;
	double hours = 0;
	private ResultDao execute;
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
			try {
				response.getWriter().println("AHOJ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String monthInput = request.getParameter("month");
		String yearInput = request.getParameter("year");
		String hoursInput = request.getParameter("hours");
		
		//response.getWriter().println(monthInput);
		//response.getWriter().println(yearInput);
		//response.getWriter().println(hoursInput);
		
		//session.setAttribute("m", monthInput);
		
		response.sendRedirect("Result.jsp");
		
		
		/*try {
			//validace 
			
			
			kontrola mìsíce
			if (monthInput != null || monthInput != "") {
				validate(monthInput, false);
				month = Integer.valueOf(monthInput);
			} 
			
			//kontrola roku
			if (yearInput == null || yearInput != "") {
				validate(yearInput, false);
				year = Integer.valueOf(yearInput);
			}
			else {
				throw new ServletException("Zadejte celé èíslo do kolonky rok.");
			}
			
			if (hoursInput != null) {
				validate(hoursInput, true);
				//použití èárky místo desetinné teèky
				boolean containsComma = hoursInput.contains(",");
				if (containsComma) {
					hoursInput.replace(",", ".");
					}
				hours = Double.parseDouble(hoursInput);
			}
			else {
				throw new ServletException("Zadejte hodiny ve tvaru \"4.0\".");
			}
		} catch(ServletException ex) {
			ex.getMessage();
		}
		req.setMonth(month);
		req.setYear(year);
		req.setHoursPerDay(hours);
		
		calcMonthFlow = null;
		try {
			execute = calcMonthFlow.execute(req, res);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Result.jsp");*/
	}

	
	   
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
}