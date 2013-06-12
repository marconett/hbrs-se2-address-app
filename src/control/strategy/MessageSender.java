package control.strategy;

import model.BeansFactory;
import model.IAbstractAddress;
import model.IAddressList;

public class MessageSender {
	
	private static MessageSendStrategy strategy;
	
	private MessageSender(){
		
	}
	
	public static void setMessageSenderStrategy( MessageSendStrategy str){
		strategy = str;
	}
	
	public static void sendMessageToAll(String msg){
		System.out.println("ACTION: starting to send messages ENABLED_OPTION: " + strategy.strategyName());
		for( IAbstractAddress address: BeansFactory.getIAddressList().getAddressList()){
			strategy.sendMessageTo(msg, address);
		}
	}
}
