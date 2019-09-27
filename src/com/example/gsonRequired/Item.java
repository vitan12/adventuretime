package com.example.gsonRequired;

public class Item {
    private String itemName;
    private String inventoryName;
    private boolean toBePrinted;
    private boolean edible;
    private String description;
    private boolean enabled = true;
    private String eatingInformation;

    public String getEatingInformation() {
        return eatingInformation;
    }

    public String getItemName() {
        return itemName;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isPrinted() {
        return toBePrinted;
    }

    public boolean isEdible() {
        return edible;
    }

    public String getDescription() {
        return description;
    }

    public Item() {
    }
}
