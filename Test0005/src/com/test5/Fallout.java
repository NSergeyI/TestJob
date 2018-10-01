package com.test5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Fallout {
	private String maskFile = "./src/com/test5/source/";
	private int difficult;
	private String secretWord;
	private int numberOfAttempts = 4;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private ArrayList<String> source = new ArrayList<>();
	private boolean win = false;

	public void go() throws NumberFormatException, IOException {
		welcome();
		sourceFilling();
		displayOptions();
		changeSecretWords();
		cheat();
		startGame();
		closeReader();
	}

	private void welcome() throws NumberFormatException, IOException {
		System.out.print("Difficulty (1-5) ? ");
		difficult = Integer.parseInt(reader.readLine());
		System.out.println("");
	}

	private void sourceFilling() throws IOException {
		switch (difficult) {
		case 1:
			Files.lines(Paths.get(maskFile + "4.txt"), StandardCharsets.UTF_8).forEach(source::add);
			randomSelection(5);
			break;
		case 2:
			Files.lines(Paths.get(maskFile + "7.txt"), StandardCharsets.UTF_8).forEach(source::add);
			randomSelection(7);
			break;
		case 3:
			Files.lines(Paths.get(maskFile + "10.txt"), StandardCharsets.UTF_8).forEach(source::add);
			randomSelection(9);
			break;
		case 4:
			Files.lines(Paths.get(maskFile + "13.txt"), StandardCharsets.UTF_8).forEach(source::add);
			randomSelection(12);
			break;
		case 5:
			Files.lines(Paths.get(maskFile + "15.txt"), StandardCharsets.UTF_8).forEach(source::add);
			randomSelection(15);
			break;
		}
	}

	private void randomSelection(int quantity) {
		ArrayList<String> tempory = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			tempory.add(source.get(1 + (int) (Math.random() * (source.size() - 1))));
		}
		source = tempory;
	}

	private void displayOptions() {
		source.forEach(out -> System.out.println(out));
		System.out.println();
	}

	private void changeSecretWords() {
		secretWord = source.get(1 + (int) (Math.random() * (source.size() - 1)));
	}

	private void startGame() throws IOException {
		for (int i = numberOfAttempts; i > 0; i--) {
			toInvate(i);
			String input = userInput();
			if (checkAnswer(input)) {
				win = true;
				break;
			}
		}
		if (win) {
			messageWin();
		} else {
			messageLost();
		}
	}

	private void toInvate(int attempts) {
		System.out.print("Guess (" + attempts + " left) ? ");
	}

	private String userInput() throws IOException {
		String inputString = reader.readLine();
		return inputString;
	}

	private boolean checkAnswer(String input) {
		int countRightChar = 0;
		for (int i = 0; i < secretWord.length(); i++) {
			if (secretWord.charAt(i) == input.charAt(i)) {
				countRightChar++;
			}
		}
		System.out.println(countRightChar + "/" + secretWord.length() + "correct");

		return (countRightChar == secretWord.length()) && (secretWord.length() == input.length()) ? true : false;
	}

	private void messageWin() {
		System.out.println("You win!");
	}

	private void messageLost() {
		System.out.println("You lost!");
	}

	private void closeReader() throws IOException {
		reader.close();
	}

	private void cheat() {
		System.out.println("CHEAT: " + secretWord);
		System.out.println();
	}
}
