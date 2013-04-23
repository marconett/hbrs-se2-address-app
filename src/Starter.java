import model.AddressList;
import view.AddressListView;

public class Starter {
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Starting Address Application...");		
		AddressList addressList = new AddressList();
		new AddressListView(addressList);
		
		
	}
}
