package utils;

import graph.Vertex;

import java.util.List;

public class Souris {
	private int x;
	private int y;
	private List<Vertex> myPath;
	private int indexPath = 0;
	private int moveMinor = 0;
	private String imageIdentifier = "1";
	
	private boolean grassMinor = false;
	private boolean isPathCalculated = false;
	private boolean mouseArrived = false;
	

	public Souris(){
		setX(0);
		setY(0);
	}
	
	public Souris(int _x, int _y){
		setX(_x);
		setY(_y);
	}
	
	public boolean isGrassMinor() {
		return grassMinor;
	}

	public void setGrassMinor(boolean grassMinor) {
		this.grassMinor = grassMinor;
	}
	
	public int getCollisionMinor() {
		return moveMinor;
	}

	public void setCollisionMinor(int collisionMinor) {
		this.moveMinor = collisionMinor;
	}
	
	public String getImageIdentifier() {
		return imageIdentifier;
	}

	public void setImageIdentifier(String imageIdentifier) {
		this.imageIdentifier = imageIdentifier;
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
	
	public boolean isMouseArrived() {
		return mouseArrived;
	}

	public void setMouseArrived(boolean mouseArrived) {
		this.mouseArrived = mouseArrived;
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
