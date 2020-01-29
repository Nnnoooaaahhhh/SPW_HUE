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
		System.out.println("Konzertticket-> Bitte Art auswählen: (Vor der Bühne / Neben der Bühne / Mittelklasse / GAAANZ WEIT HIIIINTEN)");
		Art = z.nextLine();
		for (int i = 0; i < i + 1; i++) {

			
			
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
					if(testQuan) {
						countConcertTicketsMittelklasse =  countConcertTicketsMittelklasse - quantity;
						break;
					}
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
					if(testQuan) {
						countConcertTicketsVorDerBuehne = countConcertTicketsVorDerBuehne - quantity;
						break;
					}
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
					if(testQuan) {
						countConcertTicketsNebenDerBuehne = countConcertTicketsNebenDerBuehne - quantity;
						break;
					}
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
					if(testQuan) {
						countConcertTicketsGanzWeitHinten = countConcertTicketsGanzWeitHinten - quantity;
						break;
					}
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
		for(int i = 0; i < i + 1; i++) {
			
			System.out.println("Möchten sie " + quantity + " Tickets dem Warenkorb hinzufügen?");

			Confirmation = z.next();

			if(Confirmation.equals("Ja")) {
				TicketshopMain.first = false;
				TicketshopMain.tic [Customer.id] [0] = Art;
				TicketshopMain.tic [Customer.id] [1] = temp;
				System.out.println("Artikel wurde zum Warenkorb hinzugefügt");
				System.out.println();
				TicketshopMain.ticketCheck = true;
				break;
			}

			if(!Art.equals(ConcertTicket.position)) {
				System.out.println("NICHT VERFÜGBAR");
			}

		}
	}
	
	

}
