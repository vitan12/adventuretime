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

class DirectionTest {

    private Adventure currentTestedAdventure;
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
            currentTestedAdventure = parseAdventureFromString(file);
            testingFirstRoom = currentTestedAdventure.getRooms()[0];
            testingLastRoom = currentTestedAdventure.getRooms()[10];
        } catch (AdventureParsingException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void getDirectionName() {
        assertEquals("East", testingFirstRoom.getDirections()[0].getDirectionName());
        assertEquals(0, testingLastRoom.getDirections().length);

    }

    @Test
    void getDirectionDescription() {
        assertEquals("Looking towards the east, you see the dirt and grass turn to pebbles and sand.\n" +
                        "The smell of the sea washes over you, as do the faint sounds of water. It doesn't seem to " +
                        "be too far off.",
                testingFirstRoom.getDirections()[0].getDirectionDescription());
        assertEquals(0,
                testingLastRoom.getDirections().length);
    }

    @Test
    void getRoom() {
        assertEquals("BeachPath", testingFirstRoom.getDirections()[0].getRoomName());
        assertEquals(0, testingLastRoom.getDirections().length);

    }

    @Test
    void getEnabled() {
        assertTrue(testingFirstRoom.getDirections()[0].isEnabled());
        assertEquals(0, testingLastRoom.getDirections().length);

    }

    @Test
    void getValidKeyNames() {
        assertEquals(0, testingFirstRoom.getDirections()[0].getValidKeyNames().length);
        assertEquals(0, testingLastRoom.getDirections().length);
    }

    @Test
    void isHidden() {
        assertFalse(testingFirstRoom.getDirections()[0].isHidden());
        assertEquals(0, testingLastRoom.getDirections().length);

    }

    @Test
    void getRoomName() {
        assertEquals("BeachPath", testingFirstRoom.getDirections()[0].getRoomName());
        assertEquals(0, testingLastRoom.getDirections().length);
    }

    @Test
    void testSetEnabled() {
        testingFirstRoom.getDirections()[0].setEnabled(false);
        assertFalse(testingFirstRoom.getDirections()[0].isEnabled());
    }
}