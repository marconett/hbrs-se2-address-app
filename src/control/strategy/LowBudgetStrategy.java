package control.strategy;

import model.AbstractAddress;

public class LowBudgetStrategy implements MessageSendStrategy {

	@Override
	public String strategyName() {
		// TODO Auto-generated method stub
		return "Low Budget";
	}

	@Override
	public void sendMessageTo(String msg, AbstractAddress address) {
		System.out.println("Sending Email: " + msg + " To: " + address);		
	}

}
