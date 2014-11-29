package utils;

import java.util.ArrayList;

import graph.Graph;

public class SimulationAlgo {
	private Graph myGraph;
	private char[][] matrice;
	private char[][] matriceMouse;
	
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
	
	
	public void moveMovingMouses(){
		// Utilisation de Djisktra pour mettre a jour les positions des souris
		for(Souris m : movingMouses)
		{
				
		}
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
}
