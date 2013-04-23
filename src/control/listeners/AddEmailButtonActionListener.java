package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddressListView;
import view.AddressView;

import model.Address;

public class AddEmailButtonActionListener implements ActionListener {

	
	private AddressListView alv;
	
	public AddEmailButtonActionListener(AddressListView alv){
		this.alv = alv;
	}
	
	
	@Override
	// create a new empty address and an addressView
	// link the addressView to the addressListView
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Add new email address...");
		Address address = new Address();
		new AddressView(address, alv);
	}

}
