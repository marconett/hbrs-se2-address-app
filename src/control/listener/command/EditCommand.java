package control.listener.command;

import model.AbstractAddress;
import model.AddressList;

public class EditCommand extends AbstractCommand {
	private final AbstractAddress previous;
	
	public EditCommand(final AbstractAddress previous, final AbstractAddress adr){
		super(adr);
		this.previous = previous;
	}

	@Override
	public void undo() {
		System.out.println("EDIT_COMMAND: undoing...");
		AddressList addressList = AddressList.getInstance();
		
		addressList.remove(address);
		addressList.add(previous);

	}

	@Override
	public void execute() {
		System.out.println("EDIT_COMMAND: executing...");
		AddressList addressList = AddressList.getInstance();
		
		if ( addressList.contains(address)){
			addressList.edit(address);
		}

	}

}
