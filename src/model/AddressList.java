package model;

import java.io.Serializable;
import java.util.LinkedList;

// AddressList is just an subclass of an LinkedList<Address>
public class AddressList extends LinkedList<Address> implements Serializable {
	private static final long serialVersionUID = -8436170099085318899L;
}
