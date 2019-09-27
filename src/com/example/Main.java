package com.example;


import com.example.AdventureDriver.AdventureStatus;
import com.example.gsonRequired.Direction;

import java.util.Scanner;


public class Main {

    static final String DEFAULT_URL = "https://pastebin.com/raw/eFcKsQvQ";

    /*
     * This is the main method where the scanner object takes in user input and runs through the adventure
     * @param args Default arguments for the main method
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdventureDriver currentGame = new AdventureDriver();
        AdventureStatus status = AdventureStatus.INVALID;

        // Checks if there are command line arguments. If so, ignore the rest if valid.
        if (args.length > 0) {
            currentGame.loadFromFile(args[0]);
            if (currentGame.isAdventureLoaded()) {
                status = AdventureStatus.BYPASS;
            }
        }

        System.out.println("Welcome. Please select if you wish to load an Adventure from a URL or from a Filepath, " +
                "or press enter to load the default game. If an argument was inputted in the command line, please " +
                "wait for it to load.");

        while (status.equals(AdventureStatus.INVALID)) {
            String reponse = scanner.nextLine();
            status = currentGame.initializeGame(reponse);
            if (status.equals(AdventureStatus.INVALID)) {
                System.out.println("Sorry, that was not a valid selection. You can load from URL or filepath or press enter " +
                        "for the default game.");
            }
        }

        // Loads in the file.
        do {
            if (status.equals(AdventureStatus.DEFAULT)) {
                System.out.println(currentGame.loadFromURL(DEFAULT_URL));

            } else if (status.equals(AdventureStatus.FILEPATH)) {
                System.out.println("Please enter the path to the JSON file.");
                String response = scanner.nextLine();
                System.out.println(currentGame.loadFromFile(response));

            } else if (status.equals(AdventureStatus.URL)) {
                System.out.println("Please enter the link to the JSON file.");
                String response = scanner.nextLine();
                System.out.println(currentGame.loadFromURL(response));
            }
        } while (!currentGame.isAdventureLoaded() || status.equals(AdventureStatus.EXIT));

        if (currentGame.isUserExiting()) {
            System.out.println("Thanks for playing!\nGood bye!");
            return;
        }

        // What runs the game.
        System.out.println(currentGame.startAdventure());

        System.out.println(currentGame.getInformation());

        while (!currentGame.isUserExiting()) {
            String response = scanner.nextLine();
            System.out.println(currentGame.commandParser(response));
        }
        System.out.println("Thanks for playing!\nGood bye!");

    }
}
