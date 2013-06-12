package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.IEmailOnlyAddress;
import model.IAbstractAddress;
import model.IPostalAddress;

import control.listeners.SpeicherButtonActionListener;




public abstract class AbstractAddressView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected AddressListView addressListView;
	protected IAbstractAddress address;
	protected JPanel upperPanel;
	protected JButton speicherButton;

	// the Gui-Fields


	public AbstractAddressView(AddressListView alv, IAbstractAddress address2){
		this.addressListView = alv;
		this.address = address2;

		initabstract();		

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);		
	}


	private void initabstract(){
		
		this.setLayout(new BorderLayout());

		upperPanel = new JPanel();
		upperPanel.setLayout(new GridLayout(2, 2, 5, 5 ));

		
		// adding the panel to the JFrame
		this.add(upperPanel, BorderLayout.NORTH);

		// creating the SpeicherButton and register an new Listener
		speicherButton = new JButton("Hinterlegen");
		speicherButton.addActionListener(new SpeicherButtonActionListener(this));


		// adding it to the JFrame
		this.add(speicherButton, BorderLayout.SOUTH);
		
		// the factory method
		init();
		
		// packing the whole JFrame(Window) together
		this.pack();
	}
	
	public IAbstractAddress getAddress(){
		return address;
	}

	
	protected abstract void init();
	
	protected abstract void populateFields();
	
	public abstract void retrieveFields();

}




