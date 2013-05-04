package control.strategy;

import model.spring.AbstractAddress;

public interface MessageSendStrategy {
	
	String strategyName();
	
	void sendMessageTo( String msg, AbstractAddress address);

}
