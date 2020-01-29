import java.util.Scanner;

public class TheatreTicket extends Ticket{
	
	static int countTheatreTicketsLoge = 50;
	static int countTheatreTicketsVorne = 150;
	static int countTheatreTicketsHinten = 300;
	
	static String tic [] [] = new String [1000] [2];
	int id = 1;

	TheatreTicket(String name, int price, String position) {
		super(name, price, position);
	}
	
	void theatreA() {
				String Art = null;
				String Confirmation;
				String temp = "";
				boolean testQuan = true;
				int quantity = 0;
				boolean test = true;
				@SuppressWarnings("resource")
				Scanner z = new Scanner(System.in);
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
							if(testQuan) {
								countTheatreTicketsLoge = countTheatreTicketsLoge - quantity;
								break;
							}
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
							if(testQuan) {
								countTheatreTicketsHinten = countTheatreTicketsHinten - quantity;
								break;
							}
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
							if(testQuan) {
								countTheatreTicketsVorne = countTheatreTicketsVorne - quantity;
								break;
							}
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
		


