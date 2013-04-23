package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import model.AbstractAddress;
import model.AddressList;

public class DeleteButtonActionListener implements ActionListener {
	
	JList adr_list;
	
	public DeleteButtonActionListener(JList list){
		adr_list = list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object selectedAddress = adr_list.getSelectedValue();
		
		System.out.println("ACTION: clicked to remove address: " + (AbstractAddress)selectedAddress);
		
		AddressList al = AddressList.getInstance();
		al.remove( (AbstractAddress)selectedAddress);		
	}
	
}
