package gui;

import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class TimerJob {
	public Timer timer;
	int cpt = 1;

	public TimerJob(String period) {
		long per = 1000;
		try {
			per = Long.parseLong(period);
			per *= 1000;
		} catch (Exception e) {
			e.getMessage();
		}

		timer = new Timer();
		timer.schedule(new MyTask(), 0, per);
	}

	class MyTask extends TimerTask {
		public void run() {
			if (cpt >= 60)
				timer.cancel();
			System.out.println((cpt % 2 != 0) ? "Tic(" + new Date() + ")" : "Tac("
					+ new Date() + ")");
			cpt++;
		}
	}
}
