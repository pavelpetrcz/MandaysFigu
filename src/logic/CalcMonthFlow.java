package logic;

import dao.RequestDao;
import dao.ResultDao;
import dataAccess.GetDataFlow;

public class CalcMonthFlow {
	
	public ResultDao execute(RequestDao req, ResultDao res) {
		GetDataFlow dbData = new GetDataFlow();
		LogicImpl calc = new LogicImpl();
		
		dbData.execute(req, res);
		calc.calculateHours(res, req);
		return res;
	}
}