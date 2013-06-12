package model.spring;

import model.IAbstractAddress;
import model.IPostalAddress;

public class PostalAddress extends AbstractAddress implements IPostalAddress {

	
	private static final long serialVersionUID = 2859543943396233532L;
	
	private String straße;
	private String hausnummer;
	private String plz;
	private String ort;
	
	
	public PostalAddress() {
		super();
		straße = "";
		hausnummer = "";
		plz = "";
		ort = "";
		System.out.println("PA: constructing...");
	}


    @Override
	public String getStraße() {
		return straße;
	}


    @Override
	public void setStraße(String straße) {
		this.straße = straße;
	}


    @Override
	public String getHausnummer() {
		return hausnummer;
	}


    @Override
	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}


    @Override
	public String getPlz() {
		return plz;
	}


    @Override
	public void setPlz(String plz) {
		this.plz = plz;
	}


    @Override
	public String getOrt() {
		return ort;
	}


    @Override
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	@Override
	public String toString(){
		return super.toString() + String.format("%s, %s, %s, %s", straße, hausnummer, plz , ort);
	}
	
	@Override
	protected void copyOf( final AbstractAddress address){
		
		super.copyOf(address);
		
		PostalAddress p = (PostalAddress)address;
		
		straße = p.getStraße();
		hausnummer = p.getHausnummer();
		plz = p.getPlz();
		ort = p.getOrt();
	}
	
	@Override
	public void changeTo(AbstractAddress newData){
		
		super.changeTo(newData);
		
		PostalAddress p = (PostalAddress)newData;
		
		this.straße = p.getStraße();
		this.hausnummer = p.getHausnummer();
		this.plz = p.getPlz();
		this.ort = p.getOrt();
		
	}


	@Override
	public void changeTo(IAbstractAddress newData) {
		// TODO Auto-generated method stub
		
	}
	

}
