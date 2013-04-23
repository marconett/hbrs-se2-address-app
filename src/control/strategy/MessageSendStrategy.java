package control.strategy;

import model.AbstractAddress;

public interface MessageSendStrategy {
	
	String strategyName();
	
	void sendMessageTo( String msg, AbstractAddress address);

}
