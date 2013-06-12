package control.listener.command;

import model.BeansFactory;
import model.IAbstractAddress;

public class RemoveCommand extends AbstractCommand {
	
	public RemoveCommand(IAbstractAddress adr){
		super(adr);
	}

	@Override
	public void undo() {
		System.out.println("REMOVE_COMMAND: undoing...");
		BeansFactory.getIAddressList().add(address);
	}

	@Override
	public void execute() {
		System.out.println("REMOVE_COMMAND: executing...");
		BeansFactory.getIAddressList().remove(address);
	}

}
