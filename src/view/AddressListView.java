package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import control.listeners.AddEmailButtonActionListener;
import control.listeners.AddPostalActionListener;
import control.listeners.DeleteButtonActionListener;
import control.listeners.DoubleClickListener;
import control.listeners.ReadButtonActionListener;
import control.listeners.RedoButtonActionListener;
import control.listeners.SaveButtonActionListener;
import control.listeners.SendButtonActionListener;
import control.listeners.UndoButtonActionListener;
import control.strategy.HighBudgetStrategy;
import control.strategy.LowBudgetStrategy;
import control.strategy.MessageSender;

import model.IAbstractAddress;
import model.IAddressList;

import model.BeansFactory;

import view.AbstractAddressView;
import view.decorator.AddressDecorator;

@SuppressWarnings("serial")
public class AddressListView extends JFrame implements Observer {
	
	
	// member fields, the AddressList to display and a ListModel        
        private IAddressList addressList = (IAddressList) BeansFactory.getIAddressList();
        
	private DefaultListModel listModel;

	// create a AddressListView
	public AddressListView() {
		System.out.println("ALV: constructing....");
		BeansFactory.getIAddressList().addObserver(this);
		
		init();
		populateFields();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// Setting up the view
	private void init() {
		System.out.println("ALV: initilazing...");

		// setting Jframe (Window) title and layout
		this.setTitle("Address-List");
		this.setLayout(new GridBagLayout());
		
		// creating the constraints and setting values for the JScrollPane
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 5;
		constraints.weighty = 0.9;
		constraints.weightx = 0.9;

		// creating the JScrollPane
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Mouse Listener
		list.addMouseListener(new DoubleClickListener(this));	
		
		JScrollPane scrollpane = new JScrollPane(list);
		
		// adding the JScrollPane to the JFrame with its specific constraints
		this.add(scrollpane, constraints);
		
		
		//// Creating and Adding the Email Panel
		
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.weightx = 0;
		constraints.weighty = 0;
		
		JPanel emailPanel = new JPanel();
		emailPanel.setBorder(BorderFactory.createTitledBorder("Emails"));
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.LINE_AXIS));
				
		final AddressListView alv = this;
		
		// creating a addButton and registering a new listener
		JButton addEmailButton = new JButton("Add Email ");
		addEmailButton.setMaximumSize(getPreferredSize());
		addEmailButton.addActionListener(new AddEmailButtonActionListener(alv));
			
		// changing the constraints to go with the buttons
		// adding the button to the JFrame		
		JButton addPostalButton = new JButton("Add Postal");
		addPostalButton.setMaximumSize(getPreferredSize());
		addPostalButton.addActionListener(new AddPostalActionListener(alv));		
				
		emailPanel.add(addEmailButton, constraints);
		emailPanel.add(addPostalButton, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		
		add(emailPanel, constraints);
		
		
		// Creating and Adding the IO-Panel
		
		JPanel ioPanel = new JPanel();
		ioPanel.setBorder(BorderFactory.createTitledBorder("Save & Load"));
		ioPanel.setLayout(new BoxLayout(ioPanel, BoxLayout.LINE_AXIS));

		// creating a saveButton and readButton registering a new listener
		JButton saveButton = new JButton("Save all");
		//saveButton.setAlignmentX(CENTER_ALIGNMENT);
		saveButton.setMaximumSize(getPreferredSize());
		saveButton.addActionListener(new SaveButtonActionListener());
		
		JButton readButton = new JButton("Read all");
		//readButton.setAlignmentX(CENTER_ALIGNMENT);
		readButton.setMaximumSize(getPreferredSize());
		readButton.addActionListener(new ReadButtonActionListener());
		
		ioPanel.add(saveButton);
		ioPanel.add(readButton);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
							
		add(ioPanel, constraints);
		
		/// Creating and Adding the Strategy-Panel
		
		JPanel strategyPanel = new JPanel();
		strategyPanel.setBorder(BorderFactory.createTitledBorder("Strategy"));
		strategyPanel.setLayout(new BoxLayout(strategyPanel, BoxLayout.LINE_AXIS));
		
		//Buttons
		JRadioButton lowBudgetButton = new JRadioButton("low Budget");
		JRadioButton highBudgetButton = new JRadioButton("high Budget");
		
		// registering listeners for the radio Buttons
		
		lowBudgetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MessageSender.setMessageSenderStrategy( new LowBudgetStrategy());
				System.out.println("ACTION: clicked to change strategy to low budget");
			}
		});
		
		highBudgetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MessageSender.setMessageSenderStrategy( new HighBudgetStrategy());
				System.out.println("ACTION: clicked to change strategy to high budget");
			}
		});
		
		// adding them to the Panel
		strategyPanel.add(lowBudgetButton);
		strategyPanel.add(highBudgetButton);
		
		// inital values
		lowBudgetButton.setSelected(true);
		MessageSender.setMessageSenderStrategy(new LowBudgetStrategy());
		
		// creating the sendButton including listener
		JButton sendButton = new JButton("Send Mails");
		sendButton.addActionListener(new SendButtonActionListener());
		
		strategyPanel.add(sendButton);
		
		// binding the radioButtons exclusively through a ButtonGroup
		ButtonGroup group = new ButtonGroup();
		group.add(lowBudgetButton);
		group.add(highBudgetButton);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		
		add(strategyPanel, constraints);
		
		// Creating the Command Panel
		
		JPanel commandPanel = new JPanel();
		commandPanel.setBorder(BorderFactory.createTitledBorder("Commands"));
		commandPanel.setLayout(new BoxLayout(commandPanel, BoxLayout.LINE_AXIS));
		
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setAlignmentX(CENTER_ALIGNMENT);
		deleteButton.setMaximumSize(getMinimumSize());
		deleteButton.addActionListener( new DeleteButtonActionListener(list));
		
		JButton undoButton = new JButton("Undo");
		undoButton.setAlignmentX(CENTER_ALIGNMENT);
		deleteButton.setMaximumSize(getPreferredSize());
		undoButton.addActionListener(new UndoButtonActionListener());
		
		JButton redoButton = new JButton("Redo");
		redoButton.setAlignmentX(CENTER_ALIGNMENT);
		redoButton.setMaximumSize(getPreferredSize());
		redoButton.addActionListener(new RedoButtonActionListener());
		
		commandPanel.add(deleteButton);
		commandPanel.add(undoButton);
		commandPanel.add(redoButton);
		
		constraints.gridx = 3;
		constraints.gridy = 0;		
		
		add(commandPanel, constraints);		
				
		// packing the whole window together		
		
		this.pack();
	}

	// filling the ListModel with addresses
	private void populateFields() {
		System.out.println("ALV: populating fields...");
		refreshAddressList();
	}

	// getting the addresses from the model
	private void refreshAddressList() {

		System.out.println("ALV: refreshing view...");
		listModel.removeAllElements();
		for (IAbstractAddress address : addressList.getAddressList()) {
			listModel.addElement(new AddressDecorator(address));
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("ALV: updating...");
		populateFields();
	}	
	
}
