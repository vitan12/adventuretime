package com.example;

import com.example.gsonRequired.Adventure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventureParserTest {
    Adventure testAdventure;
    private String pathToRealFile = "/Users/radhikasriram/IdeaProjects/adventure-vitan12/Data/lost_adventure.json";

    @Test
    void parseAdventureFromString() throws Exception {
        testAdventure = AdventureParser.parseAdventureFromString(TestingStrings.MY_ADVENTURE_JSON);
        assertEquals("TheWoods", testAdventure.getStartingRoom());
    }

    @Test
    void parseAdventureFromStringNull() throws Exception {
        assertThrows(AdventureParsingException.class, () ->
                testAdventure = AdventureParser.parseAdventureFromString(null)
        );
    }

    @Test
    void parseAdventureFromURL() throws Exception {
        testAdventure = AdventureParser.loadAdventureFromURL("https://pastebin.com/raw/zK0Drn5c");
        assertEquals("TheWoods", testAdventure.getStartingRoom());
    }

    @Test
    void parseAdventureFromURLNull() throws Exception {
        assertThrows(AdventureParsingException.class, () ->
                testAdventure = AdventureParser.loadAdventureFromURL(null)
        );
    }

    @Test
    void parseAdventureFromFile() throws Exception {
        testAdventure = AdventureParser.loadAdventureFromFile(pathToRealFile);
        assertEquals("TheWoods", testAdventure.getStartingRoom());
    }
    @Test
    void parseAdventureFromFileNull() throws Exception {
        assertThrows(AdventureParsingException.class, () ->
                testAdventure = AdventureParser.loadAdventureFromFile(null)
        );
    }
}