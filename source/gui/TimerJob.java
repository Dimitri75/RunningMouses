package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerJob {
	public Timer timer;
	private boolean isPaused = false;
	
	private JLabel nbTour;
	private int lap = 0;
	
	private JLabel nbDeplacements;
	private int nbDep = 0;
	
	private JLabel mouseInMov;
	private int mouseIM = 0;
	
	private JLabel mouseArrived;
	private int mouseA = 0;
	
	private JPanel map;
	private JButton pause;
	

	public TimerJob(String period) {
		int per = 1000;
		try {
			per = Integer.parseInt(period);
			per *= 1000;
		} catch (Exception e) {
			e.getMessage();
		}
		timer = new Timer(per, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				lap++;
				
				//MAJ du text
				nbTour.setText("Tour : "+lap);
				nbDeplacements.setText("Déplacements : " +nbDep);
				mouseInMov.setText("Souris en déplacements : "+mouseIM);
				mouseArrived.setText("Souris arrivées : "+mouseA);
				//Repaint des composants
				nbTour.repaint();
				nbDeplacements.repaint();
				mouseInMov.repaint();
				mouseArrived.repaint();
				
				System.out.println("Tour(" + lap + ") - Déplacement(" + lap
						+ ") - Souris en déplacement(" + lap
						+ ") - Souris arrivées(" + lap + ")");
				System.out.println(new Date() + "\n");	
				
			}
			
		});
		timer.start();
	}
	public void setComponents(JPanel jp, JButton jb, JLabel jl1, JLabel jl2, JLabel jl3, JLabel jl4)
	{
		map = jp;
		pause = jb;
		nbTour = jl1;
		nbDeplacements = jl2;
		mouseInMov = jl3;
		mouseArrived = jl4;
	}
	public void pause(){
		if(isPaused){
			pause.setText("Pause");
			pause.repaint();
			timer.start();
			isPaused = false;
		}
		else
		{
			pause.setText("Continue");
			pause.repaint();
			timer.stop();
			isPaused = true;
		}
	}
	/*class MyTask extends TimerTask {
		public void run() {		
		}
	}*/
}
