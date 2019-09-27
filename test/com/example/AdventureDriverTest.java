package com.example;

import com.example.AdventureDriver.AdventureStatus;
import com.example.gsonRequired.Adventure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.TestingStrings.*;
import static org.junit.jupiter.api.Assertions.*;

class AdventureDriverTest {

    AdventureDriver testDriver;
    AdventureDriver testNotLoaded;
    private String successLoadingMessage = "Thank you. Your adventure has been loaded";
    private String DEFAULT_URL = "https://pastebin.com/raw/zK0Drn5c";

    @BeforeEach
    void setUp() {
        testDriver = new AdventureDriver();
        testNotLoaded = new AdventureDriver();
        testDriver.loadFromFile("/Users/radhikasriram/IdeaProjects/" +
                "adventure-vitan12/Data/lost_adventure.json");
    }

    @Test
    void initializeGameFile() {
        assertEquals(AdventureStatus.FILEPATH, testNotLoaded.initializeGame("filepath"));
    }

    @Test
    void initializeGameURL() {
        assertEquals(AdventureStatus.URL, testNotLoaded.initializeGame("url"));
    }

    @Test
    void initializeGameDefault() {
        assertEquals(AdventureStatus.DEFAULT, testNotLoaded.initializeGame(""));
    }

    @Test
    void initializeGameExit() {
        assertEquals(AdventureStatus.EXIT, testNotLoaded.initializeGame("exit"));
        assertEquals(AdventureStatus.EXIT, testNotLoaded.initializeGame("quit"));
    }

    @Test
    void initializeGameInvalid() {
        assertEquals(AdventureStatus.INVALID, testNotLoaded.initializeGame("helloWorld"));
        assertEquals(AdventureStatus.INVALID, testNotLoaded.initializeGame("\b\r\nसंस्कृतम्"));
    }



    @Test
    void loadFromFile() {
        assertEquals(successLoadingMessage,
                testNotLoaded.loadFromFile("/Users/radhikasriram/IdeaProjects/" +
                        "adventure-vitan12/Data/lost_adventure.json"));
    }

    @Test
    void loadFromInvalidFile() {
        assertEquals("Could not load file from path hello world There was an error " +
                        "while reading the file. Couldn't find file in directory: hello world" +
                        "\nPlease Try Again.",
                testNotLoaded.loadFromFile("hello world"));
    }

    @Test
    void loadFromURL() {
        assertEquals(successLoadingMessage,
                testNotLoaded.loadFromURL(DEFAULT_URL));
    }

    @Test
    void loadFromURLError() {
        assertEquals("Could not load file from URL helloworld " +
                        "no protocol: helloworld\nPlease Try Again.",
                testNotLoaded.loadFromURL("helloworld"));
    }

    @Test
    void isAdventureLoadedTrue() {
        testNotLoaded.loadFromFile("/Users/radhikasriram/IdeaProjects/" +
                "adventure-vitan12/Data/lost_adventure.json");
        assertTrue(testNotLoaded.isAdventureLoaded());
    }

    @Test
    void isAdventureLoadedFalse() {
        assertTrue(testDriver.isAdventureLoaded());
    }

    @Test
    void isUserExitingTrue() {
        testDriver.initializeGame("exit");
        assertTrue(testDriver.isUserExiting());
    }

    @Test
    void isUserExitingFalse() {
        assertFalse(testDriver.isUserExiting());
    }

    @Test
    void startAdventure() {
        assertEquals("Your adventure begins here!", testDriver.startAdventure());
    }

    @Test
    void getInformationInitial() {
        testDriver.startAdventure();
        assertEquals(firstInformation, testDriver.getInformation());
    }

    @Test
    void getInformationHungerDown() {
        testDriver.startAdventure();
        testDriver.commandParser("go east");
        testDriver.commandParser("go east");
        testDriver.commandParser("go west");
        testDriver.commandParser("go west");

        assertEquals(hungerDownInformation, testDriver.getInformation());
    }

    @Test
    void getInformationHungerDead() {
        testDriver.startAdventure();
        testDriver.commandParser("go east");
        testDriver.commandParser("go east");
        testDriver.commandParser("go west");
        testDriver.commandParser("go west");
        testDriver.commandParser("go east");

        assertEquals(hungerGameOver, testDriver.commandParser("go east"));
    }

    @Test
    void commandParserGo() {
        assertEquals(goTestResult, testDriver.commandParser("go east"));
    }

    @Test
    void commandParserGoInvalid() {
        assertEquals("I can't go west",
                testDriver.commandParser("go west"));
    }

    @Test
    void commandParserGoTooManyArguments() {
        assertEquals("I can't go west ioawjdowjd",
                testDriver.commandParser("go west ioawjdowjd"));
    }

    @Test
    void commandParserInventory() {
        assertEquals("You do not have anything in your inventory",
                testDriver.commandParser("inventory"));
    }

    @Test
    void commandParserQuit() {
        assertEquals("You've chosen to exit. Have a nice day.",
                testDriver.commandParser("quit"));
    }

    @Test
    void commandParserHelp() {
        assertEquals(helpCommand, testDriver.commandParser("help"));
    }

    @Test
    void commandParserLookAround() {
        assertEquals(lookAroundResult, testDriver.commandParser("look around"));
    }

    @Test
    void commandParserEat() {
        testDriver.commandParser("go east");
        testDriver.commandParser("pickup shiny object");
        testDriver.commandParser("go west");
        testDriver.commandParser("go north");
        testDriver.commandParser("use key with cabin");
        testDriver.commandParser("go cabin");
        testDriver.commandParser("pickup meat");

        assertEquals(commandParserEat, testDriver.commandParser("eat slice of meat"));
    }

    @Test
    void commandParserEatNonFood() {
        testDriver.commandParser("go east");
        testDriver.commandParser("pickup shiny object");

        assertEquals("I can't eat key", testDriver.commandParser("eat key"));
    }

    @Test
    void commandParserLook() {
        assertEquals(lookResult, testDriver.commandParser("look east"));
    }

    @Test
    void commandParserLookInvalid() {
        assertEquals("I can't look wrong",
                testDriver.commandParser("look wrong"));
    }

    @Test
    void commandParserPickup() {
        testDriver.commandParser("go east");
        assertEquals(pickUpItem,
                testDriver.commandParser("pickup shiny object"));
    }

    @Test
    void commandParserPickupNothing() {
        assertEquals("I can't pick up my spirits",
                testDriver.commandParser("pickup my spirits"));
    }

    @Test
    void commandParserUseItemWithSuccess() {
        testDriver.commandParser("go east");
        testDriver.commandParser("pickup shiny object");
        testDriver.commandParser("go west");
        testDriver.commandParser("go north");
        assertEquals("Successfully used. ",
                testDriver.commandParser("use key with cabin"));
    }

    @Test
    void commandParserUseItemWithFail() {
        testDriver.commandParser("go north");
        assertEquals("You don't have that item. You can't use key with cabin",
                testDriver.commandParser("use key with cabin"));
    }

    @Test
    void commandParserUseItemWithInvalid() {
        testDriver.commandParser("go north");
        assertEquals("You don't have that item. You can't use aoiwjd with cabin",
                testDriver.commandParser("use aoiwjd with cabin"));
    }

    @Test
    void commandParserUseInvalidDirection() {
        testDriver.commandParser("go east");
        testDriver.commandParser("pickup shiny object");
        testDriver.commandParser("go west");
        testDriver.commandParser("go north");
        assertEquals("You don't have that item. You can't use key with south",
                testDriver.commandParser("use key with south"));
    }

    @Test
    void commandParserInvalidCommand() {
        assertEquals("I don't understand hey look",
                testDriver.commandParser("hey look"));
    }

    @Test
    void teleporterTestInavlid() {
        testDriver.commandParser("go debug");
        testDriver.commandParser("pickup teleporter");
        assertEquals(roomNames, testDriver.commandParser("teleport oiwjhd"));
    }

    @Test
    void teleporterTestValid() {
        testDriver.commandParser("go debug");
        testDriver.commandParser("pickup teleporter");
        assertEquals(teleporterGetDesc, testDriver.commandParser("teleport theWoods"));
    }

    @Test
    void teleporterTestNoItem() {
        assertEquals("I don't understand teleport oiwjhd",
                testDriver.commandParser("teleport oiwjhd"));
    }

    @Test
    void testWholeGame() {
        testDriver.commandParser("go east");
        testDriver.commandParser("pickup shiny object");
        testDriver.commandParser("go west");
        testDriver.commandParser("go north");
        testDriver.commandParser("use key with cabin");
        testDriver.commandParser("go cabin");
        testDriver.commandParser("pickup meat");
        testDriver.commandParser("eat slice of meat");
        testDriver.commandParser("go outside");
        testDriver.commandParser("go south");
        testDriver.commandParser("go northeast");
        testDriver.commandParser("go northeast");
        testDriver.commandParser("go right");

        assertEquals(wholeGame, testDriver.commandParser("go northeast"));
    }

    @Test
    void testDeath() {
        testDriver.commandParser("go east");
        testDriver.commandParser("pickup shiny object");
        testDriver.commandParser("go west");
        testDriver.commandParser("go north");
        testDriver.commandParser("use key with cabin");
        testDriver.commandParser("go cabin");
        testDriver.commandParser("pickup meat");
        testDriver.commandParser("eat slice of meat");
        testDriver.commandParser("go outside");
        testDriver.commandParser("go south");
        testDriver.commandParser("go northeast");
        testDriver.commandParser("go northeast");
        testDriver.commandParser("go left");

        assertEquals(deathGame, testDriver.commandParser("go left"));
    }
}