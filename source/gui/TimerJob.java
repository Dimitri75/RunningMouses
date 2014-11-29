package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;


import utils.SimulationAlgo;

public class TimerJob {
	
	public Timer timer;
	private boolean isPaused = false;
	
	private JLabel nbTour;
	private int lap = 0;
	
	private JLabel nbDeplacements;
	
	private JLabel mouseInMov;
	
	private JLabel mouseArrived;
	

	private JButton pause;
	
	private SimulationAlgo dijkstra;
	

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
				
				//Actions du timer job
				lap++;
				dijkstra.moveMovingMouses();
				dijkstra.spawnAllPossibleMouses(dijkstra.getDoor1());
				dijkstra.spawnAllPossibleMouses(dijkstra.getDoor2());
				//MAJ du text
				nbTour.setText("Tour : "+lap);
				nbDeplacements.setText("Déplacements : " +dijkstra.getNbDep());
				mouseInMov.setText("Souris en déplacements : "+dijkstra.getMovingMouses().size());
				mouseArrived.setText("Souris arrivées : "+dijkstra.getMouseA());
				//Repaint des composants
				nbTour.repaint();
				nbDeplacements.repaint();
				mouseInMov.repaint();
				mouseArrived.repaint();
				if(dijkstra.getMovingMouses().size() == 0)
					timer.stop();
				
			}
			
		});
		timer.start();
	}
	public void setComponents(SimulationAlgo sa, JButton jb, JLabel jl1, JLabel jl2, JLabel jl3, JLabel jl4)
	{
		dijkstra = sa;
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

	
	
	public SimulationAlgo getDijkstra() {
		return dijkstra;
	}
}
