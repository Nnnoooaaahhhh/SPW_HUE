import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Entschluessler {
	
	public static void main(String args[]) {
		lettersToInt();
		minusCode();
		backToLetters();
	}
	
	static int intArray[];
	static int codeArray[];
	static String finalText[];
	
	static void lettersToInt() {
		File Output;
		Path file = Paths.get("Output.txt");
		String userInput = "";
		
		try {
			userInput = new String(Files.readAllBytes(Paths.get("Output.txt")));
		}
		catch (Exception e) {	
		}
		char [] inputArray = userInput.toCharArray();
		intArray = new int[inputArray.length];
		for(int i = 0; i < inputArray.length; i++) {
			if(inputArray[i]=='a') {
				intArray[i] = 0;
			}
			if(inputArray[i]=='b') {
				intArray[i] = 1;
			}
			if(inputArray[i]=='c') {
				intArray[i] = 2;
			}
			if(inputArray[i]=='d') {
				intArray[i] = 3;
			}
			if(inputArray[i]=='e') {
				intArray[i] = 4;
			}
			if(inputArray[i]=='f') {
				intArray[i] = 5;
			}
			if(inputArray[i]=='g') {
				intArray[i] = 6;
			}
			if(inputArray[i]=='h') {
				intArray[i] = 7;
			}
			if(inputArray[i]=='i') {
				intArray[i] = 8;
			}
			if(inputArray[i]=='j') {
				intArray[i] = 9;
			}
		}
	}
	
	static void minusCode() {
		codeArray = new int[intArray.length];
		int y = 0;
		Scanner userInput = new Scanner(System.in);
		String Codex;
		System.out.println("Code: ");
		Codex = userInput.next();
		char [] codeArrayChar = Codex.toCharArray();
		for(int i = 0; i < intArray.length; i++) {
			codeArray[i] = intArray[i] - Integer.valueOf(codeArrayChar[y] - 48);
			y++;
			if(y == codeArrayChar.length) {
				y = 0;
			}
		}
	}
	
	static void backToLetters() {
		boolean fileExists = false;;
		String finalOutput = "";
		finalText = new String[codeArray.length];
		for(int i = 0; i < codeArray.length; i++) {
			if(codeArray[i] == 0) {
				finalText[i] = "a";
			}
			if(codeArray[i] == 1) {
				finalText[i] = "b";
			}
			if(codeArray[i] == 2) {
				finalText[i] = "c";
			}
			if(codeArray[i] == 3) {
				finalText[i] = "d";
			}
			if(codeArray[i] == 4) {
				finalText[i] = "e";
			}
			if(codeArray[i] == 5) {
				finalText[i] = "f";
			}
			if(codeArray[i] == 6) {
				finalText[i] = "g";
			}
			if(codeArray[i] == 7) {
				finalText[i] = "h";
			}
			if(codeArray[i] == 8) {
				finalText[i] = "i";
			}
			if(codeArray[i] == 9) {
				finalText[i] = "j";
			}
			if(codeArray[i] == -1) {
				finalText[i] = "j";
			}
			if(codeArray[i] == -2) {
				finalText[i] = "i";
			}
			if(codeArray[i] == -3) {
				finalText[i] = "h";
			}
			if(codeArray[i] == -4) {
				finalText[i] = "g";
			}
			if(codeArray[i] == -5) {
				finalText[i] = "f";
			}
			if(codeArray[i] == -6) {
				finalText[i] = "e";
			}
			if(codeArray[i] == -7) {
				finalText[i] = "d";
			}
			if(codeArray[i] == -8) {
				finalText[i] = "c";
			}
			if(codeArray[i] == -9) {
				finalText[i] = "b";
			}
		}
		for(int i = 0; i < finalText.length; i++) {
			finalOutput = finalOutput + finalText[i];
		}
		System.out.println("FinalOutput: " + finalOutput);
		
		File finalOutputFile;
		Path file = Paths.get("FinalOutput.txt");
		if (Files.exists(file)) {
			fileExists = true;
		} else {
			finalOutputFile = new File("FinalOutput.txt");
			fileExists = false;
		}
		try {
			if (fileExists) {
				Files.deleteIfExists(file);
				finalOutputFile = new File("FinalOutput.txt");		
			}
			FileWriter writer = new FileWriter("FinalOutput.txt");
			for (int i = 0; i < finalText.length; i++) {
				writer.write(finalOutput);
				writer.close();
			}
		} catch (Exception e) {
		}
	}

}
