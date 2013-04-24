package control.listener.command;

import java.util.LinkedList;
import java.util.Observable;
import control.listener.command.AbstractCommand;;

public class CommandInvoker extends Observable {
	private static CommandInvoker singelton;
	
	public static CommandInvoker getInstance(){
		if (singelton == null ){
			singelton = new CommandInvoker();
			return singelton;
			}
		else
			return singelton;		
	}
	
	private CommandInvoker(){
		// Singleton
	}
	
	private LinkedList<AbstractCommand> history = new LinkedList<AbstractCommand>();
	// index of the last executed command
	private int current = -1;
	
	public void invoke(AbstractCommand command){
		if(canRedo()){
			// remove all right of the current index
			for(int i = (history.size() - 1); i > current; i-- ){
				history.remove( i );
			}
		}
		
		history.add( command );
		current++;
		
		command.execute();
		
		setChanged();
		notifyObservers();
	}
	
	public void undo(){
		if ( canUndo() ){
			
			history.get(current).undo();
			current--;
			
			setChanged();
			notifyObservers();			
		}
		
		
	}
	
	public void redo(){
		if ( canRedo() ){
			current++;
			history.get(current).redo();
			
			
			setChanged();
			notifyObservers();
		}
	}
	
	public boolean canUndo(){
		return (current >= 0) && (current < history.size());
	}
	
	public boolean canRedo(){
		return !history.isEmpty() && (current + 1) < history.size();
	}	
}
