package logic;

import dao.RequestDao;
import dao.ResultDao;

public interface ILogicImpl {
	
	
	/**
	 * @param res - result which will be set
	 * @param req - request from client
	 * @return result with calculated data
	 */
	ResultDao calculateHours(ResultDao res, RequestDao req);
	
	

}
