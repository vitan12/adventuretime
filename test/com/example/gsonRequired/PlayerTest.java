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

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Adventure currentTestedAdventure;

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
        FileParser parser = new FileParser();
        AdventureParser adventureParser = new AdventureParser();
        try {
            String file = getFileContentsAsString("lost_adventure.json");
            currentTestedAdventure = adventureParser.parseAdventureFromString(file);
        } catch (AdventureParsingException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    void testPlayerInventory() {
        assertEquals(0, currentTestedAdventure.getPlayer().getItems().length);
    }

}