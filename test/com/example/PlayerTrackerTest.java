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

class PlayerTrackerTest {

    private AdventureLogic currentTestedAdventure;
    private Room testingItemRoom;
    private Room testingFoodRoom;
    private PlayerTracker player;

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
            testingItemRoom = currentTestedAdventure.getAdventure().getRooms()[1];
            testingFoodRoom = currentTestedAdventure.getAdventure().getRooms()[4];
            player = new PlayerTracker(currentTestedAdventure);

        } catch (AdventureParsingException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void moveRoom() {
        player.moveRoom("Death");
        assertEquals("Death", player.getCurrentRoom().getName());
    }

    @Test
    void isDead() {
        player.moveRoom("Death");
        assertTrue(player.isDead());
    }

    @Test
    void getInventory() {
        assertEquals(0, player.getInventory().size());
        player.pickUpItem(testingItemRoom.getItems()[0]);
        assertEquals(1, player.getInventory().size());
    }

    @Test
    void inventoryAsString() {
        assertEquals("You do not have anything in your inventory",
                player.inventoryAsString());
        player.pickUpItem(testingItemRoom.getItems()[0]);
        assertEquals("In your inventory, you have: Key, ",
                player.inventoryAsString());
    }

    @Test
    void getCurrentRoom() {
        assertEquals("TheWoods", player.getCurrentRoom().getName());
    }

    @Test
    void eatItem() {
        assertFalse(player.eatItem(testingItemRoom.getItems()[0]));
        assertTrue(player.eatItem(testingFoodRoom.getItems()[0]));
        assertEquals(15, player.getTurnsTillDeath());
    }

    @Test
    void getTurnsTillDeath() {
        assertEquals(6, player.getTurnsTillDeath());
        player.moveRoom("FoodRoom");
        assertEquals(5, player.getTurnsTillDeath());
        player.moveRoom("TheCity");
        assertEquals(Integer.MAX_VALUE, player.getTurnsTillDeath());
    }

    @Test
    void pickUpItem() {
        player.pickUpItem(testingItemRoom.getItems()[0]);
        assertEquals("In your inventory, you have: Key, ",
                player.inventoryAsString());
    }

    @Test
    void getTotalMoves() {
        player.moveRoom("TheCity");
        assertEquals(1, player.getTotalMoves());
    }

    @Test
    void hasReachedEnd() {
        player.moveRoom("TheCity");
        assertTrue(player.hasReachedEnd());
    }
}