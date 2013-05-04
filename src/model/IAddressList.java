package model;

import model.spring.AbstractAddress;
import java.util.Iterator;
import java.util.List;

public interface IAddressList {

    boolean add(AbstractAddress e);

    boolean contains(AbstractAddress e);

    void edit(AbstractAddress oldData, AbstractAddress newData);

    List<AbstractAddress> getAddressList();

    Iterator<AbstractAddress> iterator();

    void readAll();

    boolean remove(AbstractAddress e);

    void saveAll();
    
}
