package control.strategy;

import model.hibernatespring.AbstractAddress;
import model.hibernatespring.AddressList;

public class MessageSender {
	
	private static MessageSendStrategy strategy;
	
	private MessageSender(){
		
	}
	
	public static void setMessageSenderStrategy( MessageSendStrategy str){
		strategy = str;
	}
	
	public static void sendMessageToAll(String msg){
		System.out.println("ACTION: starting to send messages ENABLED_OPTION: " + strategy.strategyName());
		for( AbstractAddress address: AddressList.getInstance()){
			strategy.sendMessageTo(msg, address);
		}
	}
}
