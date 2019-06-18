package dataAccess;

import java.util.HashMap;
import dao.RequestDao;
import dao.ResultDao;

public class GetDataFlow {
	
	/**
	 * Retrieve data from DB
	 */
	public ResultDao execute(RequestDao req, ResultDao res) {
		DataAccessImpl item = new DataAccessImpl();
		HashMap<String, Integer> itemData = item.getMonthData(req.getMonth(), req.getYear());
		
		res.getMonthData().setMonth(itemData.get("month"));
		res.getMonthData().setYear(itemData.get("year"));
		res.getMonthData().setWorkingDays(itemData.get("workingdays"));
		res.getMonthData().setWorkingDaysHolidays(itemData.get("workingdayswithoutholidays"));
		
		return res;
	}
}