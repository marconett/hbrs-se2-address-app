package control.listener.command;

import model.spring.AbstractAddress;
import model.spring.AddressList;

public class AddCommand extends AbstractCommand {
	
	public AddCommand(final AbstractAddress adr){
		super(adr);
	}

	@Override
	public void undo() {
		System.out.println("ADD_COMMAND: undoing...");
		AddressList.getInstance().remove(address);
	}

	@Override
	public void execute() {
		System.out.println("ADD_COMMAND: executing...");
		AddressList.getInstance().add(address);
	}

}
