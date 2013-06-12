package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BeansFactory;

import view.AddressListView;
import view.EmailOnlyAddressView;


import model.IEmailOnlyAddress;

public class AddEmailButtonActionListener implements ActionListener {

	
	private AddressListView alv;
	
	public AddEmailButtonActionListener(AddressListView alv){
		this.alv = alv;
	}
	
	
	@Override
	// create a new empty address and an addressView
	// link the addressView to the addressListView
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ACTION: clicked to add new EmailOnlyAddress...");
        IEmailOnlyAddress address = (IEmailOnlyAddress) BeansFactory.getIEmailOnlyAddress();
		new EmailOnlyAddressView(alv, address);
	}

}
