# Adventure Time!

Things to fix (Feedback from code review):
  - [x] Use whitespace above return statements for clarity
  - [x] Create a new exception type for checking valid fields
  - [x] Update roomValidator() to validateRoom()
  - [x] Modularize the main method and push all logic to functions.
  - [x] Adjust Exception throwing
  - [x] Change getAdventure to adventureParser()
  - [x] Check formatting
  - [x] loadURLAdventure -> loadAdventureFromURl
  - [x] Move annotations (i.g. @Test) below comments in testing files
 
 Things TODO:
  - [x] Fix main method logic to catch errors properly
  - [x] Implement a player class to keep track of inventory
  - [x] Implement user response tokenizer to allow for additional commands
  - [x] Implement a teleporter for debugging the rooms
  - [x] Write a custom JSON adventure
  - [x] Implement value parameterization for input testing
  - [x] Look at declared fields when checking validity of adventure 
  
Changelog: 
 * Worked to edit all the feedback from the last Code review
    * Some issues faced include the splitting of the Adventure logic class into separate classes
    * In addition, problems were faced when moving functions and logic out of the Main 
    method into separate classes
    * Working with custom Exceptions allows for easier error handling and simplifies code as well. 
 * Started working on custom JSON adventure.
    * Planning out the adventure beforehand on paper allowed the visualization of what 
    fields need to be where, allowing for faster development  
 * Finished JSON development, save for some fancy descriptions. The planning really helped with this step
 and now work can begin to modify the logic to fit all the new stuff in the JSON.
 * Finished writing tests for all JSON files and have confirmed that the deserialization classes work as intended.
 * Split up the parsing and validating classes to have static methods as these are utility methods and should not be
 tied down to a specific instance. The AdventureLogic and future AdventureDriver/PlayerTracker classes will remain as
 they are, needing to be instantiated, since they will have instance appropriate methods. 
 * Started working on pushing all the logic in the old main method into a separate "Adventure Driver" class, and 
 making wrapper classes for Adventure and Player to keep track of instance changes.
 * Created wrapper classes for the player and for the Adventure. Both hold logic that is relevant to the respective 
 class. For example, player class holds player stats and the adventure class has convenience methods like
 find room from string. 
     * Some issues faced where when to create strings and when to print them. I opted to print all strings in main 
     rather than having several print functions in each class, so that I would build up strings with methods and 
     return it all out
     * In addition, with my barebones implementation of main, I sketched out how the calling should work so that 
     all exceptions are reported and handled before getting to main, and only the error is printed, as well
     as what the user should do to rectify it. This ideally will be carried over into Adventure
     driver.  
 * Implemented Adventure Driver and main. Finished writing tests to check for all inputs and most command arguments
 to make sure tokenization is working
    * Because of being asked to implement runtime argument grabbing, I decided to keep some logic in main so that all print
    statements would remain in main, as well as the scanner. I didn't want to grab and use user input anywhere else in the 
    code. 
 * All tests written, will now finish writing JSON descriptions. 
 * Finished writing JSON, implementing teleport. The adventure functions as intended with
 hidden rooms, teleporting, one way rooms, and death/hunger counter all working as desired
    * Would include more statistics other than how long it takes to get to the end, but not enough
    time. 