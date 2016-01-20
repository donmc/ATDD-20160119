package feature.tddair;

import com.tddair.FlightDao;
import com.tddair.MemberDAO;
import com.tddair.TddAirApplication;

public class StepData {
	// singleton boilerplate
	private static final StepData INSTANCE = new StepData();
	
	private StepData() {
		// prevent construction
	}
	
	// real members
	public TddAirApplication app = new TddAirApplication();
	
	public static void reset() {
		StepData.INSTANCE.app = new TddAirApplication();
	}
	
	public static TddAirApplication getApplication() {
		return StepData.INSTANCE.app;
	}
	
	public static FlightDao getFlightDao() {
		return StepData.INSTANCE.app.getFlightDao();
	}
	
	public static MemberDAO getMemberDAO() {
		return StepData.INSTANCE.app.getMemberDAO();
	}
}
