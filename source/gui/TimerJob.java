package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import map.FrameCard;
import utils.Door;
import utils.SimulationAlgo;
import utils.Souris;

public class TimerJob {
	private String pathToFile;
	
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
				displayAllMouses();
				
				GroupLayout jpMyPanelLayout = new javax.swing.GroupLayout(
						map);
				map.setLayout(jpMyPanelLayout);

				jpMyPanelLayout.setHorizontalGroup(jpMyPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 401, Short.MAX_VALUE));

				jpMyPanelLayout.setVerticalGroup(jpMyPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 298, Short.MAX_VALUE));
				
				
				//MAJ du text
				nbTour.setText("Tour : "+lap);
				nbDeplacements.setText("Déplacements : " +nbDep);
				mouseInMov.setText("Souris en déplacements : "+dijkstra.getMovingMouses().size());
				mouseArrived.setText("Souris arrivées : "+mouseA);
				//Repaint des composants
				map.repaint();
				nbTour.repaint();
				nbDeplacements.repaint();
				mouseInMov.repaint();
				mouseArrived.repaint();
				map.setPreferredSize(new Dimension(900, 500));
				/*System.out.println("Tour(" + lap + ") - Déplacement(" + lap
						+ ") - Souris en déplacement(" + lap
						+ ") - Souris arrivées(" + lap + ")");
				System.out.println(new Date() + "\n");	*/
				
			}
			
		});
		timer.start();
	}
	public void setComponents(SimulationAlgo sa, JPanel jp, JButton jb, JLabel jl1, JLabel jl2, JLabel jl3, JLabel jl4)
	{
		dijkstra = sa;
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
	public void setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	
	private void displayAllMouses(){
		JLabel tile, myLabel = null;
		String urlSabelette = "src/res/img/sabelette.png";
		
		FrameCard fc = new FrameCard(map, myLabel, pathToFile);
		
		for(Souris m : dijkstra.getMovingMouses())
		{
			tile = new JLabel(new ImageIcon(urlSabelette));
			tile.setSize(100, 100);
			System.out.println("Souris en ("+m.getX()+","+m.getY()+")");
			tile.setLocation(m.getX() * 25, m.getY() * 25);
			map.add(tile);
		}
		
	}
}
