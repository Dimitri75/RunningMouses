package source.gui;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.Box;
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


import source.map.FrameCard;


public class SimuUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea porte1;
	private JTextArea porte2;
	private JTextArea vitesse;
	
	private JTextField porte1Text;
	private JTextField porte2Text;
	private JTextField vitesseText;
	
	private ImageIcon image;
	private ImageIcon image2;
	private JButton lancer;
	
	private JPanel map;
	private JLabel myLabel;
	private int nbLigne=0;
    private int nbColonne=0;
	
    private FrameCard fc;
    private JFileChooser jfc;
    private String pathToFile = "";
    
    
	public SimuUI(String _title){
		
		setTitle(_title);
		
		//Dimensions
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(1280,680);
		
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
		
		//Menu
		JMenuBar myMenuBar = new JMenuBar();
		JMenu myMenuFichier = new JMenu("Fichier");
		JMenuItem myItemOuvrir = new JMenuItem("Ouvrir");
		JMenuItem myItemQuitter = new JMenuItem("Quitter");
		myItemOuvrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jfc = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "text only", "txt");
			    jfc.setFileFilter(filter);
			    int returnVal = jfc.showOpenDialog(SimuUI.this);
			    if(returnVal == JFileChooser.APPROVE_OPTION)
			    {
			    	pathToFile = jfc.getSelectedFile().getAbsolutePath();
			    	fc = new FrameCard(map,myLabel,pathToFile);
			    	javax.swing.GroupLayout jpMyPanelLayout = new javax.swing.GroupLayout(map);
			        map.setLayout(jpMyPanelLayout);
			        jpMyPanelLayout.setHorizontalGroup(
			            jpMyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			            .addGap(0, 401, Short.MAX_VALUE)
			        );
			        jpMyPanelLayout.setVerticalGroup(
			            jpMyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			            .addGap(0, 298, Short.MAX_VALUE)
			        );
			    }
			}
		});
		myItemQuitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter le programme ?");
				switch(choice)
				{
					case 0 : System.exit(0);
					default : break;
				}
			}
		});
		myMenuFichier.add(myItemOuvrir);
		myMenuFichier.add(myItemQuitter);
		myMenuBar.add(myMenuFichier);
		setJMenuBar(myMenuBar);
		
		
		Container ct = getContentPane();
		Box b = Box.createVerticalBox();
		// panel map pour la map de Rachid
		map = new JPanel();
		myLabel = new JLabel();
		//Appel de la classe FrameCard pour le dessin de la map
	    fc = new FrameCard(map,myLabel,pathToFile);
		javax.swing.GroupLayout jpMyPanelLayout = new javax.swing.GroupLayout(map);
        map.setLayout(jpMyPanelLayout);
        jpMyPanelLayout.setHorizontalGroup(
            jpMyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        jpMyPanelLayout.setVerticalGroup(
            jpMyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
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
		b.add(map);
		b.add(footer);
		ct.add(b);
		
		//Make visible
		setVisible(true);
	}

}
