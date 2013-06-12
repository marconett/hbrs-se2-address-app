package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BeansFactory;
import model.IPostalAddress;
import view.AddressListView;
import view.PostalAddressView;

public class AddPostalActionListener implements ActionListener {
	
	private AddressListView alv;
	
	public AddPostalActionListener(AddressListView alv){
		this.alv = alv;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ACTION: clicked to add new PostalAddress...");
		IPostalAddress address = (IPostalAddress) BeansFactory.getIPostalAddress();
		new PostalAddressView(alv, address);
	}

}
