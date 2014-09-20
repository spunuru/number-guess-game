package com.coolapps.numbergame;

import java.util.Scanner;

/**
 * <code>NumberGuessGame</code> instance encapsulates the state and logic to
 * play Number Guess Game.
 *

 * Here is the usage -
 * <p>
 * <code>
 * NumberGuessGame game = new NumberGuessGame()/new NumberGuessGame(int);
 * <br/>
 * game.playGame();
 * </code>
 * </p>
 */
public class NumberGuessGame {

	public static final int DEFAULT_MAX_NUMBER = 100;
	private static final String READY = "ready";
	private static final String YES = "yes";
	private static final String HIGHER = "higher";
	private static final String LOWER = "lower";
	private static final String END = "end";

	private static final int READY_PROMPT_MAX_COUNT = 3;
	private static final String READY_PROMPT_MSG = "Hello!. Please enter \"ready\" to start the game : ";
	private static final String READY_PROMPT_MSG_AGAIN = "You have entered \"%s\". Please enter \"ready\" to start the game : ";

	private int maxNumber;

	/**
	 * Default no-arg constructor.
	 */
	public NumberGuessGame() {
		this(DEFAULT_MAX_NUMBER);
	}

	public NumberGuessGame(Integer maxNumber) {
		if (maxNumber == null) {
			this.maxNumber = DEFAULT_MAX_NUMBER;
			return;
		}
		if (maxNumber < 1) {
			System.out
					.println("maxNumber can not be less than 1. It will be set to default: "
							+ DEFAULT_MAX_NUMBER);
			this.maxNumber = DEFAULT_MAX_NUMBER;
			return;
		}
		this.maxNumber = maxNumber;
	}

	/**
	 * This method is public api exposed to clients.
	 */
	public void playGame() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			if (!isUserReadyToPlay(scanner)) {
				System.out.println("Ended the game!. You may try again!.");
				return;
			}
			play(scanner);
		}
		catch(Exception ex) {
			//print errors if any.
			ex.printStackTrace();
		}
		finally {
			//close the resources.
			scanner.close();
		}
	}

	/**
	 * Implements logic to play the game. As user provides hints reg his guess, the method changes
	 * low and high indexes accordingly until it narrows down to the exact number in <code>orderedNumbers</code> list.
	 *
	 * @param scanner
	 */
	private void play(Scanner scanner) {

		int low = 1, high = maxNumber, current;
		String input = null;

		int attempts = 0;
		do {
			current = (low + high) / 2;
			++attempts;
			System.out.printf("Is the number %d?", current);
			input = scanner.next();

			if (LOWER.equalsIgnoreCase(input)) {
				high = current - 1;
				continue;
			}

			if (HIGHER.equalsIgnoreCase(input)) {
				low = current + 1;
				continue;
			}

		} while (!END.equalsIgnoreCase(input) && !YES.equalsIgnoreCase(input));

		if (END.equalsIgnoreCase(input)) {
			System.out.println("Ended the game. Bye!");
			return;
		}

		if (YES.equalsIgnoreCase(input)) {
			 System.out.printf("Guessed the number successfully in %d attempts", attempts);
			 return;
		}
	}

	/**
	 * Prompts user to enter "ready" to start number guess game.
	 * If user fails to enter ready in 3 attempts, returns false, otherwise returns true;
	 */
	private boolean isUserReadyToPlay(Scanner scanner) {

		// initialize prompt count.
		int promptCount = 0;
		String input = null;

		do {
			if (promptCount==0) {
				System.out.print(READY_PROMPT_MSG);
			}
			else {
				System.out.printf(READY_PROMPT_MSG_AGAIN, input);
			}
			input = scanner.next();
			++promptCount;
			if (READY.equalsIgnoreCase(input)) {
				return true;
			}
		}
		while (!READY.equalsIgnoreCase(input) && promptCount < READY_PROMPT_MAX_COUNT);

		return false;
	}

}
