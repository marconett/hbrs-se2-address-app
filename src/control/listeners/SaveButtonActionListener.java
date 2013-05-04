package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import model.spring.AddressList;

public class SaveButtonActionListener implements ActionListener {
	
	public SaveButtonActionListener(){
		super();
	}
	
	// Save the addressList-model through
	// writing it out into a file
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ACTION: clicked to save data to disk, serializing data...");
		AddressList.getInstance().saveAll();
	}

}
