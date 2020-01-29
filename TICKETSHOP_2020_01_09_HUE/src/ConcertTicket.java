import java.util.Scanner;

public class ConcertTicket extends Ticket{
	
	static int countConcertTicketsMittelklasse = 1000;
	static int countConcertTicketsVorDerBuehne = 500;
	static int countConcertTicketsNebenDerBuehne = 500;
	static int countConcertTicketsGanzWeitHinten = 1500;
	
	int id = 1;
	
	

	ConcertTicket(String name, int price, String position) {
		super(name, price, position);
	}
	static String tic [] [] = new String [1000] [2];
	
	void concertA() {
		String Art = null;
		String Confirmation;
		String temp = "";
		boolean testQuan = true;
		int quantity = 0;
		boolean test = true;
		@SuppressWarnings("resource")
		Scanner z = new Scanner(System.in);
		System.out.println("Konzertticket-> Bitte Art ausw�hlen: (Vor der B�hne / Neben der B�hne / Mittelklasse / GAAANZ WEIT HIIIINTEN)");
		Art = z.nextLine();
		for (int i = 0; i < i + 1; i++) {

			
			
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
					if(testQuan) {
						countConcertTicketsMittelklasse =  countConcertTicketsMittelklasse - quantity;
						break;
					}
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
					if(testQuan) {
						countConcertTicketsVorDerBuehne = countConcertTicketsVorDerBuehne - quantity;
						break;
					}
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
					if(testQuan) {
						countConcertTicketsNebenDerBuehne = countConcertTicketsNebenDerBuehne - quantity;
						break;
					}
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
					if(testQuan) {
						countConcertTicketsGanzWeitHinten = countConcertTicketsGanzWeitHinten - quantity;
						break;
					}
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
