package utils;

import java.util.ArrayList;
import java.util.List;

import graph.Graph;
import graph.Vertex;

public class SimulationAlgo {
	private Graph myGraph;
	private Vertex vertexFromage1;
	private Vertex vertexFromage2;
	
	private char[][] matrice;
	private char[][] matriceMouse;
	
	private int nbDep = 0;
	private int mouseA = 0;
	
	private Door door1, door2;
	private ArrayList<Souris> movingMouses = new ArrayList<>();
	
	public SimulationAlgo(Graph myGraph, Door door1, Door door2){
		this.myGraph = myGraph;
		this.door1 = door1;
		this.door2 = door2;
	}
	
	public char[][] getMatriceMouse() {
		return matriceMouse;
	}
	
	public Graph getMyGraph() {
		return myGraph;
	}

	public void setMyGraph(Graph myGraph) {
		this.myGraph = myGraph;
	}

	public Door getDoor1() {
		return door1;
	}

	public void setDoor1(Door door1) {
		this.door1 = door1;
	}

	public Door getDoor2() {
		return door2;
	}

	public void setDoor2(Door door2) {
		this.door2 = door2;
	}

	public ArrayList<Souris> getMovingMouses() {
		return movingMouses;
	}

	public void setMovingMouses(ArrayList<Souris> movingMouses) {
		this.movingMouses = movingMouses;
	}

	public char[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(char[][] matrice) {
		this.matrice = matrice;
		matriceMouse = new char[matrice.length][matrice[0].length];
		for(int i = 0; i < matrice.length; i++)
			for(int j =0; j < matrice[0].length; j++)
				matriceMouse[i][j] = ' ';
	}
	
	// Utilisation de Djisktra pour mettre a jour les positions des souris
	public void moveMovingMouses(){
		List<Vertex> path1, path2;
		
		//On boucle sur toutes les souris en mouvement
		for(Souris m : movingMouses)
		{
			//On boucle sur tous les vertex de notre graph
			for(Vertex v : myGraph.getListVertex())
			{
				//On recupere le vertex correspondant à la position de la souris
				if(v.getX() == m.getX() && v.getY() == m.getY())
				{
					//On calcule son chemin une seule fois
					if(!m.isPathCalculated())
					{
						//On calcule les chemins jusqu'aux des fromages
						System.out.println("Calcul des chemins pour la souris en ("+m.getX()+","+m.getY()+")");
						path1 = myGraph.dijkstra(v, vertexFromage1);
						System.out.println("Path 1 :"+path1.size());
						path2 = myGraph.dijkstra(v, vertexFromage2);
						System.out.println("Path 2 :"+path2.size());
						if(path1.size() < path2.size())
							m.setMyPath(path1);
						else
							m.setMyPath(path2);
						m.setPathCalculated(true);
					}
					
					//On fait avancer la souris dans son path
					matriceMouse[m.getX()][m.getY()] = ' ';
					if(m.getIndexPath() < m.getMyPath().size())
					{
						nbDep++;
						m.setX(m.getMyPath().get(m.getIndexPath()).getX());
						m.setY(m.getMyPath().get(m.getIndexPath()).getY());
						m.setIndexPath(m.getIndexPath()+1);
						matriceMouse[m.getX()][m.getY()] = 'M';
					}
					else
					{
						if(movingMouses.size() < 1)
						{
							movingMouses.clear();
							break;
						}
						else
						{
							movingMouses.remove(m);
							mouseA++;
						}
						
					}
					

					
				}
			}
			if(movingMouses.size() < 1)
				break;
		}
	}
	public void setVertexFromage1(Vertex vertexFromage1) {
		this.vertexFromage1 = vertexFromage1;
	}

	public void setVertexFromage2(Vertex vertexFromage2) {
		this.vertexFromage2 = vertexFromage2;
	}

	public void spawnAllPossibleMouses(Door d){
		Souris tempSouris;
		// X - 1 & Y + 1
		if(matrice[d.getX() - 1][d.getY() + 1] != '*' && (matriceMouse[d.getX() - 1][d.getY() + 1] != 'M'))
		{
			tempSouris = d.spawn(d.getX() - 1, d.getY() + 1);
			if(tempSouris != null)
			{
				movingMouses.add(tempSouris);
				matriceMouse[d.getX() - 1][d.getY() + 1] = 'M';
			}		
		}
		// X & Y + 1
		if(matrice[d.getX()][d.getY() + 1] != '*' && (matriceMouse[d.getX()][d.getY() + 1] != 'M'))
		{
			tempSouris = d.spawn(d.getX(), d.getY() + 1);
			if(tempSouris != null)
			{
				movingMouses.add(tempSouris);
				matriceMouse[d.getX()][d.getY() + 1] = 'M';
			}	
		}
		// X + 1 & Y + 1
		if(matrice[d.getX() + 1][d.getY() + 1] != '*' && (matriceMouse[d.getX() + 1][d.getY() + 1] != 'M'))
		{
			tempSouris = d.spawn(d.getX() + 1, d.getY() + 1);
			if(tempSouris != null)
			{
				movingMouses.add(tempSouris);
				matriceMouse[d.getX() + 1][d.getY() + 1] = 'M';
			}	
		}
		// X - 1 & Y
		if(matrice[d.getX() - 1][d.getY()] != '*' && (matriceMouse[d.getX() - 1][d.getY()] != 'M'))
		{
			tempSouris = d.spawn(d.getX() - 1, d.getY());
			if(tempSouris != null)
			{
				movingMouses.add(tempSouris);
				matriceMouse[d.getX() - 1][d.getY()] = 'M';
			}	
		}
		// X - 1 & Y - 1
		if(matrice[d.getX() - 1][d.getY() - 1] != '*' && (matriceMouse[d.getX() - 1][d.getY() - 1] != 'M'))
		{
			tempSouris = d.spawn(d.getX() - 1, d.getY() - 1);
			if(tempSouris != null)
			{
				movingMouses.add(tempSouris);
				matriceMouse[d.getX() - 1][d.getY() - 1] = 'M';
			}	
		}
		// X + 1  & Y
		if(matrice[d.getX() + 1][d.getY()] != '*' && (matriceMouse[d.getX() + 1][d.getY()] != 'M'))
		{
			tempSouris = d.spawn(d.getX() + 1, d.getY());
			if(tempSouris != null)
			{
				movingMouses.add(tempSouris);
				matriceMouse[d.getX() + 1][d.getY()] = 'M';
			}	
		}
		// X + 1 & Y - 1
		if(matrice[d.getX() + 1][d.getY() - 1] != '*' && (matriceMouse[d.getX() + 1][d.getY() - 1] != 'M'))
		{
			tempSouris = d.spawn(d.getX() + 1, d.getY() - 1);
			if(tempSouris != null)
			{
				movingMouses.add(tempSouris);
				matriceMouse[d.getX() + 1][d.getY() - 1] = 'M';
			}	
		}
		// X & Y - 1
		if(matrice[d.getX()][d.getY() - 1] != '*' && (matriceMouse[d.getX()][d.getY() - 1] != 'M'))
		{
			tempSouris = d.spawn(d.getX(), d.getY() - 1);
			if(tempSouris != null)
			{
				movingMouses.add(tempSouris);
				matriceMouse[d.getX()][d.getY() - 1] = 'M';
			}	
		}
	}

	public int getNbDep() {
		return nbDep;
	}

	public void setNbDep(int nbDep) {
		this.nbDep = nbDep;
	}

	public int getMouseA() {
		return mouseA;
	}

	public void setMouseA(int mouseA) {
		this.mouseA = mouseA;
	}
}
