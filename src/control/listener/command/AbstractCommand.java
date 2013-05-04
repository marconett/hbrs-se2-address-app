package control.listener.command;

import model.spring.AbstractAddress;

public abstract class AbstractCommand {
	protected final AbstractAddress address;
	
	public AbstractCommand(AbstractAddress adr){
		address = adr;
	}
	
	public abstract void undo();
	
	public abstract void execute();
	
	public void redo(){
		execute();
	}
	
}
