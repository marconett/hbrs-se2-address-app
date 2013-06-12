package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import control.listener.command.CommandInvoker;
import control.listener.command.RemoveCommand;

import model.IAbstractAddress;


public class DeleteButtonActionListener implements ActionListener {
	
	JList adr_list;
	
	public DeleteButtonActionListener(JList list){
		adr_list = list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object selectedAddress = adr_list.getSelectedValue();
		
		System.out.println("ACTION: clicked to remove address: " + (IAbstractAddress)selectedAddress);
		
		if( ( selectedAddress != null) && (selectedAddress instanceof IAbstractAddress)){
			CommandInvoker.getInstance().invoke( new RemoveCommand( (IAbstractAddress)selectedAddress));
		}
			
	}
	
}
