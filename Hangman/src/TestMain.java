import java.nio.file.*;
import java.util.*;

public class TestMain {
	
	public static void main (String args[]) {
		wordsToArr(decideLevel());
		whichWord();
		guessing();
	}

	static String wordString[];
	static char wordChar[];
	
	
	static String decideLevel() {
		String level = "";
		int levelNummer;
		Scanner a  = new Scanner(System.in);
		System.out.println("Welches Level möchten Sie spielen? 1, 2, 3?");
		levelNummer = a.nextInt();
		switch(levelNummer) {
		case 1: level = "level1.txt"; break;
		case 2: level = "level2.txt"; break;
		case 3: level = "level3.txt"; break;
		}
		return  level;
	}
	
	
	static void wordsToArr(String text) {
		try {
			String input = new String(Files.readAllBytes(Paths.get(text)));
	        wordString = input.split("\n");
		}
		catch (Exception e) {			
		}		
	}
	
	static void whichWord() {
		Random r = new Random();
		String temp = "";
		temp = wordString[r.nextInt(wordString.length)];
		temp = temp.replaceAll("\n", "A");
		temp = temp.replaceAll(" ", "K");
		System.out.println(temp);
		wordChar = temp.toCharArray();
		System.out.println(wordChar.length);
	}
	
	static void guessing() {
	int maxWrong = 10;
	String userInput;
	char charInput = 0;
	boolean allRight = false;
	boolean newLetter = false;
	int numbersRight = 0;
	char falseLetters[] = new char[26];
	char allLetters[] = new char[26];
	ArrayList <Character> usedLetters = new ArrayList<Character>();
	int y = 0;
	int z = 0;
	Scanner input = new Scanner(System.in);
	boolean rightLetter = false;
	char guessedChar[] = new char[wordChar.length - 1];
	
	for(int i = 0; i < wordChar.length - 1; i++) {
		guessedChar[i] = '_';
	}
	System.out.println(guessedChar.length);
	
	
		while(!allRight) {
			System.out.println();
			System.out.println("Das Wort: ");
			for(int i = 0; i < guessedChar.length; i++) {
				System.out.print(guessedChar[i]+ " ");
			}
			System.out.println();
			System.out.println("Bitte raten Sie einen Buchstaben");
			while(!newLetter) {
				userInput = input.next();
				charInput = userInput.charAt(0);

				if(usedLetters.contains(charInput)) {
					newLetter = false;
					System.out.println("Dieser Buchstabe wurde bereits verwendet! Bitte wählen Sie einen neuen!");
				}
				else {
					usedLetters.add(charInput);
					newLetter = true;
				}
			}
			newLetter = false;
			for (int i = 0; i < guessedChar.length; i++){
				if(charInput == wordChar[i]) {
					numbersRight++;
					guessedChar[i] = wordChar[i];
					rightLetter = true;
				}
			}
			if(!rightLetter) {
				maxWrong--;
				falseLetters[y] = charInput;
				System.out.println("Falsch geraten! Alle falschen Buchstaben:");
				for (int i = 0; i < falseLetters.length; i++) {
					System.out.print(falseLetters[i]+ " ");				
				}
				y++;
				System.out.println();
				System.out.println("Sie haben noch " + maxWrong + " Versuche");
			}
			if(rightLetter) {
				
				System.out.println("Richtig geraten! Alle falschen Buchstaben:");
				for (int i = 0; i < falseLetters.length; i++) {
					System.out.print(falseLetters[i]+ " ");				
				}
				System.out.println();
				System.out.println("Sie haben noch " + maxWrong + " Versuche");
				rightLetter = false; 
			}
			if(numbersRight == guessedChar.length) {
				allRight = true;
				System.out.print("Das richtige Wort: ");
				for(int i = 0; i < guessedChar.length; i++) {			
					System.out.print(wordChar[i]);
				}
			}
			if(allRight) {
				System.out.println();
				System.out.println("Alles wurde richtig geraten");
				System.out.println("Anzahl Fehlversuche: " + y);
				break;
			}
			if(maxWrong == 0) {
				System.out.println("Sie haben verloren!");
				System.out.print("Das richtige Wort: ");
				for(int i = 0; i < guessedChar.length; i++) {			
					System.out.print(wordChar[i]);
				}
				break;
			}
		}
		
		
	}
	
	
}
