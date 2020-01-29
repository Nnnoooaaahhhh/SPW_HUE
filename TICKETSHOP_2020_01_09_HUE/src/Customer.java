
public class Customer {

	String Geschlecht;
	static int id;
	String Vorname;
	String Nachname;
	String Adresse;
	String pw;
	
	
	@SuppressWarnings("static-access")
	Customer(String Geschlecht, int id, String Vorname, String Nachname, String Adresse, String pw){
		this.Geschlecht=Geschlecht;
		this.id=id;
		this.Vorname=Vorname;
		this.Nachname=Nachname;
		this.Adresse=Adresse;
		this.pw=pw;
	}
	
}
