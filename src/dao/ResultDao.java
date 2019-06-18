package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("result")
@RequestScoped
public class ResultDao {
	
	@Inject
	private MonthDao monthData;
	
	@Inject
	private QuaterDao quaterData;
	
	/**
	 * @return the quaterData
	 */
	public QuaterDao getQuaterData() {
		return quaterData;
	}
	/**
	 * @param quaterData the quaterData to set
	 */
	public void setQuaterData(QuaterDao quaterData) {
		this.quaterData = quaterData;
	}
	/**
	 * @return the monthData
	 */
	public MonthDao getMonthData() {
		return monthData;
	}
	/**
	 * @param monthData the monthData to set
	 */
	public void setMonthData(MonthDao monthData) {
		this.monthData = monthData;
	}
}
