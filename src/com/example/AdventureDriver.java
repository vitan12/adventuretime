package com.example;

import com.example.gsonRequired.Direction;
import com.example.gsonRequired.Item;
import com.example.gsonRequired.Room;

import java.util.*;

public class AdventureDriver {

    private String successLoadingMessage = "Thank you. Your adventure has been loaded";
    private String errorMessage = "There has been an error.";
    private String openingMessage = "Your adventure begins here!";

    private boolean userHasExited = false;
    private boolean adventureLoaded = false;
    private AdventureLogic currentAdventure;
    private PlayerTracker player;

    /**
     * Keeps the status of the file check in place
     */
    public enum AdventureStatus {
        FILEPATH, URL, DEFAULT, EXIT, INVALID, BYPASS
    }

    /**
     * Gets if the user wants to use default, file, or url
     * @param input A string of the user input
     * @return an enum of what the code should do.
     */
    public AdventureStatus initializeGame(String input) {
        if (input.toLowerCase().contains("filepath")) {
            return AdventureStatus.FILEPATH;

        } else if (input.toLowerCase().contains("url")) {
            return AdventureStatus.URL;

        } else if (input.toLowerCase().contains("exit")
                || input.toLowerCase().contains("quit")) {
            userHasExited = true;
            return AdventureStatus.EXIT;

        } else if (input.equals("")) {
            return AdventureStatus.DEFAULT;

        } else {
            return AdventureStatus.INVALID;
        }
    }

    /**
     * Loads a file from disk
     * @param filePath the absolute path to file
     * @return A string with a success/error message.
     */
    public String loadFromFile(String filePath) {
        try {
            currentAdventure = new AdventureLogic(AdventureParser.loadAdventureFromFile(filePath));
        } catch (AdventureParsingException e) {
            return e.getMessage() + "\nPlease Try Again.";
        }
        player = new PlayerTracker(currentAdventure);
        adventureLoaded = true;

        return successLoadingMessage;
    }

    /**
     * Takes in a url to parse and initializes the game
     * @param url The URL to fetch from
     * @return A string with a success/error message.
     */
    public String loadFromURL(String url) {
        try {
            currentAdventure = new AdventureLogic(AdventureParser.loadAdventureFromURL(url));
        } catch (AdventureParsingException e) {
            return e.getMessage() + "\nPlease Try Again.";
        }
        player = new PlayerTracker(currentAdventure);
        adventureLoaded = true;

        return successLoadingMessage;
    }

    /**
     * Simple getter to check if adventure is loaded
     * @return true if adventure is loaded.
     */
    public boolean isAdventureLoaded() {
        return adventureLoaded;
    }

    /**
     * Getter to check if the user wants to exit
     * @return true if the user has chosen to exit
     */
    public boolean isUserExiting() {
        return userHasExited;
    }

    /**
     * Gets the initial text and/or any errors with validation and such
     * @return A string with the opening message.
     */
    public String startAdventure() {
        if  (!adventureLoaded) {
            return errorMessage;
        } else if (userHasExited) {
            return "";
        } else {
            return openingMessage;
        }
    }

    /**
     * Pretty prints the directions in an array as a string
     * @return a proper formatted string with all visible names.
     */
    private String getValidDirectionAsString() {
        Room currentRoom = player.getCurrentRoom();
        List<Direction> validDirections = new ArrayList<>();

        for (Direction d : currentRoom.getDirections()) {
            if (!d.isHidden()) {
                validDirections.add(d);
            }
        }

        if (validDirections.size() == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder("\nFrom here you can go: ");
        for (int i = 0; i < validDirections.size(); i++) {
            Direction d = validDirections.get(i);

            if (validDirections.size() == 1) {
                return stringBuilder.append(validDirections.get(0).getDirectionName()).toString();

            } else if (i == validDirections.size() - 1) {
                stringBuilder.append("or " + d.getDirectionName());

            } else {
                stringBuilder.append(d.getDirectionName() + ", ");

            }
        }
        return stringBuilder.toString();
    }

    /**
     * Takes all the items in a room and pretty prints them
     * @return Grammatically correct (more or less) string with all visible items
     */
    private String getValidItemsAsString() {
        Room currentRoom = player.getCurrentRoom();
        List<Item> validItems = new ArrayList<>();

        for (Item item : currentRoom.getItems()) {
            if (item.isPrinted() && item.isEnabled()) {
                validItems.add(item);
            }
        }

        if (validItems.size() == 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder("\nHere you can see: ");
        for (int i = 0; i < validItems.size(); i++) {
            Item item = validItems.get(i);

            if (validItems.size() == 1) {
                return stringBuilder.append(validItems.get(0).getItemName()).toString();

            } else if (i == validItems.size() - 1) {
                stringBuilder.append("or " + item.getItemName());

            } else {
                stringBuilder.append(item.getItemName() + ", ");

            }
        }
        return stringBuilder.toString();
    }

    /**
     * Simple getter to check if the game is over
     * @return true if the game has ended due to player death/winning.
     */
    private boolean isGameOver() {
        return player.isDead() || player.hasReachedEnd();
    }

    /**
     * Gets the hunger status based on how mnay moves the player has made
     * @return A string 0, 1, 2 depending on how many moves they have till death.
     */
    private String getHungerStatus() {
        String[] hungerMessages = currentAdventure.getAdventure().getHungerStatus();
        if (hungerMessages.length < 3) {
            return  "";
        } else if (player.getTurnsTillDeath() == 2) {
            return hungerMessages[0];
        } else if (player.getTurnsTillDeath() == 1) {
            return hungerMessages[1];
        } else if (player.getTurnsTillDeath() == 0) {
            return hungerMessages[2];
        }

        return "";
    }

    /**
     * Grabs all the information to be printed out
     * @return a string with all the information the player needs to know.
     */
    public String getInformation() {
        StringBuilder returnedString = new StringBuilder(player.getCurrentRoom().getDescription());
        returnedString.append(getValidDirectionAsString());
        returnedString.append(getValidItemsAsString());
        returnedString.append("\n");
        returnedString.append(getHungerStatus());
        if (isGameOver()) {
            returnedString.append("\nYour game is over.");
            returnedString.append("\nYou took " + player.getTotalMoves() + " moves this game!");
            userHasExited = true;
        }

        return returnedString.toString();
    }

    /**
     * A command parser that takes a string, tokenizes it, and does an action.
     * @param userResponse An input string
     * @return A string with what the action should do.
     */
    public String commandParser(String userResponse) {
        if (userResponse.equalsIgnoreCase("quit") || userResponse.equalsIgnoreCase("exit")) {
            userHasExited = true;
            return "You've chosen to exit. Have a nice day.";
        }

        if (userResponse.equalsIgnoreCase("inventory")) {
            return player.inventoryAsString();

        } else if (userResponse.equalsIgnoreCase("help")) {
            return "Commands: \"Pickup ____\",  \"Go ____\", \"Eat ____\", Inventory, " +
                    "\"Look ____\", \"Look around\", and \"Use item with Direction\". You can also exit.";

        } else if (userResponse.equalsIgnoreCase("look around")) {
            return getInformation();
        }

        // Tokenization.
        String command;
        String arguments;

        try {
            String[] tokenizedCommand = userResponse.split(" ", 2);
            command = tokenizedCommand[0];
            arguments = tokenizedCommand[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Sorry, I didn't understand that";
        }

        if (command.equalsIgnoreCase("go")) {
            return tryToMove(arguments);

        } else if (command.equalsIgnoreCase("eat")) {
            return tryToEat(arguments);

        } else if (command.equalsIgnoreCase("look")) {
            return tryToLook(arguments);

        } else if (command.equalsIgnoreCase("use")) {
            return tryToUse(arguments);

        } else if (command.equalsIgnoreCase("pickup")) {
            return tryToPickUp(arguments);
        } else if (command.equalsIgnoreCase("teleport")) {
            return tryToTeleport(arguments);
        }

        return "I don't understand " + userResponse;
    }

    /**
     * A teleporter parser
     * @param room The room to teleport to
     * @return The description of the room teleported to.
     */
    private String tryToTeleport(String room) {
        boolean teleporterAcquired = false;
        for (Item i : player.getInventory()) {
            if (i.getItemName().equalsIgnoreCase("teleporter")) {
                teleporterAcquired = true;
                break;
            }
        }

        if (teleporterAcquired) {
            if (player.moveRoom(room)) {
                return getInformation();
            } else {
                return "This is not a valid room name" +
                        getRoomNames();
            }
        }
        return "I don't understand teleport " + room;
    }

    /**
     * Attempts to pick up an item based on the argument
     * @param item What to pick up
     * @return A string based on if it was successful or not.
     */
    private String tryToPickUp(String item) {
        for (Item check : player.getCurrentRoom().getItems()) {
            if (item.equalsIgnoreCase(check.getItemName()) && check.isEnabled()) {
                player.pickUpItem(check);
                check.setEnabled(false);
                return check.getDescription();
            }
        }
        return "I can't pick up " + item;
    }

    /**
     * Tries to move in the command's name direction
     * @param direction The direction to move
     * @return A string based on if the move is valid. .
     */
    private String tryToMove(String direction) {
        for (Direction check : player.getCurrentRoom().getDirections()) {
            if (direction.equalsIgnoreCase(check.getDirectionName())) {
                if (check.isEnabled()) {
                    player.moveRoom(check.getRoomName());
                    return getInformation();
                }
                return "There's something preventing you from going here.";
            }
        }
        return "I can't go " + direction;
    }

    /**
     * Tries to eat the item given
     * @param itemToEat The item to be eaten
     * @return A string based on if the user has the item, and if that item
     * is able to be eaten.
     */
    private String tryToEat(String itemToEat) {
        for (Item check : player.getInventory()) {
            if (itemToEat.equalsIgnoreCase(check.getInventoryName())) {
                if (check.isEdible()) {
                    player.eatItem(check);
                    return check.getEatingInformation();
                }
            }
        }

        return "I can't eat " + itemToEat;
    }

    /**
     * Tries to look in a direction
     * @param direction The direction to look at
     * @return A string if successful of the direction's description
     * or a string as to what the issue with the command is
     */
    private String tryToLook(String direction) {
        for (Direction check : player.getCurrentRoom().getDirections()) {
            if (direction.equalsIgnoreCase(check.getDirectionName())) {
                return check.getDirectionDescription();
            }
        }

        return "I can't look " + direction;
    }

    /**
     * Tries to use an object with the command
     * @param direction The argument to use ___.
     * @return Checks if the item is valid, and if it can be used with the direction.
     */
    private String tryToUse(String direction) {
        String itemToUse;
        String secondCommand;
        String directionToUse;

        try {
            String[] tokenizedCommand = direction.split(" ", 3);
            itemToUse = tokenizedCommand[0];
            secondCommand = tokenizedCommand[1];
            directionToUse = tokenizedCommand[2];

        } catch (ArrayIndexOutOfBoundsException e) {
            return "I don't understand. The command is formatted use ITEM with DIRECTION";
        }

        Direction toBeUsedOn = null;

        for (Direction d : player.getCurrentRoom().getDirections()) {
            if (d.getDirectionName().equalsIgnoreCase(directionToUse)) {
                toBeUsedOn = d;
            }
        }

        if (toBeUsedOn == null) {
            return "That is not a valid direction";
        }

        for (Item i : player.getInventory()) {
            if (itemToUse.equalsIgnoreCase(i.getInventoryName())) {
                if (!secondCommand.equalsIgnoreCase("with")) {
                    return "I don't understand. I can't use " + direction;
                } else {
                    for (String key : toBeUsedOn.getValidKeyNames()) {
                        if (key.equalsIgnoreCase(i.getItemName())) {
                            toBeUsedOn.setEnabled(true);
                            return "Successfully used. ";
                        }
                    }
                }
            }
        }
        return "You don't have that item. You can't use " + direction;
    }

    /**
     * Simple getter to get all room names a string.
     * @return All room names as a string.
     */
    private String getRoomNames() {
        StringBuilder stringBuilder = new StringBuilder("Room in this game: ");
        for (Room r : currentAdventure.getAdventure().getRooms()) {
            stringBuilder.append(r.getName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}
