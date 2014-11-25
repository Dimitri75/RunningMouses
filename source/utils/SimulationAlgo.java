package utils;

import java.util.ArrayList;

import graph.Graph;

public class SimulationAlgo {
	private Graph myGraph;
	private Door door1, door2;
	private ArrayList<Souris> movingMouses = new ArrayList<>();
	
	public SimulationAlgo(Graph myGraph, Door door1, Door door2){
		this.myGraph = myGraph;
		this.door1 = door1;
		this.door2 = door2;
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
	
	
}
