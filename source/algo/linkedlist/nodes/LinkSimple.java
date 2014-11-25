package algo.linkedlist.nodes;

import algo.linkedlist.nodes.interfaces.ILinkSimple;

public class LinkSimple<V> implements ILinkSimple<V>{
	protected V value;
	protected LinkSimple<V> next;
	
	public LinkSimple() {
		value = null;
		next = null;
	}
	public ILinkSimple<V> getNext() {
		
		return next;
	}

	public V getValue() {
		return value;
	}

	public void setNext(ILinkSimple<V> arg0) {
		next = (LinkSimple<V>) arg0;
		
	}

	public void setValue(V arg0) {
		value = arg0;
		
	}

}
