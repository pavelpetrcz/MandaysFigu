package logic;

import dao.MonthDao;
import dao.RequestDao;
import dao.ResultDao;

public class LogicImpl implements ILogicImpl {
	MonthDao mon = new MonthDao();
	
	@Override
	public ResultDao calculateHours(ResultDao res, RequestDao req) {
		//constant
		double hours = req.getHoursPerDay();
		int workDays = res.getMonthData().getWorkingDays();
		int workDWHol = res.getMonthData().getWorkingDaysHolidays();
		
		mon = res.getMonthData();
		mon.setWorkingHours(Math.round(hours * workDays));
		mon.setWorkingHoursWithoutHolidays(Math.round(hours * workDWHol));
		res.setMonthData(mon);
		return res;
	}

}
