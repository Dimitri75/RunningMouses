package utils;

import algo.stack.LinkedStack;
import algo.stack.exception.StackEmptyException;

public class Porte {
	
	private LinkedStack<Souris> lot;
	private int x;
	private int y;
	
	public Porte(){
		lot = new LinkedStack<Souris>();
		x = 0;
		y = 0;
	}
	
	public Porte(int _x, int _y){
		lot = new LinkedStack<Souris>();
		x = _x;
		y= _y;
	}
	
	public Porte(int size, int _x, int _y){
		this(_x, _y);
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
		 * Code pour set les coordonn�es de la souris � afficher
		temp.setX(0);
		temp.setY(0);
		*/
		return temp;
		
	}
	
	public int getSize(){
		return lot.size();
	}

}
