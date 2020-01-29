import java.util.Scanner;

public class FootballTicket extends Ticket{
	
	static int countConcertTicketsGanzWeitHinten = 1500;
	static int countFootballTicketsVIP = 1000;
	static int countFootballTicketsSteh = 20000;
	static int countFootballTicketsSitz = 10000;
	
	static String tic [] [] = new String [1000] [2];
	int id = 1;

	FootballTicket(String name, int price, String position) {
		super(name, price, position);

	}
	
	
	void footballA() {
		String Art = null;
		String Confirmation;
		String temp = "";
		boolean testQuan = true;
		int quantity = 0;
		boolean test = true;
		@SuppressWarnings("resource")
		Scanner z = new Scanner(System.in);
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
					if(testQuan) {
					countFootballTicketsSteh = countFootballTicketsSteh - quantity;
					break;
						}
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
					if(testQuan) {
						countFootballTicketsSitz = countFootballTicketsSitz - quantity;
						break;
					}
					
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
					if(testQuan) {
						countFootballTicketsVIP = countFootballTicketsVIP - quantity;
						break;		
					}
				
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
		
		
	}
		for(int i = 0; i < i + 1; i++) {
			
			System.out.println("M�chten sie " + quantity + " Tickets dem Warenkorb hinzuf�gen?");

			Confirmation = z.next();

			if(Confirmation.equals("Ja")) {	
				TicketshopMain.first = false;
				TicketshopMain.tic [Customer.id] [0] = Art;
				TicketshopMain.tic [Customer.id] [1] = temp;
				System.out.println("Artikel wurde zum Warenkorb hinzugef�gt");
				System.out.println();
				TicketshopMain.ticketCheck = true;
				break;
			}

			if(!Art.equals(ConcertTicket.position)) {
				System.out.println("NICHT VERF�GBAR");
			}

		}
	}
	

}
