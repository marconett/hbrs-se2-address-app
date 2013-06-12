package control.strategy;

import model.hibernatespring.AbstractAddress;

public interface MessageSendStrategy {
	
	String strategyName();
	
	void sendMessageTo( String msg, AbstractAddress address);

}
