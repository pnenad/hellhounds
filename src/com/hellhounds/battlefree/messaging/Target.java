package com.hellhounds.battlefree.messaging;

/**
 *
 */
public class Target {

    private String targetUsername;
    private String targetUnitName;

    public Target(String targetUsername, String targetUnitName)
    {
        this.targetUsername = targetUsername;
        this.targetUnitName = targetUnitName;
    }

    public String getTargetUsername() {
        return targetUsername;
    }

    public void setTargetUsername(String targetUsername) {
        this.targetUsername = targetUsername;
    }

    public String getTargetUnitName() {
        return targetUnitName;
    }

    public void setTargetUnitName(String targetUnitName) {
        this.targetUnitName = targetUnitName;
    }
}
