package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

// AddressList is just an subclass of an LinkedList<Address>
public class AddressList extends Observable implements Serializable, Iterable<Address> {
	private static final long serialVersionUID = -8436170099085318899L;
	
	private LinkedList<Address> addressList = new LinkedList<Address>();
	
	public AddressList(){
		System.out.println("constructing AddressList");
	}

	@Override
	public Iterator<Address> iterator() {
		return addressList.iterator();
	}

	@Override
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		super.addObserver(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		System.out.println("AL: notifying observers");
		setChanged();
		super.notifyObservers();
	}
	
	public boolean add(Address e){
		System.out.println("AL: adding address");
		boolean result = addressList.add(e);
		notifyObservers();
		return result;		
	}
	
	
}
