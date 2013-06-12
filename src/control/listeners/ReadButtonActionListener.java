package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BeansFactory;



public class ReadButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ACTION: clicked to read data from disk...");
		BeansFactory.getIAddressList().readAll();
	}

}
