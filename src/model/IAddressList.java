package model;

import java.util.Iterator;
import java.util.List;
import java.util.Observer;

import view.AddressListView;

public interface IAddressList {

    boolean add(IAbstractAddress e);

    boolean contains(IAbstractAddress e);

    void edit(IAbstractAddress oldData, IAbstractAddress newData);

    List<IAbstractAddress> getAddressList();

    Iterator<IAbstractAddress> iterator();

    void readAll();

    boolean remove(IAbstractAddress e);

    void saveAll();	

	void addObserver(Observer o);
    
}
