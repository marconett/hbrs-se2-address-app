package control.strategy;

import model.AbstractAddress;
import model.PostalAddress;

public class HighBudgetStrategy implements MessageSendStrategy {
	
	private final LowBudgetStrategy FALLBACK = new LowBudgetStrategy();

	@Override
	public String strategyName() {
		// TODO Auto-generated method stub
		return "High Budget";
	}

	@Override
	public void sendMessageTo(String msg, AbstractAddress address) {
		// TODO Auto-generated method stub
		if ( address instanceof PostalAddress)
			System.out.println("Sending Postal Mail: " + msg + " To: " + address);
		else
			FALLBACK.sendMessageTo(msg, address);			
	}

}
