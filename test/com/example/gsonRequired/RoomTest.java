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

class RoomTest {

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
            testingLastRoom = currentTestedAdventure.getRooms()[11];
        } catch (AdventureParsingException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void getName() {
        assertEquals("TheWoods", testingFirstRoom.getName());
        assertEquals("Debug", testingLastRoom.getName());
    }

    @Test
    void getDescription() {
        assertEquals("As you step forward, the sunlight washing over you in a deep golden wave, " +
                        "a forest stands in front of you.\n" +
                        "The dense woodland forms a natural wall from which you wondered how you managed " +
                        "to find your way out of.\n" +
                        "Looking back, the shadows seem to grow with each passing moment, looming closer and " +
                        "closer as the darkness aims to swallow up the world for another night.\n" +
                        "Shuddering, you place the wooded barrier to your back and turn to look forward.\n" +
                        "You see a natural path cut into the grass before you, diverging just a little ways ahead.",
                testingFirstRoom.getDescription());
        assertEquals("Walking back into the forest, you find that around you, there was nothing but a bright white.\n" +
                "The floor appears underneath you with each step as you see an item hovering in the middle.",
                testingLastRoom.getDescription());
    }

    @Test
    void getDirections() {
        assertEquals(4, testingFirstRoom.getDirections().length);
        assertEquals(0, testingLastRoom.getDirections().length);
    }

    @Test
    void getItems() {
        assertEquals(0, testingFirstRoom.getItems().length);
        assertEquals(1, testingLastRoom.getItems().length);
    }
}