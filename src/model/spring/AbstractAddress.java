package model.spring;

import java.io.Serializable;
import model.IAbstractAddress;

public abstract class AbstractAddress implements Serializable, Cloneable, IAbstractAddress {

	private static final long serialVersionUID = 6780532528672421304L;
	
	// member fields for the address
	private String name;
	private String emailaddress;
	private transient boolean dirty; 

	public AbstractAddress() {
		System.out.println("AA: constructing...");
		name = "";
		emailaddress = "";
	}
	
	// initializing the values
	

    @Override
	public void setName(String name) {
		this.name = name;
	}

    @Override
	public String getName() {
		return name;
	}

    @Override
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

    @Override
	public String getEmailaddress() {
		return emailaddress;
	}
	
    @Override
	public void setDirty(boolean bool){
		dirty = bool;
	}
	
    @Override
	public boolean isDirty(){
		return dirty;
	}
	
	// overriding the toString()-method
	public String toString() {
		return String.format("%s, %s, ", name, emailaddress);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		AbstractAddress clone = (AbstractAddress)super.clone();
		
		clone.copyOf (this);
		return clone;
	}
	
	// needs to be extended in subclasses
	protected void copyOf(final AbstractAddress address){
		name = address.getName();
		emailaddress = address.getEmailaddress();
	}
	
	// needs to be extended in subclass
	public void changeTo(AbstractAddress newData){
		this.name = newData.getName();
		this.emailaddress = newData.getEmailaddress();
	}
}
