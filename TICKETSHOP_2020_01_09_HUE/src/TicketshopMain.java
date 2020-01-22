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
		a = new ConcertTicket("Konzertticket", 50, "Vor der Bühne");
		b = new ConcertTicket("Konzertticket", 30, "Mittelklasse");
		c = new ConcertTicket("Konzertticket", 40, "Neben der Bühne");
		d = new ConcertTicket("Konzertticket", 20, "GAAANZ WEIT HIIIINTEN");
		e = new FootballTicket("Fußballticket", 30, "Sitzplatz");
		f = new FootballTicket("Fußballticket", 60, "VIP");
		g = new FootballTicket("Fußballticket", 15, "Stehplatz");
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
				System.out.println("Bitte Passwort wählen:");
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
		System.out.println("Welches Ticket möchten Sie kaufen?");
		System.out.println("Konzertticket / Fußballticket / Theaterticket");
		for(int i = 0; i < i + 1; i++) {
			Art = s.next();
			if(Art.equals("Konzertticket")) {
				whichTicket = 1;
				break;
			}
			if(Art.equals("Fußballticket")) {
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
			System.out.println("Konzertticket-> Bitte Art auswählen: (Vor der Bühne / Neben der Bühne / Mittelklasse / GAAANZ WEIT HIIIINTEN)");
			Art = z.nextLine();
			for (int i = 0; i < i + 1; i++) {
				if(!Art.equals(Ticket.position)) {
					System.out.println("NICHT VERFÜGBAR!");
					test = false;
					testQuan = false;
					Art = z.nextLine();
				}
				
				
				if(Art.equals("Mittelklasse")) {
					System.out.println("Der Preis berträgt: 30");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+ countConcertTicketsMittelklasse + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countConcertTicketsMittelklasse) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
					}
				if(Art.equals("Vor der Bühne")) {
					System.out.println("Der Preis berträgt: 50");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+countConcertTicketsVorDerBuehne + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countConcertTicketsVorDerBuehne) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(Art.equals("Neben der Bühne")) {
					System.out.println("Der Preis berträgt: 40");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+countConcertTicketsNebenDerBuehne + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countConcertTicketsNebenDerBuehne) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(Art.equals("GAAANZ WEIT HIIIINTEN")) {
					System.out.println("Der Preis berträgt: 20");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+countConcertTicketsGanzWeitHinten + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countConcertTicketsGanzWeitHinten) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(!(Art.equals("Mittelklasse")||Art.equals("Vor der Bühne")||Art.equals("Neben der Bühne")||!Art.equals("GAAANZ WEIT HIIIINTEN"))) {
					System.out.println("NICHT VERFÜGBAR!");
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
						System.out.println("Nur natürliche Zahlen!");
						test = false;
					}
				}
				if(test) break;
			}		
					
			break;
		case 2:
			System.out.println("Fußballticket-> Bitte Art auswählen: (VIP / Sitzplatz / Stehplatz)");
			Art = z.nextLine();
			for (int i = 0; i < i + 1; i++) {
				

				
				
				if(Art.equals("Stehplatz")) {
					System.out.println("Der Preis berträgt: 15");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+ countFootballTicketsSteh + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countFootballTicketsSteh) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
					}
				if(Art.equals("Sitzplatz")) {
					System.out.println("Der Preis berträgt: 30");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+countFootballTicketsSitz + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countFootballTicketsSitz) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(Art.equals("VIP")) {
					System.out.println("Der Preis berträgt: 60");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+countFootballTicketsVIP + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countFootballTicketsVIP) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}		
			}	
				
			if(!(Art.equals("VIP")||Art.equals("Stehplatz")||Art.equals("Sitzplatz"))) {
					System.out.println("NICHT VERFÜGBAR!");
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
						System.out.println("Nur natürliche Zahlen!");
						test = false;
					}
				}
				if(test) break;
			
			break;
		}
		break;
		case 3:
			System.out.println("Theaterticket-> Bitte Art auswählen: (Loge / Vorne / Hinten)");
			Art = z.nextLine();
			for (int i = 0; i < i + 1; i++) {
				

				
				
				if(Art.equals("Loge")) {
					System.out.println("Der Preis berträgt: 50");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+ countTheatreTicketsLoge + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countTheatreTicketsLoge) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
					}
				if(Art.equals("Hinten")) {
					System.out.println("Der Preis berträgt: 20");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+countTheatreTicketsHinten + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countTheatreTicketsHinten) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}
				}
				if(Art.equals("Vorne")) {
					System.out.println("Der Preis berträgt: 30");
					System.out.println("Wieviele möchten Sie kaufen? Es sind noch "+countTheatreTicketsVorne + " verfügbar");
					for (int q = 0; q < q + 1; q++) {
						temp  = z.next();
						try{
							quantity = Integer.valueOf(temp);
						}
						catch (NumberFormatException k) {
							System.out.println("Nur natürliche Zahlen!");
							test = false;
						}
						testQuan = true;
						if(quantity > countTheatreTicketsVorne) {
							System.out.println("Es sind nicht mehr so viele Tickets verfügbar!");
							testQuan = false;
							}
						if(testQuan) break;
						}		
			}	
				
			if(!(Art.equals("Vorne")||Art.equals("Hinten")||Art.equals("Loge"))) {
					System.out.println("NICHT VERFÜGBAR!");
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
						System.out.println("Nur natürliche Zahlen!");
						test = false;
					}
				}
				if(test) break;
			
			break;
		}
		break;
			



	}
		for(int i = 0; i < i + 1; i++) {
			
			System.out.println("Möchten sie " + quantity + " Tickets dem Warenkorb hinzufügen?");

			Confirmation = z.next();

			if(Confirmation.equals("Ja")) {	
				tic [id-1] [0] = Art;
				tic [id-1] [1] = temp;
				System.out.println("Artikel wurde zum Warenkorb hinzugefügt");
				System.out.println();
				break;
			}

			if(!Art.equals(ConcertTicket.position)) {
				System.out.println("NICHT VERFÜGBAR");
			}

		}
	}
	 void menu() {
		 String temp;
		 Scanner z = new Scanner(System.in);
		 System.out.println("Was möchten sie tun? Registrieren? Bestellen?");
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
			 System.out.println("Sie müssen zuerst einen Benutzer anlegen!");
			 menuPoint = 1;
		 }

		 
	 }
	 void admin() {
		 Scanner s = new Scanner(System.in);
		 String temp;
		 int tempid;
		 boolean check = false;
		 System.out.println("Anzahl an kunden anzeigen: a" + "\n" + "Für genauere Informationen zum Kunden id eingeben: id");
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
