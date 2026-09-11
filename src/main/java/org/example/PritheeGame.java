package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PritheeGame {
    private static final String SONNET =
            "Shall I compare thee to a summer’s day?\n" +
                    "Thou art more lovely and more temperate:\n" +
                    "Rough winds do shake the darling buds of May,\n" +
                    "And summer’s lease hath all too short a date;\n" +
                    "Sometime too hot the eye of heaven shines,\n" +
                    "And often is his gold complexion dimm’d;\n" +
                    "And every fair from fair sometime declines,\n" +
                    "By chance or nature’s changing course untrimm'd;\n" +
                    "But thy eternal summer shall not fade,\n" +
                    "Nor lose possession of that fair thou ow’st;\n" +
                    "Nor shall death brag thou wander’st in his shade,\n" +
                    "When in eternal lines to time thou grow’st:\n" +
                    "So long as men can breathe or eyes can see,\n" +
                    "So long lives this, and this gives life to thee.";

    private final List<String> words;
    private final Random random;
    private int correctCount = 0;
    private int incorrectCount = 0;

    public PritheeGame() {
        this.words = Arrays.asList(SONNET.split("\\s+"));
        this.random = new Random();
    }

    // Constructor for testing with deterministic randomness
    public PritheeGame(Random random) {
        this.words = Arrays.asList(SONNET.split("\\s+"));
        this.random = random;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- WELCOME TO THE PRITHEE GAME ---");
        System.out.println("Help the actor remember the missing word!\n");

        while (correctCount < 3 && incorrectCount < 3) {
            int targetIndex = random.nextInt(words.size());
            String targetWord = sanitizeWord(words.get(targetIndex));

            printSonnetUpTo(targetIndex);

            System.out.print("\nPrithee! What is the missing word? ");
            String userGuess = scanner.nextLine().trim();

            if (userGuess.equalsIgnoreCase(targetWord)) {
                correctCount++;
                System.out.println(">> Correct! Score: " + correctCount + " Correct, " + incorrectCount + " Incorrect.\n");
            } else {
                incorrectCount++;
                System.out.println(">> Error! The correct word was: " + targetWord);
                System.out.println(">> Score: " + correctCount + " Correct, " + incorrectCount + " Incorrect.\n");
            }
        }

        if (correctCount == 3) {
            System.out.println("Bravo! You saved the show with 3 correct answers!");
        } else {
            System.out.println("Curtain falls! You made 3 errors. Practice your lines!");
        }
    }

    public void printSonnetUpTo(int stopIndex) {
        for (int i = 0; i <= stopIndex; i++) {
            if (i == stopIndex) {
                System.out.print("___ ");
            } else {
                System.out.print(words.get(i) + " ");
            }

            // Print a new line if the current word ends line punctuation
            if (isLineEnd(i)) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Helper method to detect line endings by checking end punctuation
    private boolean isLineEnd(int index) {
        String word = words.get(index);
        return word.endsWith("?") || word.endsWith(":") || word.endsWith(";") || word.endsWith(".");
    }

    public String sanitizeWord(String word) {
        return word.replaceAll("[^a-zA-Z’']", "");
    }

    public int getCorrectCount() { return correctCount; }
    public int getIncorrectCount() { return incorrectCount; }
    public List<String> getWords() { return words; }
}