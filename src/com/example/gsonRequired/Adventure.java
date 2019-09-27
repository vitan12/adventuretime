package com.example.gsonRequired;

import com.example.gsonRequired.Room;

public class Adventure {
    private String startingRoom;
    private String endingRoom;
    private Room[] rooms;
    private String[] hungerStatus;
    private Player player;

    public String getStartingRoom() {
        return startingRoom;
    }

    public String getEndingRoom() {
        return endingRoom;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public String[] getHungerStatus() {
        return hungerStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public Adventure() {
    }
}

