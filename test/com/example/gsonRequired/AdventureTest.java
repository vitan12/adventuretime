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

class AdventureTest {

    private Adventure currentTestedAdventure;

    private String[] roomNames = new String[] {
            "TheWoods",
            "BeachPath",
            "BeachShack",
            "ForestCabin",
            "FoodRoom",
            "Foothill",
            "MountainPass",
            "TheFall",
            "Death",
            "PathToCity",
            "TheCity",
            "Debug"
    };
    private String[] hungerStatus = new String[] {
            "Your stomach rumbles. It had been days since you had last eaten. Looking across the landscape, " +
                    "game and fruit seemed to be sparse, and water was out of sight.\n" +
                    "Though currently willpower might be enough to hold yourself together, you question " +
                    "how long you might last.",
            "With each step, your arms and legs seem heavier, your midsection aching as you push yourself forward.\n" +
                    "Though the thoughts of survival keep the hunger at bay, it gnaws on your will with a persistence " +
                    "that could not be ignored.",
            "As you step forward, you knees buckle underneath you, your strength failing to keep you up " +
                    "as hunger and thirst claw at your mind.\n" +
                    "You find your vision slowly growing dark as your body " +
                    "tries to conserve what little energy it has left. As the world fades away, you wonder " +
                    "what else you could have done."
    };

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
    void testGetStartingRoom() {
        assertEquals("TheWoods", currentTestedAdventure.getStartingRoom());
    }

    @Test
    void testGetEndingRoom() {
        assertEquals("TheCity", currentTestedAdventure.getEndingRoom());
    }

    @Test
    void testGetRooms() {
        for (int i = 0; i < roomNames.length; i++) {
            assertEquals(roomNames[i], currentTestedAdventure.getRooms()[i].getName());
        }
    }

    @Test
    void testHungerStatus() {
        for (int i = 0; i < hungerStatus.length; i++) {
            assertEquals(hungerStatus[i], currentTestedAdventure.getHungerStatus()[i]);
        }
    }

    @Test
    void testGetPlayer() {
        assertEquals(0, currentTestedAdventure.getPlayer().getItems().length);
    }

}