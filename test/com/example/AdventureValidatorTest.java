package com.example;

import com.example.gsonRequired.Adventure;
import com.example.gsonRequired.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static com.example.AdventureValidator.mapValidator;
import static org.junit.jupiter.api.Assertions.*;

class AdventureValidatorTest {

    Adventure testAdventure;

    @BeforeEach
    void setUp() {
        // Inflection implementation based off of code from here:
        // http://blog.sevagas.com/?Modify-any-Java-class-field-using-reflection
        try {
            testAdventure = AdventureParser.parseAdventureFromString(TestingStrings.MY_ADVENTURE_JSON);
        } catch (AdventureParsingException e) {
            System.out.println("MY_ADVENTURE_JSON is messed up in Testing Strings. Please check. ");
        }
    }

    @Test
    void isAdventureValid() throws Exception {
        assertTrue(AdventureValidator.isAdventureValid(testAdventure));
    }

    @Test
    void testAdventureNull() throws Exception {
        try {
            AdventureValidator.isAdventureValid(null);
        } catch (AdventureParsingException e) {
            assertEquals("Some of the fields of this adventure are not populated.", e.getMessage());
        }
    }

    @Test
    void testStartingRoomNull() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("startingRoom");
            field.setAccessible(true);
            field.set(testAdventure, null);
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("Some of the fields of this adventure are not populated.", e.getMessage());
        }
    }

    @Test
    void testEndingRoomNull() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("endingRoom");
            field.setAccessible(true);
            field.set(testAdventure, null);
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("Some of the fields of this adventure are not populated.", e.getMessage());
        }
    }

    @Test
    void testRoomArrayNull() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("rooms");
            field.setAccessible(true);
            field.set(testAdventure, null);
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("Some of the fields of this adventure are not populated.", e.getMessage());
        }
    }

    @Test
    void testHungerStatusNull() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("hungerStatus");
            field.setAccessible(true);
            field.set(testAdventure, null);
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("Some of the fields of this adventure are not populated.", e.getMessage());
        }
    }

    @Test
    void testPlayerNull() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("player");
            field.setAccessible(true);
            field.set(testAdventure, null);
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("Some of the fields of this adventure are not populated.", e.getMessage());
        }
    }

    @Test
    void testStartingRoomInvalidName() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("startingRoom");
            field.setAccessible(true);
            field.set(testAdventure, "invalidName");
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("The starting or ending room does not have a valid name", e.getMessage());
        }
    }

    @Test
    void testEndRoomInvalidName() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("endingRoom");
            field.setAccessible(true);
            field.set(testAdventure, "invalidName");
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("The starting or ending room does not have a valid name", e.getMessage());
        }
    }

    @Test
    void testInvalidNumberHungerMessages() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("hungerStatus");
            field.setAccessible(true);
            field.set(testAdventure, new String[] {"invalid"});
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("There must be three different hunger status messages", e.getMessage());
        }
    }

/*    @Test
    void testRoomWithNullName() throws Exception {
        try {
            Field field = testAdventure.getClass().getDeclaredField("rooms");
            field.setAccessible(true);
            field.set(testAdventure, new Room[] {)};
            assertTrue(AdventureValidator.isAdventureValid(testAdventure));
        } catch (AdventureParsingException e) {
            assertEquals("There must be three different hunger status messages", e.getMessage());
        }
    }*/


    @Test
    void mapValidatorTestTrue() throws Exception {
        assertTrue(mapValidator(testAdventure));
    }

    //Uses inflection in order to bypass checks in set and
    // assigning adventures and checks validation that starting room cannot be reached from ending room
    @Test
    void mapValidatorTestFalse() throws Exception {
        Field field = testAdventure.getClass().getDeclaredField("startingRoom");
        field.setAccessible(true);
        field.set(testAdventure, "Death");
        assertFalse(mapValidator(testAdventure));
    }
}