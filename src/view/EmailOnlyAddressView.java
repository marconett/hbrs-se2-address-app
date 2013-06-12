package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.IEmailOnlyAddress;
import model.IEmailOnlyAddress;

@SuppressWarnings("serial")
public class EmailOnlyAddressView extends AbstractAddressView {
	
	// the address to display and the AddressListView in which to display
	private  IEmailOnlyAddress address;
	
	// the GUI-Fields
	private JTextField nameTextField;
	private JTextField emailaddressTextField;

	//creating an AddressView, filling its fields and setting its visibility and close 
	// operation
	public EmailOnlyAddressView(AddressListView addressListView, IEmailOnlyAddress address2) {
		super(addressListView, address2);
		System.out.println("EOAV: constructing...");
		this.address = address2;
		
		populateFields();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	protected void init() {
		
		System.out.println("EOAV: initializing...");
		// Setting Jframe-title and layout (The Window)
		setTitle("Email Address");
						
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
		add(upperPanel, BorderLayout.CENTER);
		
		
		
	}
	
	// getting the fields of address which ought to be displayed
	protected void populateFields() {
		System.out.println("EOAV: populating fields...");
		nameTextField.setText(address.getName());
		emailaddressTextField.setText(address.getEmailaddress());
	}
	
	// setting the fields to the values of the textfields if manipulated
	public void retrieveFields() {
//		System.out.println("EOAV: retrieving fields " + nameTextField.getText() + " " + emailaddressTextField.getText() );
		if (address == null)
			System.out.println("address ist null");
		address.setName(nameTextField.getText());
		address.setEmailaddress(emailaddressTextField.getText());
	}
}
