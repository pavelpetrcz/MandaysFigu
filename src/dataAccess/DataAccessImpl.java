package dataAccess;

import dataAccess.DbConnect;
import java.sql.SQLException;
import java.util.HashMap;

import javax.inject.Inject;
import dao.ResultDao;

public class DataAccessImpl {
	DbConnect dbconn = new DbConnect();
	HashMap<String, Integer> data = null;

	@Inject
	ResultDao result;

	/**
	 * @param month
	 * @param year
	 * @return hashMap of data from DB
	 */
	public HashMap<String, Integer> getMonthData(int month, int year) {
		String sql = "select * from workingdays where month=" + String.valueOf(month) + " and year="+ String.valueOf(year);
		try {
			dbconn.connect();
			data = dbconn.query(sql);
			dbconn.quitConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}