package com.example;

import com.example.gsonRequired.Adventure;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Vishal Sriram.
 */

public class FileParser {
    private static final int STATUS_OKAY = 200;


    /**
     * Function to grab the JSON at a given URL address as a string
     * Derived from example code given at https://github.com/zillesc/WashingtonPost/blob/master/src/com/example/Main.java
     *
     * @param url Given URL
     * @throws AdventureParsingException Throws this with the message of what error occured.
     */
    static String getURLContentsAsString(String url) throws AdventureParsingException {

        final HttpResponse<String> stringHttpResponse;

        // This will throw MalformedURLException if the url is malformed.
        try {
            new URL(url);
            stringHttpResponse = Unirest.get(url).asString();

        } catch (MalformedURLException | UnirestException e) {
            throw new AdventureParsingException(e.getMessage());
        }

         // Check to see if the request was successful; if so, convert the payload JSON into Java objects
        if (stringHttpResponse.getStatus() == STATUS_OKAY) {
            return stringHttpResponse.getBody();
        } else {
            throw new AdventureParsingException("Bad URL, Status: " + stringHttpResponse.getStatus());
        }
    }

    /**
     * Derived from the code provided in a previous MP.
     * Finds a file with the given filename and returns the contents as a String.
     * @param filename The filename in the project root
     * @return The contents of the file as a string.
     * @throws AdventureParsingException Throws this if the file is not found.
     */
    private static String readFileAsString(String filename) throws AdventureParsingException {
        try {
            final Path path = Paths.get(filename);
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new AdventureParsingException("Couldn't find file in directory: " + filename);
        }
    }

    /**
     * Finds a file with the given absolute path and returns the contents as a String.
     * @param pathToFile The path to the desired file
     * @return The contents of the file as a string.
     * @throws AdventureParsingException Throws this if the file is not found.
     */
    static String getFileContentsAsString(String pathToFile) throws AdventureParsingException {
        try {
            return readFileAsString(pathToFile);
        } catch (AdventureParsingException e) {
            throw new AdventureParsingException("There was an error while reading the file. " + e.getMessage());
        }
    }
}
