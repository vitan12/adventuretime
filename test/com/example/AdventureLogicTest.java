package com.example;

import com.example.gsonRequired.Adventure;
import com.example.gsonRequired.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.AdventureParser.parseAdventureFromString;
import static org.junit.jupiter.api.Assertions.*;

class AdventureLogicTest {
    private AdventureLogic currentTestedAdventure;
    private Room testingFirstRoom;
    private Room testingLastRoom;

    // Derived from Data class provided in previous MP. Is only used to locally search for json files.
    private static String getFileContentsAsString(String filename) {
        final Path path = FileSystems.getDefault().getPath("data", filename);
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.out.println("Couldn't find file: " + filename);
            return null;
        }
    }

    @BeforeEach
    void setup() {
        try {
            String file = getFileContentsAsString("lost_adventure.json");
            Adventure test = parseAdventureFromString(file);
            currentTestedAdventure = new AdventureLogic(test);
            testingFirstRoom = currentTestedAdventure.getAdventure().getRooms()[0];
            testingLastRoom = currentTestedAdventure.getAdventure().getRooms()[10];
        } catch (AdventureParsingException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Since parsing has already been tested, this just makes sure it can grab one
     * field right from the constructor.
     */
    @Test
    void getAdventureTest() {
        assertEquals("TheWoods", currentTestedAdventure.getAdventure().getStartingRoom());
    }

    @Test
    void getStartingRoomTest() {
        assertEquals("TheWoods", currentTestedAdventure.getStartingRoom().getName());
    }

    @Test
    void findRoomTest() {
        assertEquals("Death", currentTestedAdventure.findRoom("Death").getName());
    }

    @Test
    void findRoomTestInvalid() {
        try {
            currentTestedAdventure.findRoom("Doesnotexist").getName();
        } catch (NullPointerException e) {
            assertEquals("No room found with given name", e.getMessage());
        }
    }
}