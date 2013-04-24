package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

// AddressList extends Observable, has a list of addresses
public class AddressList extends Observable implements Serializable, Iterable<AbstractAddress> {
	private static final long serialVersionUID = -8436170099085318899L;
	
	private static LinkedList<AbstractAddress> addressList = new LinkedList<AbstractAddress>();
	private static AddressList singelton;
	
	
	
	private AddressList(){
		System.out.println("AL: constructing...");
	}
	
	public static AddressList getInstance(){
		if ( singelton == null){
			singelton = new AddressList();
			return singelton;
			}	
		else
			return singelton;
	}

	@Override
	public Iterator<AbstractAddress> iterator() {
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
		System.out.println("AL: notifying observers...");
//		System.out.println(addressList.toString());
		setChanged();
		super.notifyObservers();
	}
	
	public boolean add(AbstractAddress e){
		System.out.println("AL: adding address " + e);
		boolean result = addressList.add(e);
		notifyObservers();
		return result;		
	}
	
	public boolean remove(AbstractAddress e){
		System.out.println("AL: removing address " + e);
		boolean result = addressList.remove(e);
		notifyObservers();
		return result;
	}
	
	public boolean contains(AbstractAddress e){
		System.out.print("AL: checking if address already present....");
		boolean result = addressList.contains(e);
		System.out.println(result);
//		notifyObservers();
		return result;
	}

	public LinkedList<AbstractAddress> getAddressList() {
		return addressList;
	}

	public void edit(AbstractAddress oldData, AbstractAddress newData ) {
		// TODO Auto-generated method stub
		// address already has been edited no need to do stuff
		addressList.get(addressList.indexOf(oldData)).changeTo(newData);
		
		notifyObservers();
	}
	
	
	
	
}
