package realtimeodds.realtimeodd;

import java.util.Timer;
import java.util.TimerTask;

import com.realtimeodd.common.util.Constants;
import com.realtimeodd.service.RealTimeOddTimerTask;

/**
 * 
 * Provides the classes for RealTimeOddTimerTask and continuously polls the
 * Kambi API.
 *
 */
public class RealTimeOddsApplication {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.err.println("Enter the event Id: ");
			return;
		}
		Long id = Long.valueOf(args[0]);

		Timer timer = new Timer();
		TimerTask realTimeOddTimerTask = new RealTimeOddTimerTask(id);
		timer.scheduleAtFixedRate(realTimeOddTimerTask, 0, Constants.TIME_INTERVAL);
	}

}
