package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Address;
import view.AddressListView;
import view.AddressView;

public class AddPostalActionListener implements ActionListener {
	
	private AddressListView alv;
	
	public AddPostalActionListener(AddressListView alv){
		this.alv = alv;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Add new postal address...");
		Address address = new Address();
		new AddressView(address, alv);
	}

}
