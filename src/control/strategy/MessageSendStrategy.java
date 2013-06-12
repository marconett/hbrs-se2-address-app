package control.strategy;

import model.IAbstractAddress;

public interface MessageSendStrategy {
	
	String strategyName();

	void sendMessageTo(String msg, IAbstractAddress address);

}
