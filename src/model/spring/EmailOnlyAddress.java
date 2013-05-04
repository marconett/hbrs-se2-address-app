package model.spring;

import model.IEmailOnlyAddress;

public class EmailOnlyAddress extends AbstractAddress implements IEmailOnlyAddress {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4246166081727039473L;

	public EmailOnlyAddress(){
		super();
		System.out.println("EOA: constructing...");		
	}
	
	
	
	

}
