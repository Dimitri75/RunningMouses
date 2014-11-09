package source.main;

import javax.swing.SwingUtilities;

import source.gui.SimuUI;


public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		       new SimuUI("Simulateur de foule - JAVA - Dimitri BUYON - Reda NADIRE - Rachid OUADI");
		    }
		});

	}

}
