package utils;

import algo.stack.LinkedStack;
import algo.stack.exception.StackEmptyException;

public class Door {
	private LinkedStack<Souris> lot;
	private int x;
	private int y;
	
	public Door(){
		lot = new LinkedStack<Souris>();
		x = 0;
		y = 0;
	}
	
	public Door(int _x, int _y){
		lot = new LinkedStack<Souris>();
		x = _x;
		y= _y;
	}
	
	public Door(int size, int _x, int _y){
		this(_x, _y);
		for(int i =0; i<size;i++)
		{
			this.add(new Souris(-1,-1));
		}
	}
	
	public void setSize(int size){
		for(int i =0; i<size;i++)
		{
			this.add(new Souris(-1,-1));
		}
	}
	
	private void add(Souris _s){
		lot.push(_s);
	}
	
	
	//Methode pour spawn les souris, choisis directement le premier slot libre 
	public Souris spawn(){
		Souris temp = null;
		try {
			temp = lot.pop();
		} catch (StackEmptyException e) {
			return null;
		}
		/*
		 * Code pour set les coordonnées de la souris à afficher
		temp.setX(0);
		temp.setY(0);
		*/
		return temp;
		
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

	public int getSize(){
		return lot.size();
	}

}
