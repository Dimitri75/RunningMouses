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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utils.Door;
import utils.Souris;

public class Map {
	private int nbLigne = 0;
	private int nbColonne = 0;
	
	private JLabel myLabel;
	private JPanel myMap;
	
	private char[][] matrice;
	private Graph myGraph = new Graph();
	
	private Door door1, door2;
	private Vertex vertexFromage1, vertexFromage2;
	private boolean isFirstFromage = true;
	private boolean isFirstDoor = true;

	public Map(JPanel map, JLabel _myLabel, String pathToFile) {
		this.myMap = map;
		this.myLabel = _myLabel;

		String urlFromage = "src/res/img/fromage.png";
		String urlPorte = "src/res/img/porte.png";
		String urlHerbe = "src/res/img/herbe.png";
		String urlMur = "src/res/img/mur.png";
		String urlVide = "src/res/img/vide.png";

		matrice = myMatrice(pathToFile);
		char result;
		// Remplissage du JPanel
		for (int y = 0; y < nbColonne; y++) {
			for (int x = 0; x < nbLigne; x++) {
				Vertex v;
				result = matrice[x][y];
				switch (result) {
				// Mur
				case ('*'):
					myLabel = new JLabel(new ImageIcon(urlMur));
					myLabel.setSize(100, 100);
					myLabel.setLocation(y * 32, x * 32);
					break;
				// Zone de déplacement
				case (' '):
					myLabel = new JLabel(new ImageIcon(urlVide));
					myLabel.setSize(100, 100);
					myLabel.setLocation(y * 32, x * 32);
					v = new Vertex(x, y, myGraph);
					break;
				// Zone d'herbe
				case ('G'):
					myLabel = new JLabel(new ImageIcon(urlHerbe));
					myLabel.setSize(100, 100);
					myLabel.setLocation(y * 32, x * 32);
					v = new Vertex(x, y, myGraph);
					break;
				// Fromage
				case ('A'):
					if (isFirstFromage) {
						vertexFromage1 = new Vertex(x, y, myGraph);
						isFirstFromage = false;
					} else
						vertexFromage2 = new Vertex(x, y, myGraph);
					myLabel = new JLabel(new ImageIcon(urlFromage));
					myLabel.setSize(100, 100);
					myLabel.setLocation(y * 32, x * 32);
					break;
				// Porte
				case ('D'):
					if (isFirstDoor) {
						door1 = new Door(x, y);
						isFirstDoor = false;
					} else
						door2 = new Door(x, y);

					myLabel = new JLabel(new ImageIcon(urlPorte));
					myLabel.setSize(100, 100);
					myLabel.setLocation(y * 32, x * 32);
					break;
				}
				myMap.add(myLabel);
			}
		}
		myMap.setPreferredSize(new Dimension(1176, 664));
	}

	public Vertex getVertexFromage1() {
		return vertexFromage1;
	}

	public Vertex getVertexFromage2() {
		return vertexFromage2;
	}

	// Constructeur qui affiche les souris en meme temps
	public Map(JPanel map, char[][] mouseTable, ArrayList<Souris> movingMouses, JLabel _myLabel,
			String pathToFile) {
		myMap = map;
		myLabel = _myLabel;

		String urlFromage = "src/res/img/fromage.png";
		String urlSabelette = "src/res/img/sabelette.png";
		String urlBlueMouse = "src/res/img/blueMouse.png";
		String urlCyanMouse = "src/res/img/cyanMouse.png";
		String urlGreenMouse = "src/res/img/greenMouse.png";
		String urlRedMouse = "src/res/img/redMouse.png";
		String urlWhiteMouse = "src/res/img/whiteMouse.png";
		String urlPorte = "src/res/img/porte.png";
		String urlHerbe = "src/res/img/herbe.png";
		String urlMur = "src/res/img/mur.png";
		String urlVide = "src/res/img/vide.png";

		matrice = myMatrice(pathToFile);
		char result;
		// Remplissage du JPanel
		for (int y = 0; y < nbColonne; y++) {
			for (int x = 0; x < nbLigne; x++) {
				Vertex v;
				result = matrice[x][y];
				
				if (mouseTable[x][y] == 'M') {
					for(Souris m : movingMouses)
					{
						if(m.getX() == x && m.getY() == y)
							switch(m.getImageIdentifier())
							{
								case "0":
									myLabel = new JLabel(new ImageIcon(urlSabelette));
									break;
								case "1":
									myLabel = new JLabel(new ImageIcon(urlBlueMouse));
									break;
								case "2":
									myLabel = new JLabel(new ImageIcon(urlCyanMouse));
									break;
								case "3":
									myLabel = new JLabel(new ImageIcon(urlGreenMouse));
									break;
								case "4":
									myLabel = new JLabel(new ImageIcon(urlRedMouse));
									break;
								case "5":
									myLabel = new JLabel(new ImageIcon(urlWhiteMouse));
									break;
							}
					}
					
					myLabel.setSize(100, 100);
					myLabel.setLocation(y * 32, x * 32);
				} else {
					switch (result) {
					// Mur
					case ('*'):
						myLabel = new JLabel(new ImageIcon(urlMur));
						myLabel.setSize(100, 100);
						myLabel.setLocation(y * 32, x * 32);
						break;
					// Zone de déplacement
					case (' '):
						myLabel = new JLabel(new ImageIcon(urlVide));
						myLabel.setSize(100, 100);
						myLabel.setLocation(y * 32, x * 32);
						break;
					// Zone d'herbe
					case ('G'):
						myLabel = new JLabel(new ImageIcon(urlHerbe));
						myLabel.setSize(100, 100);
						myLabel.setLocation(y * 32, x * 32);
						break;
					// Fromage
					case ('A'):
						myLabel = new JLabel(new ImageIcon(urlFromage));
						myLabel.setSize(100, 100);
						myLabel.setLocation(y * 32, x * 32);
						break;
					// Porte
					case ('D'):
						myLabel = new JLabel(new ImageIcon(urlPorte));
						myLabel.setSize(100, 100);
						myLabel.setLocation(y * 32, x * 32);
						break;
					}
					
				}
				myMap.add(myLabel);
			}
			myMap.setPreferredSize(new Dimension(1176, 664));
		}
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
		String line = "";
		int nbColumns = 0;

		int nbLines = 0;
		// Lecture du fichier texte
		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);

			while ((line = br.readLine()) != null) {
				// Nombre de lignes
				nbLines++;

				// Contient toute la map.txt
				chaine += line;

				// Nombre de colonnes
				nbColumns = line.length();
			}
			br.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		matrice = new char[nbLines][nbColumns];
		int x = 0;
		int y = 0;
		// Remplissage de la matrice
		for (int i = 0; i < chaine.length(); i++) {
			// Incrémentation de ligne une fois tous les caractères de celle-ci parcourus
			if (y == nbColumns) {
				x++;
				y = 0;
			}
			
			matrice[x][y] = chaine.charAt(i);
			
			// Incrementation de la colonne a chaque passage
			y++;
		}
		
		this.nbColonne = nbColumns;
		this.nbLigne = nbLines;
		
		return matrice;
	}
	public boolean checkMatrice(char[][] m, int ligne, int colonne) {
        int countCol = 0;
        int countLig = 0;

        while (colonne > countCol) {
            //Premiere Ligne
            if (m[0][countCol] != '*') {
                char c = m[0][countCol];
                return false;
            }
            //Derniere Ligne
            if (m[ligne-1][countCol] != '*') {
                char c = m[ligne-1][countCol];
                return false;
            }
            countCol++;
        }

        while (ligne > countLig) {
            //Premiere Colonne
            if (m[countLig][0] != '*') {
                char c = m[countLig][0];
                return false;
            }
            //Derniere Colonne
            if (m[countLig][colonne-1] != '*') {
                char c = m[countLig][colonne-1];
                return false;
            }
            countLig++;
        }

        return true;
    }

	public void generateEdges() {
		char tile;
		for (int y = 1; y < nbColonne ; y++) {
			for (int x = 1; x < nbLigne ; x++) {
				
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
					if (matrice[x - 1][y] == ' ' || matrice[x - 1][y] == 'G'
							|| matrice[x - 1][y] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x - 1 && v.getY() == y)
								target = v;
						}
						e = new Edge(source, target, EnumKey.NORMAL, myGraph);
						e = new Edge(target, source, EnumKey.NORMAL, myGraph);
					}
					if (matrice[x][y - 1] == ' ' || matrice[x][y - 1] == 'G'
							|| matrice[x][y - 1] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x && v.getY() == y - 1)
								target = v;
						}
						e = new Edge(source, target, EnumKey.NORMAL, myGraph);
						e = new Edge(target, source, EnumKey.NORMAL, myGraph);
					}
					break;
				case ('G'):
					if (matrice[x - 1][y] == ' ' || matrice[x - 1][y] == 'G'
							|| matrice[x - 1][y] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x - 1 && v.getY() == y)
								target = v;
						}
						e = new Edge(source, target, EnumKey.GRASS, myGraph);
						e = new Edge(target, source, EnumKey.GRASS, myGraph);
					}
					if (matrice[x][y - 1] == ' ' || matrice[x][y - 1] == 'G'
							|| matrice[x][y - 1] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x && v.getY() == y - 1)
								target = v;
						}

						e = new Edge(source, target, EnumKey.GRASS, myGraph);
						e = new Edge(target, source, EnumKey.GRASS, myGraph);
					}
					break;
				case ('A'):
					if (matrice[x - 1][y] == ' ' || matrice[x - 1][y] == 'G'
					|| matrice[x - 1][y] == 'A') {
						for (Vertex v : myGraph.getListVertex()) {
							if (v.getX() == x - 1 && v.getY() == y)
								target = v;
						}
						e = new Edge(source, target, EnumKey.NORMAL, myGraph);
						e = new Edge(target, source, EnumKey.NORMAL, myGraph);
					}
				if (matrice[x][y - 1] == ' ' || matrice[x][y - 1] == 'G'
						|| matrice[x][y - 1] == 'A') {
					for (Vertex v : myGraph.getListVertex()) {
						if (v.getX() == x && v.getY() == y - 1)
							target = v;
					}
					e = new Edge(source, target, EnumKey.NORMAL, myGraph);
					e = new Edge(target, source, EnumKey.NORMAL, myGraph);
				}
					break;
				default:
					break;
				}
			}
		}
	}
	
	public int getNbLigne() {
		return nbLigne;
	}

	public void setNbLigne(int nbLigne) {
		this.nbLigne = nbLigne;
	}

	public int getNbColonne() {
		return nbColonne;
	}

	public void setNbColonne(int nbColonne) {
		this.nbColonne = nbColonne;
	}

	public Graph getMyGraph() {
		return myGraph;
	}
}
