package source.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SimuUI extends JFrame {
	
	private JTextArea porte1;
	private JTextArea porte2;
	private JTextArea vitesse;
	
	private JTextField porte1Text;
	private JTextField porte2Text;
	private JTextField vitesseText;
	
	private ImageIcon image;
	private ImageIcon image2;
	private JButton lancer;
	
	
	public SimuUI(String _title){
		
		setTitle(_title);
		
		//Dimensions
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);
		
		//background setting
		String imagePath = "/res/img/fond.png";
		InputStream imgStream = SimuUI.class.getResourceAsStream(imagePath );
		String imagePath2 = "/res/img/fond2.png";
		InputStream imgStream2 = SimuUI.class.getResourceAsStream(imagePath2 );
		image = new ImageIcon();
		image2 = new ImageIcon();
			try {
				image.setImage(ImageIO.read(imgStream));
				image2.setImage(ImageIO.read(imgStream2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//Window operations
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new SimuListener());
		setResizable(false);
		//Put in middle of the screen
		setLocationRelativeTo(null);
		
		
		Container ct = getContentPane();
		Box b = Box.createVerticalBox();
		// panel map pour la map de Rachid
		JPanel map = new JPanel(){
            private static final long serialVersionUID = 1L;

            
            public void paintComponent(Graphics g)
            {
                g.drawImage(image.getImage(), 0, 0, null);
            }
        };
		// footer de l'appli
		JPanel footer = new JPanel(){
            private static final long serialVersionUID = 1L;

            
            public void paintComponent(Graphics g)
            {
                g.drawImage(image.getImage(), 0, 0, null);
            }
        };
		footer.setLayout(new GridLayout(1 , 2));
		
		JPanel footer1 = new JPanel(){
            private static final long serialVersionUID = 1L;

            
            public void paintComponent(Graphics g)
            {
                g.drawImage(image.getImage(), 0, 0, null);
            }
        };
		JPanel footer2 = new JPanel(){
            private static final long serialVersionUID = 1L;

            
            public void paintComponent(Graphics g)
            {
                g.drawImage(image2.getImage(), 0, 0, null);
            }
        };
		footer.add(footer1);
		porte1Text = new JTextField("Porte 1 : ");
		porte1Text.setEditable(false);
		porte2Text = new JTextField("Porte 2 : ");
		porte2Text.setEditable(false);
		vitesseText = new JTextField("Vitesse : ");
		vitesseText.setEditable(false);
		porte1 = new JTextArea(1,5);
		porte2 = new JTextArea(1,5);
		vitesse = new JTextArea(1,10);
		porte1.setText("30");
		porte2.setText("30");
		vitesse.setText("500");
		lancer = new JButton("Lancer");
		lancer.addActionListener(new ActionListener(){
			//Démarre la simulation
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		footer2.add(porte1Text);
		footer2.add(porte1);
		footer2.add(porte2Text);
		footer2.add(porte2);
		footer2.add(vitesseText);
		footer2.add(vitesse);
		footer2.add(lancer);
		
		footer.add(footer2);
		map.setPreferredSize(new Dimension(700,400));
		b.add(map);
		b.add(footer);
		ct.add(b);
		
		//Make visible
		setVisible(true);
	}

}
