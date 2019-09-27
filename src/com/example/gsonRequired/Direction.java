package com.example.gsonRequired;

/**
 * Class for GSON to make Adventure objects
 */
public class Direction {

    private String directionName;
    private String directionDescription;
    private String room;
    private String enabled;
    private String[] validKeyNames;
    private boolean hidden;

    public String getDirectionName() {
        return directionName;

    }

    public String getDirectionDescription() {
        return directionDescription;
    }

    public boolean isEnabled() {
        return enabled.equalsIgnoreCase("true");
    }

    public String[] getValidKeyNames() {
        return validKeyNames;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setEnabled(Boolean isEnabled) {
        if (isEnabled) {
            enabled = "true";
        } else {
            enabled = "false";
        }
    }
    /**
     * Changed to getRoomName to avoid confusion with Room class type. Returns the room that is stored in the
     * class.
     * @return Room name as a string.
     */
    public String getRoomName() {
        return room;

    }

    public Direction() {

    }
}
