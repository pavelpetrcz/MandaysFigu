package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.MonthDao;
import dao.RequestDao;
import dao.ResultDao;
import logic.CalcMonthFlow;

@Path("/")
public class MonthResource {
	
	RequestDao req = new RequestDao();
	ResultDao res = new ResultDao();
	
	/**
	 * @param month
	 * @param year
	 * @return data about selected month in JSON
	 */
	@Path("/month/{monthId}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MonthDao getMonthResouce(
    	@PathParam("monthId") int month, 
    	@PathParam ("year") int year) {
		req.setMonth(month);
		req.setYear(year);
		CalcMonthFlow calculation = new CalcMonthFlow();
		calculation.execute(req, res);
		
		return res.getMonthData();
		}
	
	@Path("/quarter/{quarterId}/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public String getQuarterResource(
			@PathParam("quarterId") int qurter, 
	    	@PathParam ("year") int year) {
				return null;
		
	}
}