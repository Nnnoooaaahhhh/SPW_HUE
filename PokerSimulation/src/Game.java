import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

	static int allCards = 52;
	static int games; // = 10000000;
	static int numberHandCards = 5;

	static int[] cardDeck = new int[allCards];
	static int[] newCards = new int[numberHandCards];
	static int[] colors = new int[numberHandCards];
	static int[] symbols = new int[numberHandCards];

	static float pairs;
	static float threes;
	static float fours;
	static float fhouses;
	static float straights;
	static float strgthflush;
	static float flush;
	static float rflush;
	static float high;
	static float tpairs;

	static int scan;
	static String games2;

	private static Random r = new Random();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		games2 = scan.next();
		games = Integer.valueOf(games2);
		gameStart();
		ausgabe();
	}

	private static void gameStart() {
		for (int i = 0; i < games; i++) {
			for (int a = 0; a <= cardDeck.length - 1; a++) {
				cardDeck[a] = a;
			}
			int temp1 = 0;
			int temp2 = 0;
			for (int y = 0; y < numberHandCards; y++) {
				int rndm = r.nextInt(cardDeck.length - y);
				temp1 = cardDeck[rndm];
				temp2 = cardDeck[cardDeck.length - 1 - y];
				newCards[y] = temp1;
				cardDeck[rndm] = temp2;
			}
			sorter();
			combs();
		}
	}

	static void ausgabe() {
		System.out.println();
		System.out.println("High Card: " + high / games * 100 + " %");
		System.out.println("Anzahl Paare: " + pairs / games * 100 + " %");
		System.out.println("Anzahl von 2 Paaren: " + tpairs / games * 100 + " %");
		System.out.println("Anzahl von 3 Gleichen: " + threes / games * 100 + " %");
		System.out.println("Anzahl von Straights: " + straights / games * 100 + " %");
		System.out.println("Anzahl von Flushs: " + flush / games * 100 + " %");
		System.out.println("Anzahl von Full Houses: " + fhouses / games * 100 + " %");
		System.out.println("Anzahl von 4 Gleichen: " + fours / games * 100 + " %");
		System.out.println("Anzahl von Straight Flushes: " + strgthflush / games * 100 + " %");
		System.out.println("Anzahl von Royal Flushes: " + rflush / games * 100 + " %");

	}

	static void sorter() {
		for (int i = 0; i < numberHandCards; i++) {
			colors[i] = newCards[i] / 13;
			symbols[i] = newCards[i] % 13;
		}
		Arrays.sort(colors);
		Arrays.sort(symbols);
		symbols[0] = 1;
		symbols[1] = 1;
		symbols[2] = 2;
		symbols[3] = 2;
		symbols[4] = 2;
	}

	static boolean onePair() {
		int counter = 0;
		for (int y = 0; y < symbols.length - 1; y++) {
			if (symbols[y] == symbols[y + 1]) {
				counter++;
			}
		}
		if (counter == 1) {
			return true;
		}
		return false;
	}

	static boolean threeOfAKind() {
		int counter = 0;
		for (int y = 0; y < symbols.length - 1; y++) {
			if (symbols[y] == symbols[y + 1]) {
				counter++;
			}
		}
		if (counter == 2) {
			return true;
		}
		return false;
	}

	static boolean fourOfAKind() {
		int counter = 0;
		for (int y = 0; y < symbols.length - 1; y++) {
			if (symbols[y] == symbols[y + 1]) {
				counter++;
			}
		}
		if (counter == 3) {
			return true;
		}
		return false;
	}

	static boolean flush() {
		int counter = 0;
		for (int i = 1; i < colors.length; i++) {
			if (colors[0] == colors[i]) {
				counter++;
				if (counter == 4) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean row() {
		int counter = 0;
		for (int i = 0; i < symbols.length - 1; i++) {
			if (symbols[i] - symbols[i + 1] == -1) {
				counter++;
				if (counter == 4) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean rowSpecial() {
		if (symbols[0] == 1) {
			if (symbols[1] == 2) {
				if (symbols[2] == 3) {
					if (symbols[3] == 4) {
						if (symbols[4] == 12) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	static boolean royalFlush() {
		int flushcount = 0;
		int counter = 0;
		for (int i = 1; i < colors.length; i++) {
			if (colors[0] == colors[i]) {
				flushcount++;
			}
		}
		if (flushcount == 4) {
			for (int i = 0; i < symbols.length - 1; i++) {
				if ((symbols[i] - symbols[i + 1] == -1) && symbols[i] > 7) {
					counter++;
					if (counter == 4) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static boolean twoPairs() {
		int counter1 = 0;
		int counter2 = 0;
		int temp1 = 0;
		for (int y = 0; y < symbols.length - 1; y++) {
			if (symbols[y] == symbols[y + 1]) {
				temp1 = symbols[y];
				counter1++;
				break;
			}
		}
		if (counter1 == 1) {
			for (int y = 0; y < symbols.length - 1; y++) {
				if ((symbols[y] == symbols[y + 1]) && symbols[y] != temp1) {
					counter2++;
				}
			}
		}
		if ((counter1 == 1) && (counter2 == 1)) {
			return true;
		}
		return false;
	}

	static boolean fullHouse() {
		int paircount = 0;
		int threecount = 0;
		int counter1 = 0;
		int counter2 = 0;

		for (int y = 1; y < symbols.length; y++) {
			if (symbols[0] == symbols[y]) {
				counter1++;
			}
		}
		if (counter1 == 1)
			paircount++;
		if (counter1 == 2)
			threecount++;

		if (paircount == 1) {
			for (int y = 2; y < symbols.length - 1; y++) {
				if (symbols[2] == symbols[y + 1]) {
					counter2++;
					if (counter2 == 2)
						threecount++;
				}
			}
		}
		if (threecount == 1) {
			for (int y = 3; y < symbols.length - 1; y++) {
				if (symbols[3] == symbols[y + 1]) {
					counter2++;
					if (counter2 == 1)
						paircount++;
				}
			}
		}
		if (paircount > 0) {
			if (threecount > 0) {
				return true;
			}
		}
		return false;
	}

	static void combs() {
		if (royalFlush()) {
			rflush++;
		}else if (flush() && row()) {
			strgthflush++;
		}else if (flush()) {
			flush++;
		}else if (row() || rowSpecial()) {
			straights++;
		}else if (fullHouse()) {
			fhouses++;
		}else if (twoPairs()) {
			tpairs++;
		}else if (fourOfAKind()) {
			fours++;
		}else if (threeOfAKind()) {
			threes++;
		}else if (onePair()) {
			pairs++;
		}else {
			high++;
		}
		assert (onePair()):"KEIN PARR ENTHALTEN";
		assert (fullHouse()):"KEIN FULLHOUSE ENTHALTEN";
		assert (royalFlush()):"KEIN ROYAL FLUSH ENTHALTEN";	
	}
}
