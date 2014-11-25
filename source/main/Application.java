package main;

import gui.SimuUI;

import javax.swing.SwingUtilities;


public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		       new SimuUI("Simulateur de foule - JAVA - Dimitri BUHON - Reda NADIRE - Rachid OUADI");
		    }
		});

	}

}
