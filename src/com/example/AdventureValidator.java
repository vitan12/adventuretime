package com.example;

import com.example.gsonRequired.Adventure;
import com.example.gsonRequired.Direction;
import com.example.gsonRequired.Room;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdventureValidator {

    /**
     * A function to check if a null value is assigned to any field. If so, throw a Null Pointer
     * @param adventure The Adventure to be checked
     * @return true if all fields are valid
     * @throws NullPointerException Thrown if any field is null
     */
    static boolean isAdventureValid(Adventure adventure) throws AdventureParsingException {
        if (adventure == null
                || adventure.getStartingRoom() == null
                || adventure.getEndingRoom() == null
                || adventure.getRooms() == null
                || adventure.getHungerStatus() == null
                || adventure.getPlayer() == null) {

            throw new AdventureParsingException("Some of the fields of this adventure are not populated.");
        }

        try {
            findRoom(adventure.getStartingRoom(), adventure);
            findRoom(adventure.getEndingRoom(), adventure);
        } catch (NullPointerException n) {
            throw new AdventureParsingException("The starting or ending room does not have a valid name");
        }

        if (adventure.getHungerStatus().length != 3) {
            throw new AdventureParsingException("There must be three different hunger status messages");
        }

        for (int i = 0; i < adventure.getRooms().length; i++) {
            Room r =  adventure.getRooms()[i];

            if (r.getName() == null) {
                throw new AdventureParsingException("Room " + i + " is broken and has a null name");

            } else if (r.getDescription() == null) {
                throw new AdventureParsingException("Room " + i + " has a null description");

            } else if (r.getDirections() == null) {
                throw new AdventureParsingException("Room " + i + " has no directions associated with it");

            } else if (r.getItems() == null) {
                throw new AdventureParsingException("The item array for room " + i + " is null." );
            }

            for (int j = 0; j < r.getDirections().length; j++) {
                Direction d = r.getDirections()[j];

                if (d.getDirectionName() == null) {
                    throw new AdventureParsingException("Room " + i + " Direction " + j + " has a null name");

                } else if (d.getRoomName() == null) {
                    throw new AdventureParsingException("Room " + i + " Direction " + j + " has a null room name");

                } else if (d.getDirectionDescription() == null) {
                    throw new AdventureParsingException("Room " + i + " Direction " + j + " has a null room name");

                } else if (d.getValidKeyNames() == null) {
                    throw new AdventureParsingException("Room " + i + " Direction " + j + " has a null key name array");
                }
            }
        }

        // Check if all Room names are unique
        List<String> roomNames = new ArrayList<>();

        for (Room r : adventure.getRooms()) {
            roomNames.add(r.getName());
        }

        Set<String> distinctRooms = new HashSet<String>(roomNames);

        if (distinctRooms.size() != roomNames.size()) {
            throw new AdventureParsingException("There are multiple rooms with the same name");
        }

        // Check if all Directions in a room are unique
        for (Room r : adventure.getRooms()) {

            List<String> directionNames = new ArrayList<>();

            for (Direction d : r.getDirections()) {
                directionNames.add(d.getDirectionName());
            }

            Set<String> distinctDirections = new HashSet<>(directionNames);

            if (distinctDirections.size() != directionNames.size()) {
                throw new AdventureParsingException("There are multiple directions with the same name");
            }
        }

        // TODO Get declared fields would probably be better to do this.
        return true;
    }

    /**
     * A simple map validator that checks if the end room can be reached from the beginning
     * @return True if the starting room has a path to the ending room.
     */
    static boolean mapValidator(Adventure adventureToCheck) {

        if (adventureToCheck.getStartingRoom() == null || adventureToCheck.getEndingRoom() == null) {
            return false;
        }

        List<String> visited = new ArrayList<>();
        return doesPathExist(
                findRoom(adventureToCheck.getStartingRoom(), adventureToCheck),
                findRoom(adventureToCheck.getEndingRoom(), adventureToCheck),
                visited,
                adventureToCheck);
    }

    /**
     * A private helper method to enable recursive searching for room paths
     * @param currentRoom The room that the loop is currently checking
     * @param finalRoom The room to find a path to
     * @param visited A list of all the rooms that the program has visited
     * @return true if a path exists from currentRoom to finalRoom.
     */
    private static boolean doesPathExist(Room currentRoom, Room finalRoom,
                                         List visited, Adventure adventure) {

        visited.add(currentRoom.getName());

        if (currentRoom.getName().equalsIgnoreCase(finalRoom.getName())) {
            return true;
        }

        for (Direction d: currentRoom.getDirections()) {
            if (visited.contains(d.getRoomName())) {
                continue;
            }

            List<String> newVisited = new ArrayList<>(visited);
            boolean hasBeenValidated = doesPathExist(findRoom(d.getRoomName(), adventure),
                    finalRoom, newVisited, adventure);

            if (hasBeenValidated) {
                return true;
            }
        }
        return false;
    }

    /**
     * This finds a room by its name.
     * @param roomName The room to be gotten.
     * @return A room object with the name given.
     */
    private static Room findRoom(String roomName, Adventure adventure)
            throws NullPointerException {
        for (Room r : adventure.getRooms()) {
            if (r.getName().equalsIgnoreCase(roomName)) {
                return r;
            }
        }

        // Should never happen if the JSON is formatted properly
        throw new NullPointerException("No room found with given name");
    }
}
