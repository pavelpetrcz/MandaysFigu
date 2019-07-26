package dataAccess;

import java.util.HashMap;

import dao.MonthDao;
import dao.RequestDao;
import dao.ResultDao;

public class GetDataFlow {
	
	/**
	 * Retrieve data from Database
	 */
	public ResultDao execute(RequestDao req, ResultDao res) {
		DataAccessImpl item = new DataAccessImpl();
		HashMap<String, Integer> itemData = new HashMap<String, Integer>();
		MonthDao m = new MonthDao();
		
		itemData.putAll(item.getMonthData(req.getMonth(), req.getYear()));
		System.out.println(itemData.toString());
		m.setMonth(itemData.get("month"));
		m.setYear(itemData.get("year"));
		m.setWorkingDays(itemData.get("workingdays"));
		m.setWorkingDaysHolidays(itemData.get("workingdayswithoutholidays"));
		res.setMonthData(m);
		
		return res;
	}
}