package control.listener.command;

import model.BeansFactory;
import model.IAbstractAddress;
import model.IAddressList;

public class EditCommand extends AbstractCommand {
	
	private final IAbstractAddress previousData;
	private final IAbstractAddress changedData;
	
	public EditCommand( final IAbstractAddress previousData, final IAbstractAddress address){
		super(address);
		this.previousData = previousData;
		
		try{
			changedData = (IAbstractAddress)address.clone();
		}
		catch (CloneNotSupportedException e1){
			throw new IllegalStateException("Can't clone address");
		}
	}

	@Override
	public void undo() {
		
		System.out.println("EDIT_COMMAND: undoing...");
		IAddressList addressList = BeansFactory.getIAddressList();
		
		if ( addressList.contains(address)){
			addressList.edit(address, previousData);
			
		}
		//addressList.add(previous);

	}

	@Override
	public void execute() {
		System.out.println("EDIT_COMMAND: executing...");
		IAddressList addressList = BeansFactory.getIAddressList();
		
		if ( addressList.contains(address)){
			addressList.edit(address, changedData);
		}

	}

}
