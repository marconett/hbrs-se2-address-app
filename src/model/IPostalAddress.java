package model;

public interface IPostalAddress extends IAbstractAddress {

    String getHausnummer();

    String getOrt();

    String getPlz();

    String getStraße();

    void setHausnummer(String hausnummer);

    void setOrt(String ort);

    void setPlz(String plz);

    void setStraße(String straße);
    
}
