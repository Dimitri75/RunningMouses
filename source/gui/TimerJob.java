package gui;

import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class TimerJob {
	public Timer timer;
	int lap = 0;

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
			lap++;
			if (lap > 250)
				timer.cancel();

			System.out.println("Tour(" + lap + ") - Déplacement(" + lap
					+ ") - Souris en déplacement(" + lap
					+ ") - Souris arrivées(" + lap + ")");
			System.out.println(new Date() + "\n");
		}
	}
}
