package com.hellhounds.battlefree.messaging;

/**
 * Simplified player object to be sent through a JSON message
 */
public class JsonPlayer {

    private String username;
    private int gold, steel, crystal;
    private JsonUnit[] units;

    public JsonPlayer(String username, JsonUnit[] units, int gold, int steel, int crystal)
    {
        this.username = username;
        this.units = units;
        this.gold = gold;
        this.steel = steel;
        this.crystal = crystal;
    }
}
