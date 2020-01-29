public abstract class  Ticket {
	
	static String name;
	static int price;
	static String position;
	
	@SuppressWarnings("static-access")
	Ticket(String name, int price, String position) {
		this.name=name;
		this.price=price;
		this.position=position;
	}
	

}
