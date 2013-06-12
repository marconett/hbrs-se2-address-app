package control.strategy;

import model.IAbstractAddress;

public class LowBudgetStrategy implements MessageSendStrategy {

	@Override
	public String strategyName() {
		// TODO Auto-generated method stub
		return "Low Budget";
	}

	@Override
	public void sendMessageTo(String msg, IAbstractAddress address) {
		System.out.println("MESSAGE_SENDER: sending Email: " + msg + " TO: " + address);		
	}

}
