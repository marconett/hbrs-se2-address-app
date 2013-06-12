package test;

import view.decorator.AddressDecorator;
import model.IEmailOnlyAddress;
import model.IPostalAddress;
import junit.framework.TestCase;
import model.BeansFactory;

public class ModelTest extends TestCase {
	
	private IEmailOnlyAddress emailAddress; 
 	private IPostalAddress postalAddress; 

	protected void setUp() throws Exception {	    
		super.setUp(); 
	 	                 
	    emailAddress =  BeansFactory.getIEmailOnlyAddress(); 
        emailAddress.setName( "emailname" ); 
	    emailAddress.setEmailaddress( "email" ); 
	 	                 
	    postalAddress = BeansFactory.getIPostalAddress(); 
	 	postalAddress.setName( "postalname" ); 
	 	postalAddress.setEmailaddress( "email" ); 
		postalAddress.setStraße( "strasse" ); 
		postalAddress.setHausnummer( "42" ); 
	 	postalAddress.setPlz( "54321" ); 
	 	postalAddress.setOrt( "Milkyway" ); 
	 	
	 	BeansFactory.getIAddressList().add(emailAddress);
	 	BeansFactory.getIAddressList().add(postalAddress);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		
	}
	
	public void testWithDecorator() { 
		assertFalse( "Address is marked dirty", emailAddress.toString().startsWith(">") ); 
		assertFalse( "Address is marked dirty", postalAddress.toString().startsWith(">") ); 
	            
		AddressDecorator decoratedEmail = new AddressDecorator(emailAddress); 
		AddressDecorator decoratedPostal = new AddressDecorator(postalAddress); 
	      
		assertTrue( "Address is marked dirty", decoratedEmail.toString().startsWith(">")); 
		assertTrue( "Address is marked dirty", decoratedPostal.toString().startsWith(">") ); 
    } 
	
	public void testWithoutDecorator() { 
		 assertFalse( "Address is marked dirty", emailAddress.toString().startsWith(">") ); 
		 assertFalse( "Address is marked dirty", postalAddress.toString().startsWith(">") ); 
     } 
	 
	 

}
