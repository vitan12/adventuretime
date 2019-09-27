package com.example.gsonRequired;

import com.example.AdventureParser;
import com.example.AdventureParsingException;
import com.example.FileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.AdventureParser.parseAdventureFromString;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Adventure currentTestedAdventure;
    private Room testingFirstRoom;
    private Room testingItemRoom;

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
            currentTestedAdventure = parseAdventureFromString(file);
            testingFirstRoom = currentTestedAdventure.getRooms()[0];
            testingItemRoom = currentTestedAdventure.getRooms()[1];
        } catch (AdventureParsingException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void getItemName() {
        assertEquals(0, testingFirstRoom.getItems().length);
        assertEquals("Shiny Object", testingItemRoom.getItems()[0].getItemName());
    }

    @Test
    void getInventoryName() {
        assertEquals(0, testingFirstRoom.getItems().length);
        assertEquals("Key", testingItemRoom.getItems()[0].getInventoryName());

    }

    @Test
    void isPrinted() {
        assertEquals(0, testingFirstRoom.getItems().length);
        assertFalse(testingItemRoom.getItems()[0].isPrinted());

    }

    @Test
    void isEdible() {
        assertEquals(0, testingFirstRoom.getItems().length);
        assertFalse(testingItemRoom.getItems()[0].isEdible());

    }

    @Test
    void getDescription() {
        assertEquals(0, testingFirstRoom.getItems().length);
        assertEquals("The shine in the sand catches your eyes.\n" +
                        "You crouch down to pick it up. As your hand brushes against" +
                        " the surface, you feel the metal shape of what appears to be a key!" +
                        " The sand falls away revealing a rusted key, scarred by the salty air" +
                        " and the water.",
                testingItemRoom.getItems()[0].getDescription());

    }

    @Test
    void testGetEnabled() {
        assertTrue(testingItemRoom.getItems()[0].isEnabled());
    }

    @Test
    void testSetEnabled() {
        testingItemRoom.getItems()[0].setEnabled(false);
        assertFalse(testingItemRoom.getItems()[0].isEnabled());
    }
}