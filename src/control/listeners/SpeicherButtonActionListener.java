package control.listeners;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import control.listener.command.AddCommand;
import control.listener.command.CommandInvoker;
import control.listener.command.EditCommand;
import model.BeansFactory;
import model.IAbstractAddress;
import model.IAddressList;
import view.AbstractAddressView;



public class SpeicherButtonActionListener implements ActionListener {
		
	private AbstractAddressView av;
	private IAbstractAddress address;
	
	
	public SpeicherButtonActionListener(AbstractAddressView av){
		this.av = av;
		this.address = av.getAddress();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ACTION: clicked to save or edit Address...");
		IAddressList al = BeansFactory.getIAddressList();
				
		if (al.contains(address)){
			IAbstractAddress previousData;
			try{
				previousData = (IAbstractAddress)address.clone();
			}
			catch (CloneNotSupportedException e1){
				throw new IllegalStateException("Can't clone address");
			}
			// this does the editing
			av.retrieveFields();
			CommandInvoker.getInstance().invoke( new EditCommand(previousData, address) );
		}
		else{
			av.retrieveFields();
			CommandInvoker.getInstance().invoke( new AddCommand(address));
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
