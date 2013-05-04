package control.strategy;

import model.spring.AbstractAddress;

public class LowBudgetStrategy implements MessageSendStrategy {

	@Override
	public String strategyName() {
		// TODO Auto-generated method stub
		return "Low Budget";
	}

	@Override
	public void sendMessageTo(String msg, AbstractAddress address) {
		System.out.println("MESSAGE_SENDER: sending Email: " + msg + " TO: " + address);		
	}

}
