package com.example;

import com.example.gsonRequired.Adventure;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import static com.example.AdventureValidator.isAdventureValid;
import static com.example.AdventureValidator.mapValidator;

public class AdventureParser {

    /**
     * Takes the String and parses it into the Adventure Java object
     * @param jsonFile The Json file to be parsed as a string
     * @return A valid puzzle object
     * @throws AdventureParsingException If thrown, will contain a message of what happened.
     */
    static public Adventure parseAdventureFromString(String jsonFile) throws AdventureParsingException {
        if (jsonFile == null) {
            throw new AdventureParsingException("Null string received");
        }

        Gson gson = new Gson();
        Adventure adventure;
        try {
            adventure = gson.fromJson(jsonFile, Adventure.class);
        } catch (JsonSyntaxException e) {
            throw new AdventureParsingException("The JSON was not able to be parsed " + e.getMessage());
        }

        if (adventure.getRooms() == null && adventure.getStartingRoom() == null && adventure.getEndingRoom()== null) {
            throw new AdventureParsingException("There is a Syntax issue in the JSON file or the GSON classes. " +
                    "A required field is null.");
        }

        return adventure;
    }

    /**
     * This takes a url from the user, passes it into FileParser and tries to get a valid puzzle to load
     * @param url String URL.
     * @return True if puzzle was loaded successfully, false if otherwise, with a printed message of what went wrong
     */
    static Adventure loadAdventureFromURL(String url) throws AdventureParsingException{
        Adventure toBeReturned;
        FileParser fileParser = new FileParser();

        if (url == null) {
            throw new AdventureParsingException("Null string received");
        }

        try {
            //Can throw URL/Unirest exceptions for bad URLs, and JSON Parse exceptions for improper formatting
            toBeReturned = parseAdventureFromString(fileParser.getURLContentsAsString(url));

            //This does a null check. If any field is null, isAdventureValid throws a null pointer exception
            if (isAdventureValid(toBeReturned) && mapValidator(toBeReturned)) {
                return toBeReturned;
            }

        } catch (AdventureParsingException e) {
            throw new AdventureParsingException("Could not load file from URL " + url + " " + e.getMessage());
        }

        throw new AdventureParsingException("This should not be thrown, please check the method");
    }

    /**
     * Method to load a json Adventure from file. It takes in a path and returns a boolean
     * based on whether or not it was successful
     * @param fileName the path to the json file
     * @return True if succeeded.
     * @throws AdventureParsingException is thrown if there's any sort of exception while doing it, with a
     * message as to what went wrong.
     */
    static Adventure loadAdventureFromFile(String fileName) throws AdventureParsingException{
        Adventure toBeReturned;
        FileParser fileParser = new FileParser();

        if (fileName == null) {
            throw new AdventureParsingException("Null string received");
        }

        try {
            // Can throw an exception if the file is not formatted correctly, or there's some issue with the path.
            toBeReturned = parseAdventureFromString(fileParser.getFileContentsAsString(fileName));

            //This does a validation check. If any field is invalid, isAdventureValid throws a null pointer exception
            if (isAdventureValid(toBeReturned) && mapValidator(toBeReturned)) {
                return toBeReturned;
            }
        } catch (AdventureParsingException e) {
            throw new AdventureParsingException("Could not load file from path " + fileName + " " + e.getMessage());
        }

        throw new AdventureParsingException("This should not be thrown, please check the method");
    }
}
