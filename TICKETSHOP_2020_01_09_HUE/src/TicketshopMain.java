import java.util.*;

public class TicketshopMain {

	static int menuPoint;
	static int whichTicket;
	static int id = 1;
	static boolean cusCheck = false;
	static int countConcertTicketsMittelklasse = 1000;
	static int countConcertTicketsVorDerBuehne = 500;
	static int countConcertTicketsNebenDerBuehne = 500;
	static int countConcertTicketsGanzWeitHinten = 1500;
	static int countFootballTicketsVIP = 1000;
	static int countFootballTicketsSteh = 20000;
	static int countFootballTicketsSitz = 10000;
	static int countTheatreTicketsLoge = 50;
	static int countTheatreTicketsVorne = 150;
	static int countTheatreTicketsHinten = 300;
	static boolean customerTest;
	
	boolean FootballTest = true;
	
	static Customer cus [] = new Customer [1000];
	static String tic [] [] = new String [1000] [2];
	

	ConcertTicket a;
	ConcertTicket b;
	ConcertTicket c;
	ConcertTicket d;
	FootballTicket e;
	FootballTicket f;
	FootballTicket g;
	TheatreTicket h;
	TheatreTicket i;
	TheatreTicket j;

	public static void main(String[] args) {

		TicketshopMain a = new TicketshopMain();	
		a.fillTickets();
		
		for(int i = 0; i < i + 1; i++) {
			a.menu();
			if(menuPoint == 1) {
				a.getCustomers();
				menuPoint = 2;
			}
			if(menuPoint == 2) {
				a.determineTicket();
				a.ordering();
			}
			if(menuPoint == 3) {
				a.admin();
			}	
		}

	}

	void fillTickets() {
		a = new ConcertTicket("Konzertticket", 50, "Vor der B�hne");
		b = new ConcertTicket("Konzertticket", 30, "Mittelklasse");
		c = new ConcertTicket("Konzertticket", 40, "Neben der B�hne");
		d = new ConcertTicket("Konzertticket", 20, "GAAANZ WEIT HIIIINTEN");
		e = new FootballTicket("Fu�ballticket", 30, "Sitzplatz");
		f = new FootballTicket("Fu�ballticket", 60, "VIP");
		g = new FootballTicket("Fu�ballticket", 15, "Stehplatz");
		h = new TheatreTicket("TheaterTicket", 50, "Loge");
		i = new TheatreTicket("TheaterTicket", 30, "Vorne");
		j = new TheatreTicket("TheaterTicket", 20, "Hinten");
	}

	void getCustomers() {
		Scanner a = new Scanner(System.in);
		String confirmation;
		String Sex;
		String Vorname;
		String Nachname;
		String Stadt;
		String pw;
		for (int i = 0; i < i + 1; i++) {
			System.out.println("Wollen sie einen Benutzer anlegen? (J/N)");
			confirmation = a.next();
			if(confirmation.equals("J")) {
				customerTest = true;
				Scanner h = new Scanner(System.in);
				System.out.println("Bitte Vorname angeben:");
				Vorname = h.next();
				System.out.println("Bitte Nachname angeben:");
				Nachname = h.next();
				System.out.println("Bitte Geschlecht angeben:");
				Sex = h.next();
				System.out.println("Bitte Stadt angeben:");
				Stadt = h.next();
				System.out.println("Bitte Passwort w�hlen:");
				pw = h.next();
				cus[i] = new Customer (Sex, id, Vorname, Nachname, Stadt, pw); 
				cusCheck = true;
				System.out.println("Ihre id lautet " + id);
				id++;
			
			}
			if(confirmation.equals("N")){
				customerTest = false;
			}
			if(!customerTest) {
				break;
			}
		}
	}

	void determineTicket() {
		String Art;
		Scanner s = new Scanner(System.in);
		System.out.println("Welches Ticket m�chten Sie kaufen?");
		System.out.println("Konzertticket / Fu�ballticket / Theaterticket");
		for(int i = 0; i < i + 1; i++) {
			Art = s.next();
			if(Art.equals("Konzertticket")) {
				whichTicket = 1;
				break;
			}
			if(Art.equals("Fu�ballticket")) {
				whichTicket = 2;
				break;
			}	
			if(Art.equals("Theaterticket")) {
				whichTicket = 3;
				break;
			}	
			if(!Art.equals(Ticket.name)) {
				System.out.println("BITTE RECHTSCHREIBUNG KONTROLLIEREN");
			}
		}
	}

	void ordering() {
		String Name;
		String Art = null;
		String Confirmation;
		String temp = "";
		boolean testQuan = true;
		int quantity = 0;
		boolean test = true;
		ShoppingCart a = new ShoppingCart();
		Scanner z = new Scanner(System.in);

		switch (whichTicket) {
		case 1: 
			System.out.println("Konzertticket-> Bitte Art ausw�hlen: (Vor der B�hne / Neben der B�hne / Mittelklasse / GAAANZ WEIT HIIIINTEN)");
			Art = z.nextLine();
			for (int i = 0; i < i + 1; i++) {
				if(!Art.equals(Ticket.position)) {
					System.out.println("NICHT VERF�GBAR!");
					test = false;
					testQuan = false;
					Art = z.nextLine();
				}
				
				
				if(Art.equals("Mittelklasse")) {
					System.out.println("Der Preis bertr�gt: 30");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+ countConcertTicketsMittelklasse + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countConcertTicketsMittelklasse) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
					}
				if(Art.equals("Vor der B�hne")) {
					System.out.println("Der Preis bertr�gt: 50");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+countConcertTicketsVorDerBuehne + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countConcertTicketsVorDerBuehne) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(Art.equals("Neben der B�hne")) {
					System.out.println("Der Preis bertr�gt: 40");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+countConcertTicketsNebenDerBuehne + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countConcertTicketsNebenDerBuehne) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(Art.equals("GAAANZ WEIT HIIIINTEN")) {
					System.out.println("Der Preis bertr�gt: 20");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+countConcertTicketsGanzWeitHinten + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countConcertTicketsGanzWeitHinten) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(!(Art.equals("Mittelklasse")||Art.equals("Vor der B�hne")||Art.equals("Neben der B�hne")||!Art.equals("GAAANZ WEIT HIIIINTEN"))) {
					System.out.println("NICHT VERF�GBAR!");
					test = false;
					testQuan = false;
					Art = z.nextLine();
				}
				if(testQuan) {
					test = true;
					try {
						if(quantity<0) {
							throw new WrongQuantityException();
						}
					}	
					catch(WrongQuantityException e) {
						System.out.println("Nur nat�rliche Zahlen!");
						test = false;
					}
				}
				if(test) break;
			}		
					
			break;
		case 2:
			System.out.println("Fu�ballticket-> Bitte Art ausw�hlen: (VIP / Sitzplatz / Stehplatz)");
			Art = z.nextLine();
			for (int i = 0; i < i + 1; i++) {
				

				
				
				if(Art.equals("Stehplatz")) {
					System.out.println("Der Preis bertr�gt: 15");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+ countFootballTicketsSteh + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countFootballTicketsSteh) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
					}
				if(Art.equals("Sitzplatz")) {
					System.out.println("Der Preis bertr�gt: 30");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+countFootballTicketsSitz + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countFootballTicketsSitz) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(Art.equals("VIP")) {
					System.out.println("Der Preis bertr�gt: 60");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+countFootballTicketsVIP + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countFootballTicketsVIP) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}		
			}	
				
			if(!(Art.equals("VIP")||Art.equals("Stehplatz")||Art.equals("Sitzplatz"))) {
					System.out.println("NICHT VERF�GBAR!");
					test = false;
					testQuan = false;
					Art = z.nextLine();
				}
				
				if(testQuan) {
					test = true;
					try {
						if(quantity<0) {
							throw new WrongQuantityException();
						}
					}	
					catch(WrongQuantityException e) {
						System.out.println("Nur nat�rliche Zahlen!");
						test = false;
					}
				}
				if(test) break;
			
			break;
		}
		break;
		case 3:
			System.out.println("Theaterticket-> Bitte Art ausw�hlen: (Loge / Vorne / Hinten)");
			Art = z.nextLine();
			for (int i = 0; i < i + 1; i++) {
				

				
				
				if(Art.equals("Loge")) {
					System.out.println("Der Preis bertr�gt: 50");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+ countTheatreTicketsLoge + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countTheatreTicketsLoge) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
					}
				if(Art.equals("Hinten")) {
					System.out.println("Der Preis bertr�gt: 20");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+countTheatreTicketsHinten + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countTheatreTicketsHinten) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(Art.equals("Vorne")) {
					System.out.println("Der Preis bertr�gt: 30");
					System.out.println("Wieviele m�chten Sie kaufen? Es sind noch "+countTheatreTicketsVorne + " verf�gbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur nat�rliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countTheatreTicketsVorne) {
							System.out.println("Es sind nicht mehr so viele Tickets verf�gbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}		
			}	
				
			if(!(Art.equals("Vorne")||Art.equals("Hinten")||Art.equals("Loge"))) {
					System.out.println("NICHT VERF�GBAR!");
					test = false;
					testQuan = false;
					Art = z.nextLine();
				}
				
				if(testQuan) {
					test = true;
					try {
						if(quantity<0) {
							throw new WrongQuantityException();
						}
					}	
					catch(WrongQuantityException e) {
						System.out.println("Nur nat�rliche Zahlen!");
						test = false;
					}
				}
				if(test) break;
			
			break;
		}
		break;
			



	}
		for(int i = 0; i < i + 1; i++) {
			
			System.out.println("M�chten sie " + quantity + " Tickets dem Warenkorb hinzuf�gen?");

			Confirmation = z.next();

			if(Confirmation.equals("Ja")) {	
				tic [id-1] [0] = Art;
				tic [id-1] [1] = temp;
				System.out.println("Artikel wurde zum Warenkorb hinzugef�gt");
				System.out.println();
				break;
			}

			if(!Art.equals(ConcertTicket.position)) {
				System.out.println("NICHT VERF�GBAR");
			}

		}
	}
	 void menu() {
		 String temp;
		 Scanner z = new Scanner(System.in);
		 System.out.println("Was m�chten sie tun? Registrieren? Bestellen?");
		 temp = z.nextLine();
		 if(temp.equals("Registrieren")){
			 menuPoint = 1;
			 cusCheck = true;
		 }
		 if(temp.equals("Bestellen")) {
			 menuPoint = 2;
		 }
		 if(temp.equals("-a")) {
			 cusCheck = true;
			 menuPoint = 3;
		 }
		 if(!cusCheck) {
			 System.out.println("Sie m�ssen zuerst einen Benutzer anlegen!");
			 menuPoint = 1;
		 }

		 
	 }
	 void admin() {
		 Scanner s = new Scanner(System.in);
		 String temp;
		 int tempid;
		 boolean check = false;
		 System.out.println("Anzahl an kunden anzeigen: a" + "\n" + "F�r genauere Informationen zum Kunden id eingeben: id");
		 temp = s.next();

		
		 
		 try {
			tempid = Integer.valueOf(temp); 
			System.out.println(tic [tempid-1] [tempid-1]);
			System.out.println(tic [tempid-1] [tempid]);
		 }
		 catch (NumberFormatException e) {
			 if(temp.equals("a")) {
				 System.out.println("Anzahl an Kunden: " + (id-1));
				 check = true;
			 }

		 }
	 }
}
