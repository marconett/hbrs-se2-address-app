package control.listeners;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;

import control.listener.command.CommandInvoker;

public class RedoButtonActionListener extends AbstractAction implements
		Observer {
	
	public RedoButtonActionListener(){
		super();
		
		CommandInvoker.getInstance().addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ACTION: clicked to redo last action...");
		CommandInvoker.getInstance().redo();		
	}

	@Override
	public void update(Observable o, Object arg) {
		CommandInvoker invoker = CommandInvoker.getInstance();
		
		if ( o == invoker){
			setEnabled(invoker.canRedo());
		}

	}

}
