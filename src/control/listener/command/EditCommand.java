package control.listener.command;

import model.spring.AbstractAddress;
import model.spring.AddressList;

public class EditCommand extends AbstractCommand {
	
	private final AbstractAddress previousData;
	private final AbstractAddress changedData;
	
	public EditCommand( final AbstractAddress previousData, final AbstractAddress address){
		super(address);
		this.previousData = previousData;
		
		try{
			changedData = (AbstractAddress)address.clone();
		}
		catch (CloneNotSupportedException e1){
			throw new IllegalStateException("Can't clone address");
		}
	}

	@Override
	public void undo() {
		
		System.out.println("EDIT_COMMAND: undoing...");
		AddressList addressList = AddressList.getInstance();
		
		if ( addressList.contains(address)){
			addressList.edit(address, previousData);
			
		}
		//addressList.add(previous);

	}

	@Override
	public void execute() {
		System.out.println("EDIT_COMMAND: executing...");
		AddressList addressList = AddressList.getInstance();
		
		if ( addressList.contains(address)){
			addressList.edit(address, changedData);
		}

	}

}
