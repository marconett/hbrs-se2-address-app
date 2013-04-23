package control.listeners;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.AbstractAddress;
import model.AddressList;
import view.AbstractAddressView;
import view.AddressListView;


public class SpeicherButtonActionListener implements ActionListener {
	
	protected AddressListView alv;
	protected AbstractAddressView av;
	protected AbstractAddress address;
	
	
	public SpeicherButtonActionListener(AddressListView alv, AbstractAddressView av){
		this.alv = alv;
		this.av = av;
		this.address = av.getAddress();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ACTION: saving or editing Address...");
		
		
		/* Debug
		if(address == null)
			System.out.println("a ist null");
		*/
		AddressList al = AddressList.getInstance();
		if (!al.contains(address)){
			av.retrieveFields();
			al.add(address);
			System.out.println("ACTION: address has been added");
		}
		else{
			// get the input from the AddressView
			//changing the already present address
			av.retrieveFields();
			System.out.println("ACTION: address has been modified");
		}			

		// close the Window
		Container container = (Container) e.getSource();
		while (!(container instanceof JFrame)) {
			container = container.getParent();
		}
		((JFrame) container).setVisible(false);
		((JFrame) container).dispose();
	}

}
