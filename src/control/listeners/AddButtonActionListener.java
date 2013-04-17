package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddressListView;
import view.AddressView;

import model.Address;

public class AddButtonActionListener implements ActionListener {

	
	private AddressListView alv;
	
	public AddButtonActionListener(AddressListView alv){
		this.alv = alv;
	}
	
	
	@Override
	// create a new empty address and an addressView
	// link the addressView to the addressListView
	public void actionPerformed(ActionEvent arg0) {
		Address address = new Address();
		new AddressView(address, alv);
	}

}
