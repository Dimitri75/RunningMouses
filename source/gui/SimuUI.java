package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import map.FrameCard;
import utils.SimulationAlgo;

public class SimuUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea porte1;
	private JTextArea porte2;
	private JTextArea period;

	//Composants Footer
	private JTextField porte1Text;
	private JTextField porte2Text;
	private JTextField vitesseText;
	private ImageIcon image;
	private ImageIcon image2;
	private JButton lancer;
	private JButton pause;
	private JLabel nbTour;
	private JLabel nbDeplacements;
	private JLabel mouseInMov;
	private JLabel mouseArrived;
	
	private JPanel map;
	private JLabel myLabel;

	private SimulationAlgo disjktraAlgo;
	private TimerJob timerJob = null;
	
	private boolean isLaunched = false;

	private FrameCard fc;
	private JFileChooser jfc;
	private String pathToFile = "";

	public SimuUI(String _title) {
		setTitle(_title);

		// Dimensions
		setSize(1600, 900);

		// background setting
		String imagePath = "/res/img/fond.png";
		InputStream imgStream = SimuUI.class.getResourceAsStream(imagePath);
		String imagePath2 = "/res/img/fond2.png";
		InputStream imgStream2 = SimuUI.class.getResourceAsStream(imagePath2);
		image = new ImageIcon();
		image2 = new ImageIcon();
		try {
			image.setImage(ImageIO.read(imgStream));
			image2.setImage(ImageIO.read(imgStream2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Window operations
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new SimuListener());
		setResizable(false);
		// Put in middle of the screen
		setLocationRelativeTo(null);

		// Menu
		JMenuBar myMenuBar = new JMenuBar();
		JMenu myMenuFichier = new JMenu("Fichier");
		JMenuItem myItemOuvrir = new JMenuItem("Ouvrir");
		JMenuItem myItemQuitter = new JMenuItem("Quitter");
		myItemOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"text only", "txt");
				jfc.setFileFilter(filter);
				int returnVal = jfc.showOpenDialog(SimuUI.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					pathToFile = jfc.getSelectedFile().getAbsolutePath();
					fc = new FrameCard(map, myLabel, pathToFile);
					fc.generateEdges();
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
				}
			}
		});

		myItemQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null,
						"Voulez-vous vraiment quitter le programme ?");
				switch (choice) {
				case 0:
					System.exit(0);
				default:
					break;
				}
			}
		});
		myMenuFichier.add(myItemOuvrir);
		myMenuFichier.add(myItemQuitter);
		myMenuBar.add(myMenuFichier);
		setJMenuBar(myMenuBar);

		Container ct = getContentPane();
		Box b = Box.createVerticalBox();
		map = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				if (timerJob != null) {
					this.removeAll();
					fc = new FrameCard(this,timerJob.getDijkstra().getMatriceMouse(), new JLabel(), pathToFile);
					//this.revalidate();
						
				}
				
				GroupLayout jpMyPanelLayout = new javax.swing.GroupLayout(
						this);
				this.setLayout(jpMyPanelLayout);

				jpMyPanelLayout.setHorizontalGroup(jpMyPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 401, Short.MAX_VALUE));

				jpMyPanelLayout.setVerticalGroup(jpMyPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 298, Short.MAX_VALUE));
				this.setPreferredSize(new Dimension(900, 500));
				
			}
		};
		map.setPreferredSize(new Dimension(900, 500));
		myLabel = new JLabel();
		// Footer général de l'appli
		JPanel footer = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
			}
		};
		footer.setLayout(new GridLayout(1, 2));
		// Premier Footer (gauche)
		JPanel footer1 = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
			}
		};
		// Deuxième Footer (droite)
		JPanel footer2 = new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(image2.getImage(), 0, 0, null);
			}
		};
		//Elements footer1
		nbTour = new JLabel("Tour : ");
		nbDeplacements = new JLabel("Déplacements : ");
		mouseInMov = new JLabel("Souris en déplacements : ");
		mouseArrived = new JLabel("Souris arrivées : ");
		
		footer1.add(nbTour);
		footer1.add(nbDeplacements);
		footer1.add(mouseInMov);
		footer1.add(mouseArrived);
		footer.add(footer1);
		
		
		//Elements footer2
		porte1Text = new JTextField("Portes 1: ");
		porte1Text.setEditable(false);
		porte2Text = new JTextField("Portes 2: ");
		porte2Text.setEditable(false);
		vitesseText = new JTextField("Période: ");
		vitesseText.setEditable(false);
		porte1 = new JTextArea(1, 5);
		porte2 = new JTextArea(1, 5);
		period = new JTextArea(1, 10);
		porte1.setText("5");
		porte2.setText("5");
		period.setText("1");
		pause = new JButton("Pause");
		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				timerJob.pause();
			}
		});
		lancer = new JButton("Lancer");
		lancer.addActionListener(new ActionListener() {
			// Démarre la simulation
			public void actionPerformed(ActionEvent arg0) {
				if (!isLaunched) {
					disjktraAlgo = new SimulationAlgo(fc.getMyGraph(), fc.getDoor1(), fc.getDoor2());
					disjktraAlgo.setVertexFromage1(fc.getVertexFromage1());
					disjktraAlgo.setVertexFromage2(fc.getVertexFromage2());
					disjktraAlgo.getDoor1().setSize(Integer.parseInt(porte1.getText()));
					disjktraAlgo.getDoor2().setSize(Integer.parseInt(porte2.getText()));
					disjktraAlgo.setMatrice(fc.getMatrice());

					timerJob = new TimerJob(period.getText());
					timerJob.setComponents(disjktraAlgo, pause, nbTour, nbDeplacements, mouseInMov, mouseArrived);
					isLaunched = true;
				}
				else if(disjktraAlgo.getMovingMouses().size() == disjktraAlgo.getMouseA()){
					fc = new FrameCard(map, myLabel, pathToFile);
					fc.generateEdges();
					disjktraAlgo = new SimulationAlgo(fc.getMyGraph(), fc.getDoor1(), fc.getDoor2());
					disjktraAlgo.setVertexFromage1(fc.getVertexFromage1());
					disjktraAlgo.setVertexFromage2(fc.getVertexFromage2());
					disjktraAlgo.getDoor1().setSize(Integer.parseInt(porte1.getText()));
					disjktraAlgo.getDoor2().setSize(Integer.parseInt(porte2.getText()));
					disjktraAlgo.setMatrice(fc.getMatrice());

					timerJob = new TimerJob(period.getText());
					timerJob.setComponents(disjktraAlgo, pause, nbTour, nbDeplacements, mouseInMov, mouseArrived);
				}
				
			}
			
		});
		
		footer2.add(porte1Text);
		footer2.add(porte1);
		footer2.add(porte2Text);
		footer2.add(porte2);
		footer2.add(vitesseText);
		footer2.add(period);
		footer2.add(lancer);
		footer2.add(pause);

		footer.add(footer2);
		b.add(map);
		b.add(footer);
		ct.add(b);

		// Make visible
		setVisible(true);
	}

}
