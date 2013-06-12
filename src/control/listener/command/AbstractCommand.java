package control.listener.command;

import model.IAbstractAddress;

public abstract class AbstractCommand {
	protected final IAbstractAddress address;
	
	public AbstractCommand(IAbstractAddress adr){
		address = adr;
	}
	
	public abstract void undo();
	
	public abstract void execute();
	
	public void redo(){
		execute();
	}
	
}
