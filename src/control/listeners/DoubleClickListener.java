package control.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JList;

import model.IAbstractAddress;
import model.IEmailOnlyAddress;
import model.IPostalAddress;
import view.AbstractAddressView;
import view.AddressListView;
import view.EmailOnlyAddressView;
import view.PostalAddressView;
import view.decorator.AddressDecorator;

public class DoubleClickListener extends MouseAdapter {
	
	private AddressListView alv;
	
	public DoubleClickListener(AddressListView alv){
		this.alv = alv;
		
	}

	public void mouseClicked(MouseEvent e) {
	    if (e.getClickCount() == 2) {
	       int index = ((JList) e.getSource()).locationToIndex(e.getPoint());
	        if (index == -1)
	             System.out.println("Sie haben nichts ausgewählt.");
	        else {
	        	
	        	 System.out.println("ACTION: selected address via mouse...");
	             AddressDecorator decorator = (AddressDecorator) ((JList) e.getSource()).getSelectedValue();
	             
	             // Ihr Code
	             if ( decorator.getUndecoratedAddress() instanceof IEmailOnlyAddress)
	            	 new EmailOnlyAddressView(alv, (IEmailOnlyAddress)decorator.getUndecoratedAddress());
	             
	             else if ( decorator.getUndecoratedAddress() instanceof IPostalAddress)
	            	 new PostalAddressView(alv, (IPostalAddress)decorator.getUndecoratedAddress());
	             else
	            	 System.out.println("No such AddressType");
	       }
	    }
	}

}
