package algo.stack;


import java.util.Iterator;

import algo.linkedlist.nodes.LinkSimple;
import algo.stack.exception.StackEmptyException;
import algo.stack.interfaces.ILifo;

public class LinkedStack<V> implements ILifo<V>{
    public LinkSimple<V> myStack = null;
	protected Iterator<V> it;

	public Iterator<V> iterator() {
        return new Iterator<V>(){
        	private int index = 0;
    		private boolean iterated = false;
    		private LinkSimple<V> next;

    		public boolean hasNext() {
    			if (index == size())
    				return false;
    			return true;
    		}

    		public V next() throws IllegalStateException{
    			if(hasNext())
    			{
    				index++;
    				if(iterated)
    				{
    					next = (LinkSimple<V>) next.getNext();
    				}
    				else
    				{
    					iterated = true;
    					next = (LinkSimple<V>) myStack;
    				}		
    				return next.getValue();
    			}
    			else
    				throw new IllegalStateException();
    		}

    		@Override
    		public void remove() throws IllegalStateException{
    			boolean check = false;
    			if(size()==0)
    				throw new IllegalStateException();
    			if (index >0)
    			{
    				
    				if(index == size())
    				{
    					check = true;
    				}
    				else
    				{
    					index--;
    					LinkSimple<V> temp = myStack;
    					for(int i =0; i<index-1;i++)
    					{
    						temp = (LinkSimple<V>) temp.getNext();
    						System.out.println(temp.getValue());
    					}
        				temp.setNext(temp.getNext().getNext());
        				myStack = temp;
        				return;
    				}
    				
    			}
    			else
    			{
    				if(hasNext())
    				{
    					LinkSimple<V> temp =  (LinkSimple<V>) next.getNext();
            			next.setValue(temp.getValue());
            			next.setNext(temp.getNext());	
    				}
    					
    			}
  
				if(check)
				{
					LinkSimple<V> temp = myStack;
					while(temp.getNext().getNext()!= null)
					{
						temp = (LinkSimple<V>) temp.getNext();
					}
					temp.setNext(null);
					return;
				}
    			myStack = (LinkSimple<V>) next.getNext();
    		}
        };
    }

	public boolean isEmpty() {
		if (size() > 0)
			return false;
		else
			return true;
	}

	public V peek() throws StackEmptyException {
		if (!isEmpty())
		{
			return myStack.getValue();
		}
			
		else
			throw new StackEmptyException();
	}

	public V pop() throws StackEmptyException {
		if (!isEmpty())
		{
			V x;
			x = myStack.getValue();
			myStack = (LinkSimple<V>) myStack.getNext();
			return x;	
		}
		else
			throw new StackEmptyException();
	}

	public void push(V arg0) {
		LinkSimple<V> temp = new LinkSimple<V>();
		temp.setValue(arg0);
		temp.setNext(myStack);
		myStack = temp;
		
		
	}

	public int size() {
		int x = 0;
		if(myStack == null)
			return 0;
		LinkSimple<V> temp = myStack;
		while(temp.getNext()!= null)
		{
			x++;
			temp = (LinkSimple<V>) temp.getNext();
		}
		return x+1;
	}

}
