import java.util.ArrayList;
import java.util.List;

public class ChessMain {

	static int length = 8;
	static int row = 0;

	Pawn f1;
	Pawn f2;
	Pawn f3;
	Pawn f4;
	Rook t1;
	Rook t2;
	Rook t3;
	Rook t4;
	Knight kn1;
	Knight kn2;
	Knight kn3;
	Knight kn4;
	Bishop b1;
	Bishop b2;
	Bishop b3;
	Bishop b4;
	Queen q1;
	Queen q2;	
	King k1;
	King k2;
	
	
	static String brd [] [] = new String [length] [length];
	static Pawn frm [] = new Pawn [length];
	static List <Pawn> farm = new ArrayList<>();
 
	public static void main(String[] args) {
		
		ChessMain a = new ChessMain();
		
		a.getPieces();
		a.placing();
		a.showing();


	}
	
	void getPieces() {
		
		for (int i = 0; i < 8; i++) {
			farm.add(new Pawn(Color.Black, "Pawn", 1, i));
		}
		for (int i = 0; i < 8; i++) {
			farm.add(new Pawn(Color.White, "Pawn", 6, i));
			row++;
		}
		t1 = new Rook(Color.Black, "Rook", 0, 0);
		t2 = new Rook(Color.Black, "Rook", 0, 7);
		t3 = new Rook(Color.White, "Rook", 7, 0);
		t4 = new Rook(Color.White, "Rook", 7, 7);
		kn1 = new Knight(Color.Black, "Knight", 0, 1);
		kn2 = new Knight(Color.Black, "Knight", 0, 6);
		kn3 = new Knight(Color.White, "Knight", 7, 1);
		kn4 = new Knight(Color.White, "Knight", 7, 6);
		b1 = new Bishop(Color.Black, "Bishop", 0, 2);
		b2 = new Bishop(Color.Black, "Bishop", 0, 5);
		b3 = new Bishop(Color.White, "Bishop", 7, 2);
		b4 = new Bishop(Color.White, "Bishop", 7, 5);
		q1 = new Queen(Color.Black, "Queen", 0, 4);
		q2 = new Queen(Color.White, "Queen", 7, 3);
		k1 = new King(Color.Black, "King", 0, 3);
		k2 = new King(Color.White, "King", 7, 4);
	}

	
	void placing() {
			
			for (int i = 0; i < length*2; i++) {
				brd[farm.get(i).poslength] [farm.get(i).poswidth] = farm.get(i).Name + " ";
			}
			brd[t1.poslength] [t1.poswidth] = t1.Name;
			brd[t2.poslength] [t2.poswidth] = t2.Name;
			brd[kn1.poslength] [kn1.poswidth] = kn1.Name;
			brd[kn2.poslength] [kn2.poswidth] = kn2.Name;
			brd[b1.poslength] [b1.poswidth] = b1.Name;
			brd[b2.poslength] [b2.poswidth] = b2.Name;
			brd[q1.poslength] [q1.poswidth] = q1.Name;
			brd[k1.poslength] [k1.poswidth] = k1.Name;		
			brd[t3.poslength] [t3.poswidth] = t3.Name;
			brd[t4.poslength] [t4.poswidth] = t4.Name;
			brd[kn3.poslength] [kn3.poswidth] = kn3.Name;
			brd[kn4.poslength] [kn4.poswidth] = kn4.Name;
			brd[b3.poslength] [b3.poswidth] = b3.Name;
			brd[b4.poslength] [b4.poswidth] = b4.Name;
			brd[q2.poslength] [q2.poswidth] = q2.Name;
			brd[k2.poslength] [k2.poswidth] = k2.Name;		
	}
	
	void showing() {
		String f1;
		String b;
		for (int i = 0; i < length; i++) {
			for(int j = 0; j < length; j++) {
				b = brd[i][j];
				f1 = String.format("|  %s  |", b);
				if(brd[i][j] == null) {
					f1 = "|         |";
				}
				if(i<2) {
					
				}
			
				System.out.print(f1);
			}
	
			System.out.println();
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println();
			
		}
	}
}
