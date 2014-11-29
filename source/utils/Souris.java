package utils;

import graph.Vertex;

import java.util.List;

public class Souris {
	private int x;
	private int y;
	private List<Vertex> myPath;
	private int indexPath = 0;
	private boolean isPathCalculated = false;
	
	public Souris(){
		setX(0);
		setY(0);
	}
	
	public Souris(int _x, int _y){
		setX(_x);
		setY(_y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public List<Vertex> getMyPath() {
		return myPath;
	}

	public void setMyPath(List<Vertex> myPath) {
		this.myPath = myPath;
	}

	public int getIndexPath() {
		return indexPath;
	}

	public void setIndexPath(int indexPath) {
		this.indexPath = indexPath;
	}

	public boolean isPathCalculated() {
		return isPathCalculated;
	}

	public void setPathCalculated(boolean isPathCalculated) {
		this.isPathCalculated = isPathCalculated;
	}
}
