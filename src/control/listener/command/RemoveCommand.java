package control.listener.command;

import model.spring.AbstractAddress;
import model.spring.AddressList;

public class RemoveCommand extends AbstractCommand {
	
	public RemoveCommand(final AbstractAddress adr){
		super(adr);
	}

	@Override
	public void undo() {
		System.out.println("REMOVE_COMMAND: undoing...");
		AddressList.getInstance().add(address);
	}

	@Override
	public void execute() {
		System.out.println("REMOVE_COMMAND: executing...");
		AddressList.getInstance().remove(address);
	}

}
