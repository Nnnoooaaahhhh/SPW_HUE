import java.util.*;

public class TicketshopMain {

	static int menuPoint = 0;
	static int whichTicket;
	static int id = 1;	
	static boolean first = true;
	static boolean customerTest = false;
	static boolean ticketCheck = false;
	
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
		ConcertTicket con = new ConcertTicket("test", 0, "test");
		FootballTicket foo = new FootballTicket("test", 0 ,"test");
		TheatreTicket the = new TheatreTicket("test", 0, "test");
		a.fillTickets();

		
		
		for(int i = 0; i < i + 1; i++) {

			
			if(menuPoint == 0) a.menu();
			if(menuPoint == 3) {
				a.admin();
			}	
			if(menuPoint == 1) {
				a.getCustomers();
				if(ticketCheck) menuPoint = 0;
				if(!ticketCheck) menuPoint = 2;
				if(menuPoint == 1)menuPoint = 2;
			}
			if(menuPoint == 2) {
				if(customerTest)a.determineTicket();
				
			}

			
			if(first) {
				if(whichTicket == 1)con.concertA();
				if(whichTicket == 2)foo.footballA();
				if(whichTicket == 3)the.theatreA();
				if(ticketCheck&&!customerTest) a.getCustomers();	
			}

			
			if(ticketCheck&&customerTest) menuPoint = 0;

			
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

	@SuppressWarnings("resource")
	void getCustomers() {
		String Sex;
		String Vorname;
		String Nachname;
		String Stadt;
		String pw;
		for (int i = 0; i < i + 1;) {			
				Scanner h = new Scanner(System.in);
				System.out.println("Bitte Vorname angeben:");
				Vorname = h.nextLine();
				System.out.println("Bitte Nachname angeben:");
				Nachname = h.nextLine();
				System.out.println("Bitte Geschlecht angeben:");
				Sex = h.nextLine();
				System.out.println("Bitte Stadt angeben:");
				Stadt = h.nextLine();
				System.out.println("Bitte Passwort wählen:");
				pw = h.nextLine();
				cus[i] = new Customer (Sex, id, Vorname, Nachname, Stadt, pw); 
				System.out.println("Ihre id lautet " + id);
				id++;
				customerTest = true;
				
				break;
		
		}
	}

	void determineTicket() {
		String Art;
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Welches Ticket möchten Sie kaufen?");
		System.out.println("Konzertticket / Fußballticket / Theaterticket");
		for(int i = 0; i < i + 1; i++) {
			Art = s.nextLine();
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
		TicketshopMain.menuPoint = 2;
		
	}



	
	 @SuppressWarnings("resource")
	void menu() {
		 String temp;
		 Scanner z = new Scanner(System.in);
		 System.out.println("Willkommen im SCAMSHOP.pl!");
		 System.out.println("Wollen sie zuerst das Produkt suchen oder ihre Daten angeben? (Bestellen/Daten)");
		 temp = z.nextLine();
		 if(temp.equalsIgnoreCase("Daten")){
			 menuPoint = 1;
		 }
		 if(temp.equalsIgnoreCase("Bestellen")) {
			first = true;
			 menuPoint = 2;
		 }
		 if(temp.equals("-a")) {	 
			 menuPoint = 3;
		 }

		 
		 
	 }
	 @SuppressWarnings({ "resource", "unused" })
	void admin() {
		Scanner s = new Scanner(System.in);
		 String temp;
		 int tempid;
		 System.out.println("Anzahl an Kunden: " + (Customer.id) + "\n" + "Um den Warenkorb des Kunden aufzurufen bitte die id eingeben");
		 temp = s.next();

		
		 for(int i = 0; i < i + 1; i++) {
			 try {
					tempid = Integer.valueOf(temp); 
					System.out.println(tic [tempid] [0]);
					System.out.println(tic [tempid] [1]);
					break;
				 }
				 catch (NumberFormatException e) {
					 System.out.println("Bitte gülitge id eingeben!");
					 break;						  
				 }
			
		 }
		 System.out.println("Um ins Menü zu gelangen x eingeben, um die Anzahl der Kunden bzw. nähere Informationen aufzurufen bitte -a eingeben und erneut die id eingeben!");
		 temp=s.next();
		 if(temp.equals("x")) {
			 TicketshopMain.menuPoint=0;
		 }
	 }
}
