package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Address;

@SuppressWarnings("serial")
public class AddressView extends JFrame {
	
	// the address to display and the AddressListView in which to display
	private Address address;
	private AddressListView addressListView;

	// the GUI-Fields
	private JTextField nameTextField;
	private JTextField emailaddressTextField;

	//creating an AddressView, filling its fields and setting its visibility and close 
	// operation
	public AddressView(Address address, AddressListView addressListView) {
		this.address = address;
		this.addressListView = addressListView;
		init();
		populateFields();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	private void init() {
		
		// Setting Jframe-title and layout (The Window)
		this.setTitle("Address");
		this.setLayout(new BorderLayout());
		
		// creating a panel and setting its titleborder
		JPanel upperPanel = new JPanel();
		upperPanel.setBorder(BorderFactory.createTitledBorder("Addressinformationen"));
		
		// setting the panels layout
		upperPanel.setLayout(new GridLayout(2, 2, 5, 5));
		
		// creating labels and textfields for the Address-member-variables
		JLabel nameLabel = new JLabel("Name");
		nameTextField = new JTextField();

		JLabel emailaddressLabel = new JLabel("Emailadresse");
		emailaddressTextField = new JTextField();
		
		// adding it all to the panel
		upperPanel.add(nameLabel);
		upperPanel.add(nameTextField);
		upperPanel.add(emailaddressLabel);
		upperPanel.add(emailaddressTextField);
		
		// adding the panel to the JFrame
		this.add(upperPanel, BorderLayout.CENTER);
		
		// creating the SpeicherButton and register an new Listener
		JButton speicherButton = new JButton("Hinterlegen");

		speicherButton.addActionListener(new ActionListener() {
			/**
			 * W�hlen Sie f�r diese anonyme Klasse SpeichernButtonActionListener
			 * als Klassenamen.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				retrieveFields();

				addressListView.addAddress(address);

				Container container = (Container) e.getSource();
				while (!(container instanceof JFrame)) {
					container = container.getParent();
				}
				((JFrame) container).setVisible(false);
				((JFrame) container).dispose();
			}
		});
		
		// adding it to the JFrame
		this.add(speicherButton, BorderLayout.SOUTH);
		
		// packing the whole JFrame(Window) together
		this.pack();
	}
	
	// getting the fields of address which ought to be displayed
	private void populateFields() {
		nameTextField.setText(address.getName());
		emailaddressTextField.setText(address.getEmailaddress());
	}
	
	// setting the fields to the values of the textfields if manipulated
	private void retrieveFields() {
		address.setName(nameTextField.getText());
		address.setEmailaddress(emailaddressTextField.getText());
	}
}
