package gui;

import java.util.TimerTask;
import java.util.Timer;

public class TimerJob {
	public Timer timer;

	public TimerJob(long sc) {
		timer = new Timer();
		timer.schedule(new MyTask(), 0, sc*1000);
	}

	class MyTask extends TimerTask {
		public void run() {
			System.out.println("Tic");
		}
	}
}
