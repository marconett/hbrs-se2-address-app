package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.strategy.MessageSender;

import view.AddressListView;

public class SendButtonActionListener implements ActionListener {
	
	public SendButtonActionListener(){
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ACTION: clicked to send message to all...");
		MessageSender.sendMessageToAll("This is a Test");
	}

}
