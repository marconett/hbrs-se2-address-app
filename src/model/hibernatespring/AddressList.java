package model.hibernatespring;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.IAbstractAddress;
import model.IAddressList;

// AddressList extends Observable, has a list of addresses
public class AddressList extends Observable implements Serializable, Iterable<IAbstractAddress>, IAddressList {
	private static final long serialVersionUID = -8436170099085318899L;
	
	private List<IAbstractAddress> m_addressList = new LinkedList<IAbstractAddress>();
	private static IAddressList singelton;
	
	
	
	private AddressList(){
		System.out.println("AL: constructing...");
	}
	
	public static IAddressList getInstance(){
		if ( singelton == null){
			synchronized (AddressList.class) {
				if(singelton == null){
					singelton = new AddressList();
				}					
			}			
		}	
		return singelton;
	}

	@Override
	public Iterator<IAbstractAddress> iterator() {
		return this.m_addressList.iterator();
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
	
    @Override
	public boolean add(IAbstractAddress e){
		System.out.println("AL: adding address " + e);
		e.setDirty(true);
		boolean result = m_addressList.add(e);
		notifyObservers();
		return result;		
	}
	
    @Override
	public boolean remove(IAbstractAddress e){
		System.out.println("AL: removing address " + e);
		boolean result = m_addressList.remove(e);
		notifyObservers();
		return result;
	}
	
    @Override
	public boolean contains(IAbstractAddress e){
		System.out.print("AL: checking if address already present....");
		boolean result = m_addressList.contains(e);
		System.out.println(result);
//		notifyObservers();
		return result;
	}

    @Override
	public List<IAbstractAddress> getAddressList() {
		return m_addressList;
	}

    @Override
	public void edit(IAbstractAddress oldData, IAbstractAddress newData ) {
		// TODO Auto-generated method stub
		// changing the fields from old to new
		oldData.setDirty(true);
		oldData.changeTo(newData);
		
		notifyObservers();
	}
	
    @Override
	public void readAll(){
		File inputFile = new File( "address_system.dat" );
        if( !inputFile.exists() ) {
            return;
        }

        AddressList addressList = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {

            fis = new FileInputStream( inputFile );
            in = new ObjectInputStream( fis );
            addressList = ( AddressList ) in.readObject();
            System.out.println("AL: reading in data from " + inputFile);
            addressList.toString();
            in.close();
            
        }
        catch( IOException e ) {
            e.printStackTrace();
            return;
        }
        catch( ClassNotFoundException e ) {
            e.printStackTrace();
            return;
        }

        for( IAbstractAddress address : addressList ) {
        	System.out.println("DEBUG: reading in address: " + address);
            m_addressList.add( address );
            address.setDirty(false);
        }
        
        notifyObservers();
		
	}
	
    @Override
	public void saveAll(){
		
		
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			
			fos = new FileOutputStream( "address_system.dat" );
			out = new ObjectOutputStream(fos);
			System.out.println("AL: writing out data to " + "address_system.dat");
			System.out.println(this.toString());
			out.writeObject(this);			
			out.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		}
		
		for(IAbstractAddress address: this ){
			address.setDirty(false);
		}
		
		notifyObservers();
		
		System.out.println("AL: done writing out data.");
		
	}
	
	@Override
	public String toString(){
		
		System.out.println("AL: printing addresses...");
		
		StringBuffer result = new StringBuffer();
		
		for(IAbstractAddress address: this){
			result.append(address.toString() + "\n");
		}
	
		return result.toString();
		
	}
	
	
	
	
}
