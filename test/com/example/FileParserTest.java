package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {
    private String pathToRealFile = "/Users/radhikasriram/IdeaProjects/adventure-vitan12/Data/lost_adventure.json";
    private String pathToArbitraryFile = "/Users/radhikasriram/IdeaProjects/adventure-vitan12/Data/notjson";


    @Test
    void getJSONFromURL() throws Exception {
        assertEquals(TestingStrings.fromURL,
                FileParser.getURLContentsAsString("https://pastebin.com/raw/zK0Drn5c")
                        .replaceAll("\n", "")
                        .replaceAll("\r", ""));
    }

    @Test
    void getJSONFromFile() throws Exception {
        assertEquals(TestingStrings.JSON_WITHOUT_LINEBREAKS,
                FileParser.getFileContentsAsString(pathToRealFile)
                        .replaceAll("\n", "")
                        .replaceAll("\r", ""));
    }

    @Test
    void getRandomWebsiteAsString() throws Exception {
        assertEquals("waow",
                FileParser.getURLContentsAsString("https://pastebin.com/raw/m4Xr5NVq"));
    }

    @Test
    void getRandomFileAsString() throws Exception {
        assertEquals("hello world\n", FileParser.getFileContentsAsString(pathToArbitraryFile));
    }

    @Test
    void getPuzzleFromInvalidPath() throws Exception {
        assertThrows(AdventureParsingException.class, () -> {
            FileParser.getFileContentsAsString("hi");
        });
    }

    @Test
    void getPuzzleFromInvalidURL() throws Exception {
        assertThrows(AdventureParsingException.class, () -> {
            FileParser.getFileContentsAsString("hello\bworld!");
        });
    }

    @Test
    void getPuzzleFromNonJSONURL() throws Exception {
        assertThrows(AdventureParsingException.class, () -> {
            FileParser.getURLContentsAsString("https://httpstat.us/403");
        });
    }

    @Test
    public void getPuzzleFromNullString() throws Exception {
        assertThrows(AdventureParsingException.class, () -> {
            FileParser.getURLContentsAsString(null);
        });
    }

}