package model;

public interface IAbstractAddress {

    String getEmailaddress();

    String getName();

    boolean isDirty();

    void setDirty(boolean bool);

    void setEmailaddress(String emailaddress);

    void setName(String name);
    
}
