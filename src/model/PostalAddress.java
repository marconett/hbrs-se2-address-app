package model;

public class PostalAddress extends AbstractAddress {

	
	private static final long serialVersionUID = 2859543943396233532L;
	
	private String straße;
	private String hausnummer;
	private String plz;
	private String ort;
	
	
	public PostalAddress() {
		// TODO Auto-generated constructor stub
		super();
		straße = "";
		hausnummer = "";
		plz = "";
		ort = "";
		System.out.println("constructing postal address");
	}


	public String getStraße() {
		return straße;
	}


	public void setStraße(String straße) {
		this.straße = straße;
	}


	public String getHausnummer() {
		return hausnummer;
	}


	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}


	public String getPlz() {
		return plz;
	}


	public void setPlz(String plz) {
		this.plz = plz;
	}


	public String getOrt() {
		return ort;
	}


	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	@Override
	public String toString(){
		return super.toString() + String.format(" %s %s %s %s", straße, hausnummer, plz , ort);
	}
	
	

}
