package control.listeners;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Address;

import view.AddressListView;
import view.AddressView;

public class SpeicherButtonActionListener implements ActionListener {
	
	AddressListView alv;
	AddressView av;
	Address a;
	
	
	public SpeicherButtonActionListener(AddressListView alv, AddressView av, 
										Address a){
		this.alv = alv;
		this.av = av;
		this.a = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// get the input from the AddressView and
		// add the Address to the AddressList
		av.retrieveFields();
		alv.addAddress(a);

		// close the Window
		Container container = (Container) e.getSource();
		while (!(container instanceof JFrame)) {
			container = container.getParent();
		}
		((JFrame) container).setVisible(false);
		((JFrame) container).dispose();
	}

}
