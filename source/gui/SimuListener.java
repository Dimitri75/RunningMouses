package source.gui;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class SimuListener extends WindowAdapter {

	public void windowClosing(WindowEvent e) {
		int choice = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter le programme ?");
		switch(choice)
		{
			case 0 : System.exit(0);
			default : break;
		}
		
	}


}