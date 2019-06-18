package logic;

import dao.RequestDao;
import dao.ResultDao;

public class LogicImpl implements ILogicImpl {

	
	@Override
	public ResultDao calculateHours(ResultDao res, RequestDao req) {
		//constant
		double hours = req.getHoursPerDay();
		int workDays = res.getMonthData().getWorkingDays();
		int workDWHol = res.getMonthData().getWorkingDaysHolidays();
		
		res.getMonthData().setWorkingHours(Math.round(hours * workDays));
		res.getMonthData().setWorkingHoursWithoutHolidays(Math.round(hours * workDWHol));
		return res;
	}

}
