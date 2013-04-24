package control.listeners;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import control.listener.command.CommandInvoker;

public class UndoButtonActionListener extends AbstractAction implements
		Observer {
	
	public UndoButtonActionListener(){
		super();
		
		CommandInvoker.getInstance().addObserver(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ACTION: clicked to undo last action...");
		CommandInvoker.getInstance().undo();
	}

	@Override
	public void update(Observable o, Object arg1) {
		CommandInvoker invoker = CommandInvoker.getInstance();
		
		if ( o == invoker){
			setEnabled(invoker.canUndo());
		}

	}

}
