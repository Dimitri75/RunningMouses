package map;

import graph.Edge;
import graph.EnumKey;
import graph.Graph;
import graph.Vertex;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import utils.Door;

/**
 * 
 * @author Rachid_2
 */
public class FrameCard {
	private int nbLigne = 0;
	private int nbColonne = 0;
	private JLabel myLabel;
	private JPanel jpMyPanel;
	private char[][] matrice;
	private Graph myGraph = new Graph();
	private Door door1, door2;
	private boolean isFirstDoor = true;

	public FrameCard(JPanel map, JLabel _myLabel, String pathToFile) {
		jpMyPanel = map;
		myLabel = _myLabel;
		String urlFromage, urlSabelette, urlPorte, urlHerbe, urlMur, urlVide;
		/*
		 * 
		 * • * : un mur URL MUR • G : une zone d'herbe URL HERBE • ' ' : une
		 * zone de déplacement URL VIDE • D : les points d'apparition des
		 * personnages URL PORTE • A : les points d'arrivée des personnages. URL
		 * FROMAGE
		 */
		urlFromage = "src/res/img/fromage.png";
		urlSabelette = "src/res/img/sabelette.png";
		urlPorte = "src/res/img/porte.png";
		urlHerbe = "src/res/img/herbe.png";
		urlMur = "src/res/img/mur.png";
		urlVide = "src/res/img/vide.png";

		matrice = myMatrice(pathToFile);
		/*
		 * 
		 * • * : un mur URL MUR • G : une zone d'herbe URL HERBE • ' ' : une
		 * zone de déplacement URL VIDE • D : les points d'apparition des
		 * personnages URL PORTE • A : les points d'arrivée des personnages. URL
		 * FROMAGE
		 */
		char result;
		// remplissage du JPanel
		for (int countC = 0; countC < nbColonne; countC++) {
			for (int countL = 0; countL < nbLigne; countL++) {
				Vertex v;
				Vertex y;
				result = matrice[countL][countC];
				switch (result) {
				// si la valeur est '*' on affiche un mur
				// a la localisation x=index de la colonne*22
				// y= index de la ligne*222
				case ('*'):
					myLabel = new JLabel(new ImageIcon(urlMur));
					myLabel.setSize(100, 100);
					myLabel.setLocation(countC * 25, countL * 25);
					break;
				// si la valeur est ' ' on affiche un l'image vide
				// a la localisation x=index de la colonne*22
				// y= index de la ligne*222
				case (' '):
					myLabel = new JLabel(new ImageIcon(urlVide));
					myLabel.setSize(100, 100);
					myLabel.setLocation(countC * 25, countL * 25);
					v = new Vertex(countC, countL, myGraph);
					break;
				// si la valeur est 'G' on affiche de l'herbe
				// a la localisation x=index de la colonne*22
				// y= index de la ligne*222
				case ('G'):
					myLabel = new JLabel(new ImageIcon(urlHerbe));
					myLabel.setSize(100, 100);
					myLabel.setLocation(countC * 25, countL * 25);
					v = new Vertex(countC, countL, myGraph);
					break;
				// si la valeur est 'A' on affiche un fromage
				// a la localisation x=index de la colonne*22
				// y= index de la ligne*222
				case ('A'):
					myLabel = new JLabel(new ImageIcon(urlFromage));
					myLabel.setSize(100, 100);
					myLabel.setLocation(countC * 25, countL * 25);
					v = new Vertex(countC, countL, myGraph);
					break;
				// si la valeur est 'D' on affiche une porte
				// a la localisation x=index de la colonne*22
				// y= index de la ligne*222
				case ('D'):
					if (isFirstDoor) {
						door1 = new Door(countL, countC);
						isFirstDoor = false;
					} else
						door2 = new Door(countL, countC);

					myLabel = new JLabel(new ImageIcon(urlPorte));
					myLabel.setSize(100, 100);
					myLabel.setLocation(countC * 25, countL * 25);
					break;
				}
				jpMyPanel.add(myLabel);
				
			}
		}

		jpMyPanel.setPreferredSize(new Dimension(900, 500));
	}
	
	public FrameCard(JPanel map, char[][] mouseTable, JLabel _myLabel, String pathToFile) {
		jpMyPanel = map;
		myLabel = _myLabel;
		String urlFromage, urlSabelette, urlPorte, urlHerbe, urlMur, urlVide;
		/*
		 * 
		 * • * : un mur URL MUR • G : une zone d'herbe URL HERBE • ' ' : une
		 * zone de déplacement URL VIDE • D : les points d'apparition des
		 * personnages URL PORTE • A : les points d'arrivée des personnages. URL
		 * FROMAGE
		 */
		urlFromage = "src/res/img/fromage.png";
		urlSabelette = "src/res/img/sabelette.png";
		urlPorte = "src/res/img/porte.png";
		urlHerbe = "src/res/img/herbe.png";
		urlMur = "src/res/img/mur.png";
		urlVide = "src/res/img/vide.png";

		matrice = myMatrice(pathToFile);
		/*
		 * 
		 * • * : un mur URL MUR • G : une zone d'herbe URL HERBE • ' ' : une
		 * zone de déplacement URL VIDE • D : les points d'apparition des
		 * personnages URL PORTE • A : les points d'arrivée des personnages. URL
		 * FROMAGE
		 */
		char result;
		// remplissage du JPanel
		for (int countC = 0; countC < nbColonne; countC++) {
			for (int countL = 0; countL < nbLigne; countL++) {
				Vertex v;
				Vertex y;
				result = matrice[countL][countC];
				if(mouseTable[countL][countC] == 'M')
				{
					myLabel = new JLabel(new ImageIcon(urlSabelette));
					myLabel.setSize(100, 100);
					myLabel.setLocation(countC * 25, countL * 25);
				}
				else
				{
					switch (result) {
					// si la valeur est '*' on affiche un mur
					// a la localisation x=index de la colonne*22
					// y= index de la ligne*222
					case ('*'):
						myLabel = new JLabel(new ImageIcon(urlMur));
						myLabel.setSize(100, 100);
						myLabel.setLocation(countC * 25, countL * 25);
						break;
					// si la valeur est ' ' on affiche un l'image vide
					// a la localisation x=index de la colonne*22
					// y= index de la ligne*222
					case (' '):
						myLabel = new JLabel(new ImageIcon(urlVide));
						myLabel.setSize(100, 100);
						myLabel.setLocation(countC * 25, countL * 25);
						v = new Vertex(countC, countL, myGraph);
						break;
					// si la valeur est 'G' on affiche de l'herbe
					// a la localisation x=index de la colonne*22
					// y= index de la ligne*222
					case ('G'):
						myLabel = new JLabel(new ImageIcon(urlHerbe));
						myLabel.setSize(100, 100);
						myLabel.setLocation(countC * 25, countL * 25);
						v = new Vertex(countC, countL, myGraph);
						break;
					// si la valeur est 'A' on affiche un fromage
					// a la localisation x=index de la colonne*22
					// y= index de la ligne*222
					case ('A'):
						myLabel = new JLabel(new ImageIcon(urlFromage));
						myLabel.setSize(100, 100);
						myLabel.setLocation(countC * 25, countL * 25);
						v = new Vertex(countC, countL, myGraph);
						break;
					// si la valeur est 'D' on affiche une porte
					// a la localisation x=index de la colonne*22
					// y= index de la ligne*222
					case ('D'):
						if (isFirstDoor) {
							door1 = new Door(countL, countC);
							isFirstDoor = false;
						} else
							door2 = new Door(countL, countC);

						myLabel = new JLabel(new ImageIcon(urlPorte));
						myLabel.setSize(100, 100);
						myLabel.setLocation(countC * 25, countL * 25);
						break;
					}
				}
				
				jpMyPanel.add(myLabel);
				
			}
		}

		jpMyPanel.setPreferredSize(new Dimension(900, 500));
	}
	public char[][] getMatrice() {
		return matrice;
	}

	public Door getDoor1() {
		return door1;
	}

	public Door getDoor2() {
		return door2;
	}

	public char[][] myMatrice(String url) {
		String chaine = "";
		String fichier = url;
		char[][] matrice;
		String ligne = "";
		String contenu = "";

		int l = 0;
		// lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);

			while ((ligne = br.readLine()) != null) {
				// l++ afin de savoir combien de ligne on a
				l++;
				// afin d'avoir tout le contenu du fichier texte
				// dans une chaine de caractere
				chaine += ligne;
				// afin davoir la taille d'une ligne (donc de nb de colonne ds
				// la matrice)
				// grace a contenu.length();
				contenu = ligne;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		matrice = new char[l][contenu.length()];
		int li = 0;
		int colonne = 0;
		// remplissage de la matrice
		for (int count = 0; count < chaine.length(); count++) {
			// si on arrive a la fin d'une ligne on incremente la ligne
			if (colonne == contenu.length()) {
				li++;
				// count+=colonne;
				colonne = 0;
			}
			matrice[li][colonne] = chaine.charAt(count);
			// incrementation de la colonne a chaque passage
			colonne++;
		}
		nbColonne = contenu.length();
		nbLigne = l;
		return matrice;
	}

	public void generateEdges() {
		char tile;
		for (int x = 0; x <= nbColonne; x++) {
			for (int y = 0; y <= nbLigne; y++) {
				Edge e;
				Vertex source = null;
				Vertex target = null;
				tile = matrice[x][y];

				for (Vertex v : myGraph.getListVertex()) {
					if (v.getX() == x && v.getY() == y)
						source = v;
				}

				switch (tile) {
				case (' '):
					if (matrice[x + 1][y] == ' ' || matrice[x + 1][y] == 'G'
							|| matrice[x + 1][y] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x + 1 && v.getY() == y)
								target = v;
						}
						e = new Edge(source, target, EnumKey.NORMAL, myGraph);
					}
					if (matrice[x][y + 1] == ' ' || matrice[x][y + 1] == 'G'
							|| matrice[x][y + 1] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x && v.getY() == y + 1)
								target = v;
						}
						e = new Edge(source, target, EnumKey.NORMAL, myGraph);
					}
					break;
				case ('G'):
					if (matrice[x + 1][y] == ' ' || matrice[x + 1][y] == 'G'
							|| matrice[x + 1][y] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x + 1 && v.getY() == y)
								target = v;
						}
						e = new Edge(source, target, EnumKey.GRASS, myGraph);
					}
					if (matrice[x][y + 1] == ' ' || matrice[x][y + 1] == 'G'
							|| matrice[x][y + 1] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x && v.getY() == y + 1)
								target = v;
						}

						e = new Edge(source, target, EnumKey.GRASS, myGraph);
					}
					break;
				case ('A'):
					if (matrice[x + 1][y] == ' ' || matrice[x + 1][y] == 'G'
							|| matrice[x + 1][y] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x + 1 && v.getY() == y)
								target = v;
						}
						e = new Edge(source, target, EnumKey.NORMAL, myGraph);
					}
					if (matrice[x][y + 1] == ' ' || matrice[x][y + 1] == 'G'
							|| matrice[x][y + 1] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x && v.getY() == y + 1)
								target = v;
						}

						e = new Edge(source, target, EnumKey.NORMAL, myGraph);
					}
					break;
				default:
					break;
				}
			}
		}
	}

	public Graph getMyGraph() {
		return myGraph;
	}
}
