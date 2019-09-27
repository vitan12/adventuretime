package com.example;

import com.example.gsonRequired.Adventure;
import com.example.gsonRequired.Room;

public class AdventureLogic {

    private Adventure loadedAdventure;

    /**
     * A basic constructor to initialize the object.
     * @param adventure Takes in an adventure and loads up all relevant methods
     */
    AdventureLogic(Adventure adventure) {
        loadedAdventure = adventure;
    }

    /**
     * Simple getter method to access the loaded Adventure of this instance
     * @return Current loaded adventure
     */
    Adventure getAdventure() {
        return loadedAdventure;
    }

    public Room getStartingRoom() {
        return findRoom(loadedAdventure.getStartingRoom());
    }

    /**
     * This finds a room by its name.
     * @param roomName The room to be gotten.
     * @return A room object with the name given.
     */
    Room findRoom(String roomName) throws NullPointerException {
        for (Room r : loadedAdventure.getRooms()) {
            if (r.getName().equalsIgnoreCase(roomName)) {
                return r;
            }
        }

        // Should never happen if the JSON is formatted properly, which is checked.
        throw new NullPointerException("No room found with given name");
    }
}
