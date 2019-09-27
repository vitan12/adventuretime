package com.example;

import com.example.gsonRequired.Item;
import com.example.gsonRequired.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerTracker {
    private List<Item> inventory;
    private int turnsTillDeath = 6;
    private int totalMoves = 0;
    private Room currentRoom;
    private AdventureLogic currentAdventure;

    /**
     * Attempts to move to the given room. If possible returns true
     * @param roomName Room name as string
     * @return True if possible.
     */
    public boolean moveRoom(String roomName) {
        try {
            currentRoom = currentAdventure.findRoom(roomName);
            turnsTillDeath--;
            totalMoves++;
        } catch (NullPointerException e) {
            return false;
        }

        return true;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    /**
     * Checks if the player is in a room called death, for death by actions, or the counter
     * for death by hunger
     * @return true if the player is dead.
     */
    public boolean isDead() {
        return currentRoom.getName().equalsIgnoreCase("Death") || turnsTillDeath < 1;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    /**
     * Formats the inventory as a string
     * @return a basic english sentence of what's in the inveentory
     */
    public String inventoryAsString() {
        if (inventory.isEmpty()) {
            return "You do not have anything in your inventory";
        }
        StringBuilder stringBuilder = new StringBuilder("In your inventory, you have: ");
        for (Item i : inventory) {
            stringBuilder.append(i.getInventoryName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Checks if an item can be eaten, and eats it
     * @param toBeEaten The item to eat
     * @return true if succeeded.
     */
    public boolean eatItem(Item toBeEaten) {
        if (toBeEaten.isEdible()) {
            inventory.remove(toBeEaten);
            turnsTillDeath = 15;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Simple getter to check how many turns till death. If player has won, number set to Int max since
     * player cannot die.
     * @return
     */
    public int getTurnsTillDeath() {
        if (!hasReachedEnd()) {
            return turnsTillDeath;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    public boolean hasReachedEnd() {
        return currentRoom.getName().equals(currentAdventure.getAdventure().getEndingRoom());
    }

    /**
     * Initializes all the fields
     * @param newAdventure The adventure to associate with this player.
     */
    public PlayerTracker(AdventureLogic newAdventure) {
        currentAdventure = newAdventure;
        currentRoom = currentAdventure.getStartingRoom();
        inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(currentAdventure.getAdventure().getPlayer().getItems()));
    }
}
