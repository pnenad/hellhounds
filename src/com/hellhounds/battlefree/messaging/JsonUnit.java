package com.hellhounds.battlefree.messaging;


/**
 * Simplified unit class for ease of sending through Json messages
 */
public class JsonUnit {

    private String unitName;
    private int health;
    private boolean activated = false;
    private Target[] primaryTargets;
    private Target[] secondaryTargets;

    public JsonUnit(String unitName, int health, boolean activated, Target[] pTargets, Target[] sTargets)
    {
        this.unitName = unitName;
        this.health = health;
        this.activated = activated;
        this.primaryTargets = pTargets;
        this.secondaryTargets = sTargets;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Target[] getPrimaryTargets() {
        return primaryTargets;
    }

    public void setPrimaryTargets(Target[] primaryTargets) {
        this.primaryTargets = primaryTargets;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Target[] getSecondaryTargets() {
        return secondaryTargets;
    }

    public void setSecondaryTargets(Target[] secondaryTargets) {
        this.secondaryTargets = secondaryTargets;
    }
}
