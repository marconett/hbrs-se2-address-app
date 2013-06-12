package view.decorator;

import model.IAbstractAddress;
import model.IEmailOnlyAddress;
import java.io.Serializable;

public class AddressDecorator implements IAbstractAddress, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8812849184508076771L;
	protected final IAbstractAddress address;
	
	
	
	public AddressDecorator( final IAbstractAddress emailAddress){
		this.address = emailAddress;
	}
	
	public IAbstractAddress getUndecoratedAddress(){
		return address;
	}
	
	@Override
	public String toString(){
		
		StringBuffer result = new StringBuffer();
		
		if(address.isDirty())
			result.append("> ");
		else
			result.append("");
		
		return result.append(address.toString()).toString();
		
	}

	public void changeTo(IAbstractAddress newData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String getEmailaddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDirty(boolean bool) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmailaddress(String emailaddress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
