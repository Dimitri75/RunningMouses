package utils;

import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimulationAlgo {
	private Graph myGraph;
	private Vertex vertexFromage1;
	private Vertex vertexFromage2;
	
	private char[][] matrice;
	private char[][] matriceMouse;
	
	private int nbDep = 0;
	private int mouseA = 0;
	
	private Door door1, door2;
	private HashMap<Vertex, List<Vertex>> listPaths = new HashMap<>();

	private ArrayList<Souris> movingMouses = new ArrayList<>();
	
	public SimulationAlgo(Graph myGraph, Door door1, Door door2, Vertex firstDestination, Vertex secondDestination){
		this.myGraph = myGraph;
		this.door1 = door1;
		this.door2 = door2;
		this.vertexFromage1 = firstDestination;
		this.vertexFromage2 = secondDestination;
		
		//Calcul des chemins dijkstra
		for (Vertex v : myGraph.getListVertex()){
			//	D = Door
			//	S = Point de départ (start)
			//					X
			//				  S D X
			//					X
			//Porte 1
			if (v.getX() == door1.getX()-1  && v.getY() == door1.getY()){
				List<Vertex> firstPath = myGraph.dijkstra(v, vertexFromage1);
				List<Vertex> secondPath = myGraph.dijkstra(v, vertexFromage2);

				/*for (int i = 0; i < firstPath.size(); i++){
					System.out.println("Coord("+firstPath.get(i).getX()+", "+firstPath.get(i).getY()+")");
				}*/
				
				if (firstPath.size() >= secondPath.size()){
					listPaths.put(v, firstPath);
				}
				else{
					listPaths.put(v, secondPath);
				}
			}
			
			//Porte 2
			if (v.getX() == door2.getX()-1  && v.getY() == door2.getY()){
				List<Vertex> firstPath = myGraph.dijkstra(v, vertexFromage1);
				List<Vertex> secondPath = myGraph.dijkstra(v, vertexFromage2);
				
				if (firstPath.size() >= secondPath.size()){
					listPaths.put(v, firstPath);
				}
				else{
					listPaths.put(v, secondPath);
				}
			}
			
			//	D = Door
			//	S = Point de départ (start)
			//					X
			//				  X D S
			//					X
			//Porte 1
			if (v.getX() == door1.getX()+1  && v.getY() == door1.getY()){
				List<Vertex> firstPath = myGraph.dijkstra(v, vertexFromage1);
				List<Vertex> secondPath = myGraph.dijkstra(v, vertexFromage2);
				
				if (firstPath.size() >= secondPath.size()){
					listPaths.put(v, firstPath);
				}
				else{
					listPaths.put(v, secondPath);
				}
			}
			
			//Porte2
			if (v.getX() == door2.getX()+1  && v.getY() == door2.getY()){
				List<Vertex> firstPath = myGraph.dijkstra(v, vertexFromage1);
				List<Vertex> secondPath = myGraph.dijkstra(v, vertexFromage2);
				
				if (firstPath.size() >= secondPath.size()){
					listPaths.put(v, firstPath);
				}
				else{
					listPaths.put(v, secondPath);
				}
			}
			
			//	D = Door
			//	S = Point de départ (start)
			//					S
			//				  X D X
			//					X
			//Porte 1
			if (v.getX() == door1.getX()  && v.getY() == door1.getY()+1){
				List<Vertex> firstPath = myGraph.dijkstra(v, vertexFromage1);
				List<Vertex> secondPath = myGraph.dijkstra(v, vertexFromage2);
				
				if (firstPath.size() >= secondPath.size()){
					listPaths.put(v, firstPath);
				}
				else{
					listPaths.put(v, secondPath);
				}
			}
			
			//Porte 2
			if (v.getX() == door2.getX()-1  && v.getY() == door2.getY()+1){
				List<Vertex> firstPath = myGraph.dijkstra(v, vertexFromage1);
				List<Vertex> secondPath = myGraph.dijkstra(v, vertexFromage2);
				
				if (firstPath.size() >= secondPath.size()){
					listPaths.put(v, firstPath);
				}
				else{
					listPaths.put(v, secondPath);
				}
			}
			
			//	D = Door
			//	S = Point de départ (start)
			//					X
			//				  X D X
			//					S
			//Porte 1
			if (v.getX() == door1.getX()-1  && v.getY() == door1.getY()-1){
				List<Vertex> firstPath = myGraph.dijkstra(v, vertexFromage1);
				List<Vertex> secondPath = myGraph.dijkstra(v, vertexFromage2);
				
				if (firstPath.size() >= secondPath.size()){
					listPaths.put(v, firstPath);
				}
				else{
					listPaths.put(v, secondPath);
				}
			}
			
			//Porte 2
			if (v.getX() == door2.getX()-1  && v.getY() == door2.getY()-1){
				List<Vertex> firstPath = myGraph.dijkstra(v, vertexFromage1);
				List<Vertex> secondPath = myGraph.dijkstra(v, vertexFromage2);
				
				if (firstPath.size() >= secondPath.size()){
					listPaths.put(v, firstPath);
				}
				else{
					listPaths.put(v, secondPath);
				}
			}
		}
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
						path1 = myGraph.dijkstra(v, vertexFromage1);
						path2 = myGraph.dijkstra(v, vertexFromage2);
						m.setIndexPath(0);
						if(path1.size() < path2.size())
							m.setMyPath(path1);
						else
							m.setMyPath(path2);
						m.setPathCalculated(true);
					}
					//Si la souris n'est pas arrivé
					if(!m.isMouseArrived())
					{
						// Si la souris a passé le tour sur de lherbe on desactive le blocage
						if(m.isGrassMinor())
							m.setGrassMinor(false);
						//Sinon on la fait avancer
						else
						{
							if(m.getIndexPath()+1 < m.getMyPath().size() && matriceMouse[m.getMyPath().get(m.getIndexPath()+1).getX()][m.getMyPath().get(m.getIndexPath()+1).getY()] == 'M')
							{
								
							}
							else
							{
								//On fait avancer la souris dans son path
								matriceMouse[m.getX()][m.getY()] = ' ';
								//Si elle n'est pas arrivé a la fin

								if(m.getCollisionMinor() == 1)
								{
									m.setCollisionMinor(0);
									m.setIndexPath(m.getIndexPath() + 1 -m.getCollisionMinor());
									m.setX(m.getMyPath().get(m.getIndexPath()).getX());
									m.setY(m.getMyPath().get(m.getIndexPath()).getY());
								}
								else
								{
									m.setIndexPath(m.getIndexPath() + 1);
									if(m.getIndexPath() < m.getMyPath().size())
									{
										m.setX(m.getMyPath().get(m.getIndexPath()).getX());
										m.setY(m.getMyPath().get(m.getIndexPath()).getY());
										if(matrice[m.getX()][m.getY()] == 'G'){
											m.setGrassMinor(true);
											m.setCollisionMinor(1);
										}
										matriceMouse[m.getX()][m.getY()] = 'M';
									}
									else
									{
										mouseA++;
										m.setMouseArrived(true);
									}
								}
								
							}



						}


					}

				}
			}
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
