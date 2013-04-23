package control.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import model.AddressList;

public class SaveButtonActionListener implements ActionListener {

	
	private AddressList al;
	
	public SaveButtonActionListener(AddressList al){
		this.al = al;
	}
	
	// Save the addressList-model through
	// writing it out into a file
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("SaveButtonListener: saving AddressList, serializing data");
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream((new Date().getTime() + ".ser"));
			out = new ObjectOutputStream(fos);
			out.writeObject(al);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
