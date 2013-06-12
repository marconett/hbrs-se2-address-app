package control.strategy;

import model.IAbstractAddress;
import model.IPostalAddress;

public class HighBudgetStrategy implements MessageSendStrategy {
	
	private final LowBudgetStrategy FALLBACK = new LowBudgetStrategy();

	@Override
	public String strategyName() {
		// TODO Auto-generated method stub
		return "High Budget";
	}

	@Override
	public void sendMessageTo(String msg, IAbstractAddress address) {
		// TODO Auto-generated method stub
		if ( address instanceof IPostalAddress)
			System.out.println("MESSAGE_SENDER: sending Postal Mail: " + msg + " TO: " + address);
		else
			FALLBACK.sendMessageTo(msg, address);			
	}

}
