package source.utils;

public class Souris {
	private int x;
	private int y;
	
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
}
